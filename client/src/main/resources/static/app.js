var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
        $("#magicCheckTable").show();
    }
    else {
        $("#conversation").hide();
        $("#magicCheckTable").hide();
    }
    $("#results").html("");
    $("#magicCheckResult").html("");
}

function connect() {
    var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/dicerolling/result', function (RespDiceRollingResult) {
            showResult(JSON.parse(RespDiceRollingResult.body).content);
            showMagicCheck(JSON.parse(RespDiceRollingResult.body).magicCheckList);
        });
    });
}

function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}

function sendRawString() {
    var checkbox = document.getElementById('magicCheckbox');
    var ifMagicCheck = false;
    if(checkbox.checked){
        ifMagicCheck=true;
    }
    stompClient.send("/app/dicerolling_result", {}, JSON.stringify({'rawString': $("#rawstring").val(),'magicCheck': ifMagicCheck}));
}

function showResult(message) {
    $("#results").append("<tr><td>" + message + "</td></tr>");
}

function showMagicCheck(megicCheckList){
    var table = document.getElementById('magicCheckResult');
    for(var i = 0; i< megicCheckList.length;i++){
        table.innerHTML += megicCheckList[i].data;
    }
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#sendrawstring" ).click(function() { sendRawString(); });
});