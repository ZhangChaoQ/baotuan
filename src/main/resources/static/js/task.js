var taskList = [];
var page = 1
$(function () {
    getTaskList();
})

//添加任务
function addUserTask(taskId) {
    const data = new Object();
    data.userId = localStorage.getItem("userId");
    data.taskId = taskId;
    call('/baotuan/user/addUserTask', data, function (res) {
        alert(res.msg);
        setTimeout(function () {
            location.reload();
        }, 1000)
    })
}

//初始加载
function getTaskList() {
    const data = new Object();
    data.limit = 10;
    data.page = page;
    call('/baotuan/task/taskList', data, function (res) {
        taskList = taskList.concat(res.data.records)
        bindList();
    })
}

//下拉加载
function getNextPage() {
    page++;
    const data = new Object();
    data.limit = 10;
    data.page = page;
    call('/baotuan/task/taskList', data, function (res) {
        if (taskList.length == res.data.total) {
            alert("当前已是最新数据");
            return;
        }
        taskList = taskList.concat(res.data.records)
        bindList();
    })
}

//重新加载
function reload() {
    page = 1;
    taskList = [];
    getTaskList();
}

//绑定列表
function bindList() {
    $("#taskList").empty();
    for (let i = 0; i < taskList.length; i++) {
        const html =
            "<div class='bt-card'>" +
            "	<div class='task-logo-img'><image class='logo-img' src='../img/images/mipmap-hdpi/douyin-logo.png'></image></div>" +
            "	<div class='task-context'>" +
            "		<div class='text'>" +
            "			<h4>任务要求: " + taskList[i].context + "<br><small>需求方:" + taskList[i].title + "<br><small class='surplus'>剩余: " + taskList[i].surplus + "</small></small></h4>" +
            "		</div>" +
            "	</div>" +
            "	<div class='task-money'>" +
            "		<div class='money'>" +
            "			<b>" + taskList[i].money + "<small>元</small></b>" +
            "		</div>" +
            "		<div class='btn-div'><button class='btn-addusertask' onclick='addUserTask(" + taskList[i].id + ")'>接任务</button></div>" +
            "	</div>" +
            "</div>";
        $("#taskList").append(html);
    }
}
