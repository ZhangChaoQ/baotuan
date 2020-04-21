var page = 1;
var index = 1;
var List = [];
$(function () {
    $(".tab-nav").click(function () {
        $(".this").removeClass("this");
        $(this).addClass("this");
        List = [];
        page = 1;
        index = $(this).index() + 1;
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
var payStatusMame = ['', '支付成功', '申請驳回', '等待审核']

function bindList() {
    $("#list").empty();
    for (var i = 0; i < List.length; i++) {
        let html =
            "<div class='bt-card'>" +
            "	<div class = 'title' >" +
            "		<label >" + typeName[index] + "</label><br>" +
            "		<label class='time'>" + new Date(DateTimeFormatter(List[i].createtime)).Format("yyyy-MM-dd") + "</label>" +
            "	</div>" +
            "	<div class = 'status' >" +
            "   	<label class='money " + (index == 1 ? 'red' : '') + "'>" + (index == 1 ? '-' : '+') + List[i].money + "</label><br>";
        if (index == 1) html += "   	<label class='status'>" + payStatusMame[List[i].brokerageStatusId] + "</label>";
        html += "	</div>" +
            "</div>";
        $("#list").append(html)
    }
}
