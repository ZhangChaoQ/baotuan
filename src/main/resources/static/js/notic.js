var noticList = [];
$(function () {
    getNoticList()
})

function getNoticList() {
    call('/baotuan/notice/getNoticeList', null, function (res) {
        noticList = res.data;
        bindList()
    })
}

function bindList() {
    $("#noticList").empty();
    for (var i = 0; i < noticList.length; i++) {
        let html =
            "<div class='bt-card' onclick='toMassage(" + noticList[i].id + ")'>" +
            "	<div>" + noticList[i].title + "</div>" +
            "	<text class='content-box-text'>" + noticList[i].context + "</text>" +
            "</div>"

        $("#noticList").append(html);
    }
}

function toMassage(id) {
    navicatTo("noticMassage?id=" + id)
}
