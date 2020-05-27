
/*let $role = null;

function getCustomer() {
    $.ajax({
        url: "http://localhost:8080//userByUsername/" + username
    }).then(function(data) {
        $role= data.role;
        console.log($role);
    });
}*/


function verifyLogin() {
    let username = $('#usernameInput').val();
    let password = $('#passwordInput').val();
    console.log('username: ' + username);
    console.log('password: ' + password);

    // let payload = {username, password}
    let payload = {'username': username, 'password': password}
    $.ajax({
        url: 'http://localhost:8080/login',
        type: 'POST',
        data: JSON.stringify(payload),
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        async: false,
        success: function(result){
            console.log('success?? result: ' + result);
        },
        error : function(e) {
            console.log('ERROR: ' + e)
            // href="index.html //redirect:/
        }
    });
}

$(document).ready(function() {



    $('#login').on('click', function () {
        let  $username= $("#usernameInput").val();
        if ($username == "admin")  // det kommer att bli role == role.ADMIN
            window.location.href = "../templates/admin.html" + "?username=" + $username;
        else
            window.location.href = "../templates/customer.html" + "?username=" + $username;

    });
});

