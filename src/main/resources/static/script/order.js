let $username = document.location.search.replace(/^.*?\=/,'');




$(document).ready(function() {
    //tar url och replace allt utom argument med "". Det blir bara argument


    $("#back").on('click', function () {
        window.location.href = "customer.html" + "?username=" + $username;

    });


});