
$(document).ready(function() {

    $('#register-form').validate({
        rules: {
            firstname: {
                required: true,
                minlength: 2
            },
            lastname: {
                required: true,
                minlength: 2
            },
            address: {
                required: true,
                minlength: 3
            },
            username: {
                required: true,
                minlength: 4
            },
            password: {
                required: true,
                minlength: 4
            },
            email: {
                required: true,
                email: true
            }

        },
        messages: {
            firstname: {
                required: 'Förnamn är obligatoriskt.',
                minlength: 'Ditt namn måste innehålla minst 2 bokstäver.'
            },
            lastname: {
                required: 'Efternamn är obligatoriskt.',
                minlength: 'Ditt efternamn måste innehålla minst 2 bokstäver.'
            },
            address: {
                required: 'Adress är obligatoriskt.',
                minlength: 'Din adress måste innehålla minst 3 bokstäver.'
            },
            username: {
                required: 'Användarnamn är obligatoriskt.',
                minlength: 'Ditt användarnamn måste vara minst 4 tecken långt.'
            },
            password: {
                required: 'Lösenord är obligatoriskt.',
                minlength: 'Ditt lösenord måste vara minst 4 tecken långt.'
            },
            email: {
                required: 'Email är obligatoriskt.',
                email: 'Du måste ange en giltig email adress.'
            },

        }
    })

    $("#register-form").submit(function( event ) {

        // Don't submit the form normally
        event.preventDefault();

        let $form = $( this ),
            firstname = $form.find( "input[name='firstname']" ).val(),
            lastname = $form.find( "input[name='lastname']" ).val(),
            address = $form.find( "input[name='address']" ).val(),
            username = $form.find( "input[name='username']" ).val(),
            password = $form.find( "input[name='password']" ).val(),
            email = $form.find( "input[name='email']" ).val();

        // Compose the data in the format that the API is expecting
        let data = {
            firstname: firstname,
            lastname: lastname,
            address: address,
            username: username,
            password: password,
            email: email,
            role: 0,
            totalAmount: 0.0
        }
        console.log(data);

        // Send the data using post
        $.ajax({
            url: 'http://localhost:8080/user/add',
            type: 'POST',
            data: JSON.stringify(data),
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            async: false,
            success: function(responseMessage){
                if(responseMessage.status) {
                    // Registrering gick bra! -> Visa responseMessage.message i 3 sek och ta sedan användaren tillbaka till index.
                    $('.register-message').empty().append(`<p>${responseMessage.message}</p>`);
                    setTimeout(function(){
                        window.location.href='http://localhost:8080/';
                        }, 3000);
                } else {
                    // Registrering gick inte bra -> visa responseMessage.message
                    console.log("Användaren har inte blivit reggad!");
                    $('.register-message').empty().append(
                        `<p>${responseMessage.message}</p>`
                    );
                }
            }
        });
    });
});
