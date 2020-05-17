function loadCustomers() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
        //$('.users-table').empty()
        for(let i = 0; i< data.length; i++) {
            $('#admin-users').append(
                '<tr>' +
                    '<td> <button id = "selected-user" onclick="listOrdersOf(this.textContent)">' + data[i].firstname +  '</button> </td>' +
                    '<td>' + data[i].lastname + '</td>' +
                    '<td>' + data[i].address + '</td>' +
                    '<td>' + data[i].email + '</td>' +
                    '<td>' + data[i].username + '</td>' +
                    '<td>' + data[i].password + '</td>' +
                    '<td>' + data[i].role + '</td>' +
                    '<td>' + data[i].totalAmount + '</td>' +
                '</tr>');
        }
        console.log(data);
    });
}

function listOrdersOf(customer) {
    console.log(customer);
}

$(document).ready(function() {
    loadCustomers();
});
