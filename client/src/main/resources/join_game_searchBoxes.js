function filter_0(index) {
    var searchBox_1 = document.getElementById("searchBox-1");
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

function filter_1(index) {
    var searchBox_1 = document.getElementById("searchBox-2");
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

function filter_2(index) {
    var searchBox_1 = document.getElementById("searchBox-3");
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

function filter_3(index) {
    var searchBox_1 = document.getElementById("searchBox-4");
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