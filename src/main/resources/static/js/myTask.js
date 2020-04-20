var userTaskList = [];
var page = 1;
$(function () {
    getMyTaskList()
})

function getMyTaskList() {
    const data = new Object();
    data.id = localStorage.getItem("userId");
    data.page = page;
    data.limit = 10;
    call('/baotuan/viewUserTask/userTaskList', data, function (res) {
        if (res.data.records.length == 0) alert('无任务，请前往任务大厅接取任务');
        userTaskList = userTaskList.concat(res.data.records);
        bindMyTaskList()
    });
}

function getNextPage() {
    page++;
    data.id = localStorage.getItem("userId");
    data.page = page;
    data.limit = 10;
    call('/baotuan/viewUserTask/userTaskList', data, function (res) {
        if (res.data.total == userTaskList.length) return;
        userTaskList = userTaskList.concat(res.data.records);
        bindMyTaskList()
    });
}

function reload() {
    page = 1;
    userTaskList = [];
    getMyTaskList();
}

function bindMyTaskList() {
    $("#myTaskList").empty()
    for (var i = 0; i < userTaskList.length; i++) {
        let html =
            "<div class='bt-card'>" +
            "	<div class='task-logo-img'><image class='logo-img' src='../img/images/mipmap-hdpi/douyin-logo.png'></image></div>" +
            "	<div class='task-context'>" +
            "		<div class='text'>" +
            "			<h4>任务要求: " + userTaskList[i].context + "</h4>" +
            "			<b class='money'>" + userTaskList[i].taskMoney + "<small>元</small></b>" +
            "		</div>" +
            "	</div>" +
            "	<div class='task-money'>" +
            "		<small>需求方:" + userTaskList[i].title + "</small>" +
            "		<div class='btn-div'>" +
            "			<button class='btn-addusertask' onclick='toCommit(" + userTaskList[i].id + ")'>完成任务</button>" +
            "			<button class='btn-addusertask' onclick='openUrl(\"" + userTaskList[i].url + "\")'>打开任务链接</button></div>" +
            "	</div>" +
            "</div>";
        $("#myTaskList").append(html);
    }
}

function openUrl(url) {
    location.href = url;
}

function toCommit(id) {
    navicatTo("commitTask?id=" + id);
}