/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function deleteSanpham(endpoint, id, btn) {
    if (confirm("Bạn chắc chắn xóa sản phẩm này không?") === true) {
        let r = document.getElementById(`row${id}`);
        let load = document.getElementById(`load${id}`);
        load.style.display = "block";
        btn.style.display = "none";
        fetch(endpoint, {
            method: 'delete'
        }).then(function (res) {
            if (res.status !== 204)
                alert("Something wrong!!!");
            load.style.display = "none";
            r.style.display = "none";
        }).catch(function (err) {
            console.error(err);
            btn.style.display = "block";
            load.style.display = "none";
        });
        alert("Bạn đã xóa món ăn thành công");
    } else
        alert("Xóa thất bại");
}


function getSanpham(endpoint, edit) {
    fetch(endpoint).then(function (res) {
        return res.json();
    }).then(function (data) {
        let d = document.getElementById("adminSanpham");
        if (d !== null) {
            let h = "";
            for (let i = 0; i < data.length; i++)
                h += `
                <tr id="row${data[i].id}">
                    <td>${data[i].id}</td>
                    <td><img src="${data[i].anh}" width="120" /></td>
                    <td>${data[i].tensanpham}</td>
                   <td>${data[i].khoiluong}</td>
                    <td>${data[i].giaSp} VND</td>
                    <td style="text-align: center;">
                        <div class="spinner-border text-info" style="display:none" id="load${data[i].id}"></div>
                        <button class="btn btn-danger" onclick="deleteSanpham('${endpoint + "/" + data[i].id}', ${data[i].id}, this)">DELETE</button>
                             <a style="margin-left:50px; min-width:75px" class="btn btn-danger" href="${edit + data[i].id}">Sửa</a>
                    </td>                    </td>
                    </td>

                </tr>
            `
            d.innerHTML = h;
        }
        let d2 = document.getElementById("loading")
        d2.style.display = "none"
    }).catch(function (err) {
        console.error(err);
    })
}


