function copyUrlDownload() {
    let range = document.createRange();
    // 传入需要选中的节点
    range.selectNodeContents(document.querySelector(".url"));
    var selection = document.getSelection();
    // 清空选中的区域
    selection.removeAllRanges();
    // 添加选中区域
    selection.addRange(range);
    // 执行复制
    document.execCommand('Copy');
    alert("复制成功");
}

$(function () {
    $(".inviteCode").html(localStorage.getItem("inviteCode"))
})

function copyUrl() {
    let range = document.createRange();
    // 传入需要选中的节点
    range.selectNodeContents(document.querySelector(".inviteCode"));
    var selection = document.getSelection();
    // 清空选中的区域
    selection.removeAllRanges();
    // 添加选中区域
    selection.addRange(range);
    // 执行复制
    document.execCommand('Copy');
    alert("复制成功");
}
