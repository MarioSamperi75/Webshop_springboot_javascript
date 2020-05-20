function loadCustomers() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
        //$('.users-table').empty()
        for(let i = 0; i< data.length; i++) {
            if(data[i].role !== "ADMIN") {
                $('#admin-users').append(
                    '<tr>' +
                        '<td>' + data[i].firstname + '</td>' +
                        '<td>' + data[i].lastname + '</td>' +
                        '<td>' + data[i].address + '</td>' +
                        '<td>' + data[i].email + '</td>' +
                        '<td> <button id = "selected-user" onclick="listOrdersOf(this.textContent)">' + data[i].username +  '</button> </td>' +
                        '<td>' + data[i].password + '</td>' +
                        '<td>' + data[i].role + '</td>' +
                        '<td>' + data[i].totalAmount + '</td>' +
                    '</tr>'
                );
            }
        }
        console.log(data);
    });
}

function listOrdersOf(customer) {
    $.ajax({
        url: "http://localhost:8080//orderByUsername/" + customer
    }).then(function(data) {
        $('#orders').empty();
        $('#orders').append(
            '<tr>' +
                '<th>Orders</th>' +
                '<th>Database ID</th>' +
            '</tr>'
        );
        if(data.length > 0){
            for(let i = 0; i< data.length; i++) {
                $('#orders').append(
                    '<tr>' +
                    '<td> <button name="' + data[i].id + '" onclick = "console.log(this.name)"> Order ' + generateOrderNumb(i) + '</button> </td>' +
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

$(document).ready(function() {
    loadCustomers();
});
