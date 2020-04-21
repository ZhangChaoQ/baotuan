$(function () {
    getNotic()
})

function getNotic() {
    const data = new Object();
    data.id = getParam("id")
    call('/baotuan/notice/getNotice', data, function (res) {
        $("#title").html(res.data.title);
        $("#time").html(res.data.createtime.replace("T", " "));
        $("#context").html(res.data.context);
    })
}
