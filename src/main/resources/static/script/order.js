//tar url och replace allt utom argument med "". Det blir bara argument
let $username = document.location.search.replace(/^.*?\=/,'');

function loadLastCart() {
    $.ajax({
        url: "http://localhost:8080//lastCart/" + $username
    }).then(function(data) {
        $('#cart-tabell').empty();
        for(let i = 0; i< data.length; i++) {
            $('#cart-tabell').append(
                    "<tr>" +
                    "<td class='col-name'>" + data[i].name + "</td>" +
                    "<td class='col-price'>" + data[i].price + " kr" +"</td>" +
                    "</tr>")
        }
    });
}



$(document).ready(function() {


    loadLastCart();


    $("#back").on('click', function () {
        window.location.href = "customer.html" + "?username=" + $username;

    });


});