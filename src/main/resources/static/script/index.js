function verifyLogin() {
    let username = $('#usernameInput').val().toLowerCase();
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

            switch(result.message) {
                case "Admin logged in":
                    window.location.href = "../templates/admin.html" + "?username=" + username;
                    console.log("Admin logged in");
                    break;
                case "Customer logged in":
                    window.location.href = "../templates/customer.html" + "?username=" + username;
                    console.log("Customer logged in");
                    break;
                default:
                    $('.login-message').empty().append(
                        `<p>Felaktigt användarnamn och/eller lösenord</p>`
                    );
                    break;
            }
        },
        error : function(e) {
            console.log('ERROR: ' + e)
        }
    });
}

$(document).ready(function() {

    $('#login').on('click', verifyLogin);

});

