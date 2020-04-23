var index = 1;
var List = [];
var page = 1;
var limit=20;
var nowHeight=$(window).height();
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
    $("#list").scroll(function() {
        var scrollTop = $(this).scrollTop();
        var scrollHeight = $(document).height();
        if (scrollTop + scrollHeight > nowHeight) { //判断滑动到底部了
            getNextPage();
            nowHeight+=scrollHeight;
        }
    });
})
var type = ['', 'getSonList', 'getGradSonList']

function getList() {
    const data = new Object()
    data.id = localStorage.getItem("userId");
    data.page = page;
    data.limit = limit;
    call('/baotuan/user/' + type[index], data, function (res) {
        List = List.concat(res.data.records)
        bindList();
    })
}

function getNextPage() {
    page++;
    const data = new Object()
    data.id = localStorage.getItem("userId");
    data.page = page;
    data.limit = limit;
    call('/baotuan/user/' + type[index], data, function (res) {
        List = List.concat(res.data.records);
        bindList();
    })
}

function bindList() {
    $("#list").empty();
    for (var i = 0; i < List.length; i++) {
        let html =
            "<div class='bt-card'>" +
            "	<div class = 'title' >" +
            "		<label >" + List[i].code + "</label><br>" +
            "		<label>" + format(List[i].phone) + "</label>&nbsp;&nbsp;&nbsp;&nbsp;" +
            "		<label class='time'>" + DateTimeFormatter(List[i].createtime) + "</label>" +
            "	</div>" +
            "	<label class='money'>" + List[i].memberName + "</label>" +
            "</div>";
        $("#list").append(html)
    }
}

function format(str) {
    return str.substring(0, 3) + "****" + str.substring(7);
}
