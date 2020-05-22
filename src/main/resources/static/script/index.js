
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

/*function updateMultiplication() {
    $.ajax({
        url: "http://localhost:8080/multiplications/random"
    }).then(function(data) {
        // Cleans the form
        $("#attempt-form").find( "input[name='result-attempt']" ).val("");
        $("#attempt-form").find( "input[name='user-alias']" ).val("");
        // Gets a random challenge from API and loads the data in the HTML
        $('.multiplication-a').empty().append(data.factorA);
        $('.multiplication-b').empty().append(data.factorB);
    });
}

function updateStats(alias) {
    $.ajax({
        url: "http://localhost:8080/results?alias=" + alias,
    }).then(function(data) {
        $('#stats-body').empty();
        data.forEach(function(row) {
            $('#stats-body').append('<tr><td>' + row.id + '</td>' +
                '<td>' + row.multiplication.factorA + ' x ' + row.multiplication.factorB + '</td>' +
                '<td>' + row.resultAttempt + '</td>' +
                '<td>' + (row.correct === true ? 'YES' : 'NO') + '</td></tr>');
        });
    });
}

$(document).ready(function() {

    updateMultiplication();

    $("#attempt-form").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
        var a = $('.multiplication-a').text();
        var b = $('.multiplication-b').text();
        var $form = $( this ),
            attempt = $form.find( "input[name='result-attempt']" ).val(),
            userAlias = $form.find( "input[name='user-alias']" ).val();

        // Compose the data in the format that the API is expecting
        var data = { user: { alias: userAlias}, multiplication: {factorA: a, factorB: b}, resultAttempt: attempt};

        // Send the data using post
        $.ajax({
            url: '/results',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            async: false,
            success: function(result){
                if(result.correct) {
                    $('.result-message').empty().append("The result is correct! Congratulations!");
                } else {
                    $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
                }
            }
        });

        updateMultiplication();

        updateStats(userAlias);
    });
});
*/