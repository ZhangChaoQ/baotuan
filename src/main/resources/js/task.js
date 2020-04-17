var taskList = [];
var page = 1
$(function () {
    getTaskList();
})

//添加任务
function addUserTask(taskId) {
    const data = new Object();
    data.userId = $.cookie("userId");
    data.taskId = taskId;
    call('/baotuan/userTask/addUserTask', data, function (res) {
        alert(res.data.msg);
    })
}

//初始加载
function getTaskList() {
    const data = new Object();
    data.limit = 10;
    data.page = page;
    call('/baotuan/task/taskList', data, function (res) {
        for (let i = 0; i < res.data.data.records.length; i++) {
            taskList.push(res.data.data.records[i])
        }
    })
}

//下拉加载
function getNextPage() {
    page++;
    const data = new Object();
    data.limit = 10;
    data.page = page;
    call('/baotuan/task/taskList', data, function (res) {
        if (taskList.length == res.data.data.total) {
            alert("当前已是最新数据");
            return;
        }
        for (let i = 0; i < res.data.data.records.length; i++) {
            taskList.push(res.data.data.records[i])
        }
    })
}

//重新加载
function reload() {
    page = 1;
    taskList = [];
    getTaskList();
}
