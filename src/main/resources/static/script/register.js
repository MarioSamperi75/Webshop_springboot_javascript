
$(document).ready(function() {


    $("#register-form").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        // Get some values from elements on the page
       // var firstname = $('#firstname').text();

        var $form = $( this ),
            firstname = $form.find( "input[name='firstname']" ).val(),
            lastname = $form.find( "input[name='lastname']" ).val(),
            address = $form.find( "input[name='address']" ).val(),
            username = $form.find( "input[name='username']" ).val(),
            password = $form.find( "input[name='password']" ).val(),
            email = $form.find( "input[name='email']" ).val();

        // Compose the data in the format that the API is expecting
        var data = { firstname: firstname, lastname: lastname, address: address, username: username,
                password: password, email: email, role: 0, totalAmount: 0.0}
                console.log(data);
        // Send the data using post
        $.ajax({
            url: 'http://localhost:8080/user/add',
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

    });
});
