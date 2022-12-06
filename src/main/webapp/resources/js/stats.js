/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */



function sanphamStats(id, cateLabels = [], cateData = []) {
    let colors = [];
    let r, g, b;
    for (let i = 0; i < cateLabels.length; i++) {
        r = parseInt(Math.random()*255);
        g = parseInt(Math.random()*255);
        b = parseInt(Math.random()*255);
        colors.push(`rgba(${r}, ${g}, ${b})`);
    }
    const data = {
        labels: cateLabels,
        datasets: [{
                label: 'Thống kê số sản phẩm',
                data: cateData,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'doughnut',
        data: data,
    };
    const ctx = document.getElementById(id).getContext('2d');
    new Chart(ctx, config);
}
function doanthusanphamChart(id, sanphamLabels = [], sanphamData = []) {
   let colors = [];
    let r, g, b;
    for (let i = 0; i < sanphamLabels.length; i++) {
        r = parseInt(Math.random()*255);
        g = parseInt(Math.random()*255);
        b = parseInt(Math.random()*255);
        colors.push(`rgba(${r}, ${g}, ${b})`);
    }
    const data = {
        labels: sanphamLabels,
        datasets: [{
                label: 'Thống kê doan thu sản phẩm',
                data: sanphamData,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data,
    };
    const ctx = document.getElementById(id).getContext('2d');
    new Chart(ctx, config);
}
function doanthusanphamMonthChart(id, sanphamLabels = [], sanphamData = []) {
   let colors = [];
    let r, g, b;
    for (let i = 0; i < sanphamLabels.length; i++) {
        r = parseInt(Math.random()*255);
        g = parseInt(Math.random()*255);
        b = parseInt(Math.random()*255);
        colors.push(`rgba(${r}, ${g}, ${b})`);
    }
    const data = {
        labels: sanphamLabels,
        datasets: [{
                label: 'Thống kê doan thu theo tháng',
                data: sanphamData,
                backgroundColor: colors,
                hoverOffset: 4
            }]
    };
    const config = {
        type: 'bar',
        data: data,
    };
    const ctx = document.getElementById(id).getContext('2d');
    new Chart(ctx, config);
}