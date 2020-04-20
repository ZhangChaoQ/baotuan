function copyUrlDownload() {
    var Url2 = $("#url");
    Url2.select(); // 选择对象
    document.execCommand("Copy"); // 执行浏览器复制命令
    alert("复制成功");
}

$(function () {
    $(".inviteCode").html(localStorage.getItem("inviteCode"))
})

function copyUrl() {
    var Url2 = $("#inviteCode");
    Url2.select(); // 选择对象
    document.execCommand("Copy"); // 执行浏览器复制命令
    alert("复制成功");
}
