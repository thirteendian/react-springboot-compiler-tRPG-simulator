function showPersonalInfo() {
    var text = document.getElementById("demo_personalInfo");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}

function showInviteInfo() {
    var text = document.getElementById("demo_inviteInfo");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}

function filter(index, id) {
    var searchBox_1 = document.getElementById(id);
    searchBox_1.addEventListener("keyup", function () {
        var keyword = this.value;
        keyword = keyword.toUpperCase();
        var table_1 = document.getElementById("table");
        var all_tr = table_1.getElementsByTagName("tr");
        for (var i = 0; i < all_tr.length; i++) {
            var name_column = all_tr[i].getElementsByTagName("td")[index];
            if (name_column) {
                var name_value = name_column.textContent || name_column.innerText;
                name_value = name_value.toUpperCase();
                if (name_value.indexOf(keyword) > -1) {
                    all_tr[i].style.display = ""; // show
                } else {
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    });
}

function deleteReminder1() {
    var text = document.getElementById("demo1");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}

function deleteReminder2() {
    var text = document.getElementById("demo1");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}

function showPlayerList() {
    var text = document.getElementById("demo_rollStr_dropDown_table");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}

function showSavedRollList(){
    var text = document.getElementById("demo_saveRollList");
    if (text.style.display === "none") {
        text.style.display = "block";
    } else {
        text.style.display = "none";
    }
}



