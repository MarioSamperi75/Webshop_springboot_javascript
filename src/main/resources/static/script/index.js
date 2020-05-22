
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
        let  $role= $("#usernameInput").val();
        if ($role == "admin")
            window.location.href = "../templates/admin.html" + "?username=" + $role;
        else
            window.location.href = "../templates/customer.html" + "?username=" + $role;

    });
});

