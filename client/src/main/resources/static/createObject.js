function createFormInput(form, entryName, id) {
    var i = document.createElement("input");
    i.type = "text";
    i.name = entryName;
    i.id = id;
    form.appendChild(i);
}

function createFormCheckBox(form, entryName, id) {
    var c = document.createElement("input");
    c.type = "checkbox";
    c.id = id;
    c.name = entryName;
    form.appendChild(c);
}

function createFormButton(form, buttonName) {
    var s = document.createElement("input");
    s.type = "submit";
    s.value = buttonName;
    form.appendChild(s);
}

function createForm() {
    var f = document.createElement("form");
    f.setAttribute('method', "post");
    f.setAttribute('action', "submit.php")
    createFormInput(f, "asdf1", 1);
    createFormInput(f, "asdf2", 2);
    createFormCheckBox(f, "asdf3", 3);
    createFormButton(f, "submit");
}

$(function () {
    $("#asdf").click(function () {
        createForm();
    });
});
