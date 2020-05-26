function loadCustomers() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
        for(let i = 0; i< data.length; i++) {
            if(data[i].role !== "ADMIN") {
                $('#admin-users').append(
                    '<tr>' +
                    '<td>' + data[i].firstname + '</td>' +
                    '<td>' + data[i].lastname + '</td>' +
                    '<td>' + data[i].address + '</td>' +
                    '<td>' + data[i].email + '</td>' +
                    '<td>' + data[i].username + '</td>' +
                    '<td>' + data[i].password + '</td>' +
                    '<td>' + data[i].role + '</td>' +
                    '<td>' + data[i].totalAmount + '</td>' +
                    '<td> <button onclick="listOrdersOf(\'' + data[i].username + '\')"> Se Beställningar </button> </td>' +
                    '</tr>'
                );
            }
        }
        console.log(data);
    });
}

function listOrdersOf(customer) {
    console.log(customer);
    $.ajax({
        url: "http://localhost:8080//orderByUsername/" + customer
    }).then(function(data) {
        $('#products').empty();
        $("#product-tag").empty();
        $('#ordered-by').empty().append("Beställningar - " + customer)
        $('#orders').empty().append(
            '<tr>' +
                '<th>Beställningar</th>' +
                '<th>Databas ID</th>' +
            '</tr>'
        );
        if(data.length > 0){
            for(let i = 0; i< data.length; i++) {
                $('#orders').append(
                    '<tr>' +
                        '<td> <button onclick = "listProductsOf(this.textContent,\'' + data[i].id + '\')"> Order ' + generateOrderNumb(i) + '</button> </td>' +
                        '<td>' + data[i].id + '</td>' +
                    '</tr>'
                );
                console.log(data[i]);
            }
        }
    });
}

function generateOrderNumb(numb){
    return numb + 1;
}

function listProductsOf(orderName, orderID){
    $.ajax({
        url: "http://localhost:8080//orderByID/" + orderID
    }).then(function(data) {
        $('#product-tag').empty().append("Produkter - " + orderName)
        $('#products').empty().append(
            '<tr>' +
                '<th>Namn</th>' +
                '<th>Beskrivning</th>' +
                '<th>Pris</th>' +
            '</tr>'
        );
        for(let i = 0; i< data.order_ItemList.length; i++) {
            $('#products').append(
                '<tr>' +
                    '<td>' + data.order_ItemList[i].product.name + '</td>' +
                    '<td>' + data.order_ItemList[i].product.description + '</td>' +
                    '<td>' + data.order_ItemList[i].product.price + '</td>' +
                '</tr>'
            );
        }
    });
    console.log(orderID)
}

function logout(){
    window.location.href = "../index.html";
    $('#products').empty();
    $('#orders').empty();
}

$(document).ready(function() {
    loadCustomers();

    $("#logout-admin").on('click', function () {
        logout();
    });
});