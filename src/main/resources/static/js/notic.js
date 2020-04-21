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
            "	<div>" + noticList[i].title + "<label class='time'>" + noticList[i].createtime.substring(0, noticList[i].createtime.indexOf("T")) + "</label></div>" +
            "	<text class='content-box-text'>" + noticList[i].context + "</text>" +
            "</div>"

        $("#noticList").append(html);
    }
}

function toMassage(id) {
    navicatTo("noticeMassage?id=" + id)
}
