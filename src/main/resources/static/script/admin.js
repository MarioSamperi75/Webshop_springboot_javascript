function loadCustomers() {
    $.ajax({
        url: "http://localhost:8080/users"
    }).then(function(data) {
        //$('.users-table').empty()
        for(let i = 0; i< data.length; i++) {
            $('.users-table').append(
                "<tr>" +
                    "<td>" + data[i].firstname + "</td>" +
                    "<td>" + data[i].lastname + "</td>" +
                    "<td>" + data[i].address + "</td>" +
                    "<td>" + data[i].email + "</td>" +
                    "<td>" + data[i].username + "</td>" +
                    "<td>" + data[i].password + "</td>" +
                    "<td>" + data[i].role + "</td>" +
                    "<td>" + data[i].totalAmount + "</td>" +
                "</tr>");
        }
        console.log(data);
    });
}

$(document).ready(function() {
    loadCustomers();
});