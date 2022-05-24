// single column
var searchBox_1 = document.getElementById("searchBox-1");
searchBox_1.addEventListener("keyup", function(){
    var keyword = this.value;
    keyword = keyword.toUpperCase();
    var table_1 = document.getElementById("table-1");
    var all_tr = table_1.getElementsByTagName("tr");
    for(var i=0; i<all_tr.length; i++){
        var name_column = all_tr[i].getElementsByTagName("td")[0];
        if(name_column){
            var name_value = name_column.textContent || name_column.innerText;
            name_value = name_value.toUpperCase();
            if(name_value.indexOf(keyword) > -1){
                all_tr[i].style.display = ""; // show
            }else{
                all_tr[i].style.display = "none"; // hide
            }
        }
    }
});

// multiple column
var searchBox_2 = document.getElementById("searchBox-2");
searchBox_2.addEventListener("keyup",function(){
    var keyword = this.value;
    keyword = keyword.toUpperCase();
    var table_2 = document.getElementById("table-2");
    var all_tr = table_2.getElementsByTagName("tr");
    for(var i=0; i<all_tr.length; i++){
        var name_column = all_tr[i].getElementsByTagName("td")[0];
        var email_column = all_tr[i].getElementsByTagName("td")[1];
        if(name_column && email_column){
            var name_value = name_column.textContent || name_column.innerText;
            var email_value = email_column.textContent || email_column.innerText;
            name_value = name_value.toUpperCase();
            email_value = email_value.toUpperCase();
            if((name_value.indexOf(keyword) > -1) || (email_value.indexOf(keyword) > -1)){
                all_tr[i].style.display = ""; // show
            }else{
                all_tr[i].style.display = "none"; // hide
            }
        }
    }
})



// All column
var searchBox_3 = document.getElementById("searchBox-3");
searchBox_3.addEventListener("keyup",function(){
    var keyword = this.value;
    keyword = keyword.toUpperCase();
    var table_3 = document.getElementById("table-3");
    var all_tr = table_3.getElementsByTagName("tr");
    for(var i=0; i<all_tr.length; i++){
        var all_columns = all_tr[i].getElementsByTagName("td");
        for(j=0;j<all_columns.length; j++){
            if(all_columns[j]){
                var column_value = all_columns[j].textContent || all_columns[j].innerText;

                column_value = column_value.toUpperCase();
                if(column_value.indexOf(keyword) > -1){
                    all_tr[i].style.display = ""; // show
                    break;
                }else{
                    all_tr[i].style.display = "none"; // hide
                }
            }
        }
    }
})