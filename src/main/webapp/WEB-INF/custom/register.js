function register() {

    var param = {

        customerId : $("#username").val(),
        hashPassword : $("#pass").val(),
        ctrlPass : $("#pass2").val()
    };

    var ser_data = JSON.stringify(param);

    $.ajax({

        type : "POST",
        contentType : 'application/json; charset=UTF-8',
        url :'addUser',
        data : ser_data,
        success : function (data) {
            if(data =='ERR_USERNAME'){
                alert("Username already exists!")
            }
            else if(data =='ERR_USERNAME2'){
                alert("Username area must be filled out!")
            }
            else if(data =='ERR_PASS'){
                alert("Passwords do not match")
            }
            else if(data == 'ERR_PASS2'){
                alert("Password areas must be filled out!")
            }else if(data == 'OK')
            {
                alert("Registration successful!")
            }
            else if(data == 'ERROR')
            {
                alert("Error , please try again!")
            }
        },
        error : function (data) {

        }

    });

}