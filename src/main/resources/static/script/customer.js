
function loadProducts() {
    $.ajax({
        url: "http://localhost:8080/products"
    }).then(function(data) {
        $('.product-block').empty()
        for(let i = 0; i< data.length; i++) {
            $('.product-block').append(
                "<div class='product'>" +
                data[i].name + "<br>" +
                data[i].description + "<br>" +
                data[i].price + " kr" + "<br>" +
                "<input class='add' type='submit' value='Lägg i kundvagnen'/>" + "<br>" + "<br>" +
                "</div>");
        }
        console.log(data);
    });
}

$(document).ready(function() {
    loadProducts();

});