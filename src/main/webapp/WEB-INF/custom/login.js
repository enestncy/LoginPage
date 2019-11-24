function login() {

    var param = {

        customerId : $("#username").val(),
        hashPassword : $("#pass").val(),

    };

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8' ,
        url:'controlUser',
        data:ser_data,
        success: function(data){
            if(data =='OK'){
                $(location).attr('href' , 'index')
            }
            else if(data == 'ERR_PASS') {
                alert("Password is incorrect!")
            }
            else if(data == 'BLOCKED'){
                alert("User had been blocked")
            }
            else if(data == 'INACTIVE'){
                alert("User had been deleted")
            }
            else if(data == 'ERROR'){
                alert("Username or password is incorrect!")
            }
        },
        error:function(data){
            alert(data);
        }
    });
}

