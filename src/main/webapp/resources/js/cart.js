/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function addToCart(endpoint, sanphamId, ten, gia, anh) {
    event.preventDefault();
    fetch(endpoint, {
        method: 'post',
        body: JSON.stringify({
            "sanphamId": sanphamId,
            "tensanpham": ten,
            "gia": gia,
            "anh": anh,
            "soLuong": 1
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data;
    });
}

function updateCart(endpoint, obj, sanphamId) {
    fetch(endpoint, {
        method: "put",
        body: JSON.stringify({
            "sanphamId": sanphamId,
            "tensanpham": "",
            "gia": 0,
            "anh": "",
            "soLuong": obj.value
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data) {
        let counter = document.getElementById("cartCounter");
        counter.innerText = data.counter;
        location.reload();

    });
}

function deleteCartItem(sanphamId) {
    event.preventDefault();
    if (confirm("Bạn chắc chắn xóa sản phẩm này không?") === true) {
        fetch(`/onlinefoods/api/cart/${sanphamId}`, {
            method: "delete"
        }).then(function (res) {
            return res.json();
        }).then(function (data) {
            let counter = document.getElementById("cartCounter");
            counter.innerText = data.counter;
            let amount = document.getElementById("amountCart");
            amount.innerText = data.amount;
            location.reload();
        });
    }
}
function pay(endpoint) {
    event.preventDefault();
    if (confirm("Ban chac chan thanh toan?") === true) {
        fetch(endpoint, {
            method: "post",
            body: JSON.stringify({
                "diachi": document.getElementById("diachi").value,
                "sodienthoai": document.getElementById("sodienthoai").value,
                "ghichu": document.getElementById("ghichu").value
            }),
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function (res) {
            return res.json();
        }).then(function (code) {
            console.info(code);
            location.reload();
        });
        alert("Bạn đã mua hàng thành công");
    } else
        alert("Bạn chưa đặt hàng!!!");
}