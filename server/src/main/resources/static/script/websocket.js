$(document).ready(function () {
    connect();
})

var stompClient = null;
function connect() {
    var myuuid = $("#myuuid").val();
    var socket = new SockJS('/admin_endpoint');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);
        //Subscribe to my special channel
        stompClient.subscribe('/admin/jvminfo', function (SingleMessage) {
            var receivedMessage = JSON.parse(SingleMessage.body);
            $("#received_message").append("<tr><td>INFO: "+ receivedMessage.message+"</td></tr>");
        });
    });
}

function sendTestMessage(){
    var chatuuid = $("#chatuuid").val();
    var myuuid=$("#myuuid").val();
    var content =$("#content").val();
 stompClient.send("/admin/schedule/jvminfo",{},JSON.stringify(
     {"from":myuuid,
            "to": chatuuid,
            "content":content}))
}

