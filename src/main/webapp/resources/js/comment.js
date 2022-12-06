/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


/* global fetch, moment */

function addCommentSanpham(endpoint, idsp) {
    fetch(endpoint, {
        method: "post",
        body: JSON.stringify({
            "content": document.getElementById("contentId").value,
            "sanphamid": idsp
        }),
        headers: {
            "Content-Type": "application/json"
        }
    }).then(function (res) {
        return res.json();
    }).then(function (data)
    {
        location.reload();
    });
}

function deleteComment(endpoint, id, btn) {
    let r = document.getElementById(`row${id}`);
    fetch(endpoint, {
        method: 'delete'
    }).then(function (res) {
        if (res.status !== 204)
            alert("Something wrong!!!");
        r.style.display = "none";
    }).catch(function (err) {
        console.error(err);
    });
}


function loadCommentsSp(da) {
    fetch(da).then(function (res) {
        return res.json();
    }).then(function (data) {
        let c = document.getElementById("comments");
        var r = document.getElementById("xoabinhluan");
        let h = '';
        for (let d of data)
            h += `
           
               <div style= "margin-top:15px" id="row${d.id}">
                              <div class="d-flex flex-start">
                                <img class="rounded-circle shadow-1-strong me-3"
                                  src="${d.nguoibinhluan.avatar}" alt="avatar" width="60"
                                  height="60" />
                                <div>
                                  <h6 class="fw-bold mb-1">${d.nguoibinhluan.username}</h6>
                                  <div class="d-flex align-items-center mb-3">
                                    <p class="mb-0">
                                     ${moment(d.ngaybinhluan).locale("vi").fromNow()}
                                    </p>
                                  </div>
                                  <p class="mb-0">
                                   ${d.noidung}
                                  </p>
                                </div>
                                                                 
                  </div>
            `;
        c.innerHTML = h;
    });
}
