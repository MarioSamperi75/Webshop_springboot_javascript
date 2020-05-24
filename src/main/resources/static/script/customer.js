let $username = document.location.search.replace(/^.*?\=/,'');
let $productList = [];
let $total = 0;

function addItemToCart(name, price) {

    // adderar till listan productname som vi ska skicka till controllern
    $productList.push(name);

    // addera en rad till varukorg
    $('.cart-tabell').append(
        `<tr>
            <td class='col-name'>${name}</td>
            <td class='col-price'>${price} kr</td>
        </tr>`);

    //uppdaterar variabel total
    $total = Number($total) + Number(price);
    $('.total').empty().append($total);
}
function searchProduct() {
    let $input = $('#search-input').val().trim();
    let $foundProducts = $('.found-products');
    $.ajax({
        url: `http://localhost:8080/searchProductContaining/${$input}`,
        type: 'GET',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        async: false,
        success: function(products) {
            $foundProducts.empty();
            for (let i = 0; i < products.length; i++) {
                console.log(products[i]);
                $foundProducts.append(
                    `<div class='found-product'>
                         <p>${products[i].name}</p>
                         <p>${products[i].description}</p>
                         <p>${products[i].price} kr</p>
                         <input class='addSearchedItem' type='submit' value='Lägg i kundvagnen'>
                     </div>`
                )}

            // Lägger till eventlyssnare för varje hittat produkts knappar
            let addSearchedItemBtns = document.querySelectorAll('.addSearchedItem');
            addSearchedItemBtns.forEach(btn => {
                btn.addEventListener('click', e => {
                    // Ta ut namn och pris för hittat vara, för att kunna skicka vidare till addItemToCart()
                    let productName = e.target.closest('.found-product').firstElementChild.innerHTML;
                    let productPrice = e.target.previousElementSibling.innerHTML;
                    productName.trim();
                    productPrice = productPrice.trim().substr(0, productPrice.indexOf(' '));

                    addItemToCart(productName, productPrice);
                });
            })
        }
    });
}

function loadProducts() {
    $.ajax({
        url: "http://localhost:8080/products"
    }).then(function(data) {
        $('.product-block').empty().append("<h1>Produkter</h1>");
        for(let i = 0; i< data.length; i++) {
            $('.product-block').append(
                "<div class='product'>" +
                "<label class='name'>" +  data[i].name + "<br>" + "</label>" +
                data[i].description + "<br>" +
                "<label class='price'>" +  data[i].price  + "</label>" + " kr" + "<br>" +
                "<input class='add' type='submit' value='Lägg i kundvagnen'/>" + "<br>" + "<br>" +
                "</div>");
        }
    });
}

function loadUser() {
    $.ajax({
        url: "http://localhost:8080//userByUsername/" + $username
    }).then(function(data) {

        $('.logout-block').empty().append("<label>Användarnamn: " + data.username + " <label/>" +
                                          "<br/><label>Användarroll: " + data.role +" <label/> <br/><br/><br/><br/>" +
                                          "<button class = 'logout-btn'>Logga ut</button>");

        console.log("data:  " + data.username + " " + data.role);
    });
}

function clearCart() {

    $total = 0;
    $('.cart-tabell').empty();
    $productList = [];
    $('.total').empty().append($total);

}

$(document).ready(function() {

    loadProducts();
    loadUser();

    $("#buy").on('click', function () {
        if  ($total!=0) {           //inte skicka en tom order!!!)
            var data = {username: $username, productList: $productList, total: $total}
            // skicka inputpaket(data object)
            // todo: beräkna och lägga till total i paketet
            $.ajax({
                url: 'http://localhost:8080/user/addNewOrder',
                type: 'POST',
                data: JSON.stringify(data),
                contentType: "application/json; charset=utf-8",
                dataType: "json",
                async: false,
                success: function (result) {
                    if (result.correct) {
                        $('.result-message').empty().append("The result is correct! Congratulations!");
                    } else {
                        $('.result-message').empty().append("Ooops that's not correct! But keep trying!");
                    }
                }

            });
            clearCart();
        }
    });


    $("#product-block").on('click', ".add", function () {
        //fångar text med productnamnet
        let $name = $(this).siblings('label.name').text();
        let $price = $(this).siblings('label.price').text();

        addItemToCart($name, $price)
    });

    $('#search-btn').on('click', searchProduct);


});