var page = 1;
var index = 1;
var List = [];
$(function () {
    $(".tab-nav").click(function () {
        $(".this").removeClass("this");
        $(this).addClass("this");
        List = [];
        page = 1;
        index = $(this).index + 1;
        getList();
    })
    getList();
})

function getList() {
    const data = new Object()
    data.userId = localStorage.getItem("userId");
    data.page = page;
    data.limit = 10;
    data.typeId = index;
    call('/baotuan/brokerage/getBrokerageList', data, function (res) {
        List = List.concat(res.data.records)
        bindList();
    })
}

var typeName = ['', '提款记录', '任务奖励', '分佣奖励', '邀请奖励']

function bindList() {
    $("#list").empty();
    for (var i = 0; i < List.length; i++) {
        let html =
            "<div class='bt-card'>" +
            "	<div class = 'title' >" +
            "		<label >" + typeName[index] + "</label><br>" +
            "		<label class='time'>" + new Date(DateTimeFormatter(List[i].createtime)).Format("yyyy-MM-dd") + "</label>" +
            "	</div>" +
            "	<label class='money'>" + List[i].money + "</label>" +
            "</div>";
        $("#list").append(html)
    }
}
