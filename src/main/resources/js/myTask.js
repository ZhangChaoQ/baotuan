var usertaskList = [];
var page = 1;
$(function () {
    getMyTaskList()
})

function getMyTaskList() {
    const data = new Object();
    data.id = $.cookie("userId");
    data.page = page;
    data.limit = 10;
    call('/baotuan/viewUserTask/userTaskList', data, function (res) {
        if (res.data.data.length == 0) alert('任务已完成');
        usertaskList = res.data.data;
    });
}

function getNextPage() {
    page++;
    data.id = $.cookie("userId");
    data.page = page;
    data.limit = 10;
    call('/baotuan/viewUserTask/userTaskList', data, function (res) {
        if (res.data.data.total == usertaskList.length) return;
        usertaskList = res.data.data;
    });
}