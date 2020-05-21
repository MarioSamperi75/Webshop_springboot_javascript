
function loadProducts() {
    $.ajax({
        url: "http://localhost:8080/products"
    }).then(function(data) {
        $('.product-block').empty()
        $('.product-block').append("<h1>Produkter</h1>");
        for(let i = 0; i< data.length; i++) {
            $('.product-block').append(
                "<div class='product'>" +
                "<p class='name'>" +  data[i].name + "<br>" + "</p>" +
                data[i].description + "<br>" +
                "<p class='price'>" +  data[i].price  + "</p>" + " kr" + "<br>" +
                "<input class='add' type='submit' value='Lägg i kundvagnen'/>" + "<br>" + "<br>" +
                "</div>");
        }
        console.log(data);
    });
}

$(document).ready(function() {

    let $username = "customer";
    let $productList = [];
    let $total = 0;

    loadProducts();

    $("#buy").on('click', function () {

        var data = { username: $username, productList: $productList}
        // skicka inputpaket(data object)
        // todo: beräkna och lägga till total i paketet
        $.ajax({
            url: 'http://localhost:8080/user/addNewOrder',
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
        //clear (det kan bli egen funktion)
        $total = 0;
        $('.cart-tabell').empty();
        $productList = [];
        $('.total').empty().append($total);



    });


    $("#product-block").on('click', ".add", function () {
        //fångar text med productnamnet
        $name = $(this).siblings('p.name').text();
        $price = $(this).siblings('p.price').text();


        // adderar till listan productname som vi ska skicka till controllern
        $productList.push($name)

        // addera en rad till varukorg
        $('.cart-tabell').append
            ("<tr>" +
                "<td class='col-name'>" + $name + "</td>" +
                "<td class='col-price'>" + $price + " kr" +"</td>" +
            "</tr>");

        //uppdaterar variabel total
        $total = Number($total) + Number($price);
        $('.total').empty().append($total);
        console.log("total: " + $total);





    });



});