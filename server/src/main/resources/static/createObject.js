/**
 * Following js code require package
 *     <script src="/webjars/jquery/jquery.min.js"></script>
 *     <script src="/webjars/sockjs-client/sockjs.min.js"></script>
 *     <script src="/webjars/stomp-websocket/stomp.min.js"></script>
 */
$(document).ready(function () {
    connectObjectCreateSocket();
})

var stompClient = null;

function connectObjectCreateSocket() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        stompClient.subscribe('/objectcreate/field', function (RespObjectCreatingField) {
            var objectField = JSON.parse(RespObjectCreatingField.body).objectField;
            var fieldType = new Map(Object.entries(JSON.parse(RespObjectCreatingField.body).fieldType));
            createForm(objectField, fieldType);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    console.log("Disconnected");
}

function createFormInput(parent, id) {
    var i = document.createElement("input");
    i.type = "text";
    i.name = id;
    i.id = id;
    parent.appendChild(i);
}

function createFormCheckBox(parent, id) {
    var c = document.createElement("input");
    c.type = "checkbox";
    c.id = id;
    c.name = id;
    parent.appendChild(c);
}

function createFormSubmitButton(parent, buttonName, id) {
    var s = document.createElement("input");
    s.type = "submit";
    s.value = buttonName;
    s.id = id;//ID should be unique!//TODO:
    parent.appendChild(s);
}

function createFormDropDown(parent, arrayList, id) {
    var select = document.createElement("select");
    select.name = id;
    select.id = id;
    for (const val of arrayList) {
        var option = document.createElement("option");
        option.value = val;
        option.text = val;
        select.appendChild(option);
    }
    parent.appendChild(select);
}


/**
 * create HTML Form element
 * @param parent parent js structure handler
 * @param labelName the name of label
 */
function createFormLabel(parent, labelName) {
    var label = document.createElement("label");
    label.innerHTML = labelName + ": ";
    parent.appendChild(label);
}

/**
 * generate form according to recursive structure
 * @param objectFieldType The self FK recursive object contains recursive structure
 * @param parent The parent js structure handler
 * @param parentIdIndex The parent ID's index for generating element id
 * Example of objectFieldType:
 * {"id":..., "k":prim/option/array, "name":null/int/string/...., "elem":None or objectFieldType}
 * Note that if "elem" = NONE means no recursive structure, if elem != None then recursive structure
 */
function generateForm(parent, objectFieldType, parentIdIndex, recursiveCounter) {
    var br = document.createElement("br");
    if (objectFieldType.k == "prim") {
        createFormInput(parent, parentIdIndex + "_input");
        parent.appendChild(br);
    } else if (objectFieldType.k == "option") {
        createFormCheckBox(parent, parentIdIndex + "_" + recursiveCounter + "_checkbox");
        if (objectFieldType.elem != null) {
            var recursiveObjectFieldType = objectFieldType.elem;
            console.log("ID = " + JSON.stringify(objectFieldType.id) + "\n objectFieldType.elem=" + JSON.stringify(recursiveObjectFieldType));
            generateForm(parent, recursiveObjectFieldType, parentIdIndex, recursiveCounter + 1);
        }
    } else if (objectFieldType.k == "array") {
        // if type is array, recursive structure
        var recursiveObjectFieldType = objectFieldType.elem;
        console.log("ID = " + JSON.stringify(objectFieldType.id) + "\n objectFieldType.elem =" + JSON.stringify(recursiveObjectFieldType));
        var arrayCounter = 0;
        var addMoreButton = document.createElement("button");
        addMoreButton.value = "add";
        addMoreButton.type = "button";
        addMoreButton.id = parentIdIndex + "_" + recursiveCounter + "_addButton";
        addMoreButton.onclick = function () {
            arrayCounter += 1;
            var newParentIdIndex = parentIdIndex + "_array_" + arrayCounter;
            var div = document.createElement("div");
            div.id = newParentIdIndex + "_div";
            generateForm(div, recursiveObjectFieldType, newParentIdIndex, recursiveCounter + 1);
            parent.appendChild(div);
        }
        parent.appendChild(addMoreButton);
        parent.appendChild(br);
    } else if (objectFieldType.k == "user") {
        var addMoreButton = document.createElement("button");
        addMoreButton.value = "create";
        addMoreButton.type = "button";
        addMoreButton.id = parentIdIndex + "_userButton";
        addMoreButton.onclick = function () {
            console.log("onClick submit user object name");
            var userObjectName = objectFieldType.name;
            sendObjectName(userObjectName);
        }
        parent.appendChild(addMoreButton)
    }
}

/**
 * The object Form was created based on type
 * id prefix= object_form_
 * @param objectField list order of objects. Subscribed by connectObjectCreateSocket(), RespObjectCreatingField's field
 * @param fieldType hashmap of object type. Subscribed by connectObjectCreateSocket(), RespObjectCreatingField's field
 */
function createForm(objectField, fieldType) {
    var f = document.createElement("form");
    f.setAttribute('method', "post");
    f.setAttribute('action', "submit.php");
    var formID = "object_form_";
    for (i = 0; i < objectField.length; i++) {
        formID = formID + i;
        //Create div
        var div = document.createElement("div");
        div.id = formID + "_div";
        //Create Label:
        createFormLabel(div, objectField[i]);
        //generate form structure
        generateForm(div, fieldType.get(objectField[i]), formID, 0);
        //Create Space
        console.log("The objectField of "+ objectField[i]);
        f.appendChild(div);
    }
    document.getElementsByTagName('body')[0].appendChild(f); //pure javascript
}

function sendObjectName(objectName) {
    stompClient.send("/app/createobject_name", {}, JSON.stringify({
        'objectName': objectName
    }));
}

$(function () {
    $("form").on('submit', function (e) {
        //select in object.html
        var select = document.getElementById("objectName");
        var objectName = select.value;
        console.log("onClict submit objectName: " + objectName);
        sendObjectName(objectName);
        e.preventDefault();
    });
});