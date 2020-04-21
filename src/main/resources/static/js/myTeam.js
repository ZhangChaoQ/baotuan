var index = 1;
var List = [];
$(function () {
    $(".tab-nav").click(function () {
        $(".this").removeClass("this");
        $(this).addClass("this");
        List = [];
        page = 1;
        index=$(this).index()+1;
        getList();
    })
    getList();
})
var type = ['', 'getSonList', 'getGradSonList']

function getList() {
    const data = new Object()
    data.id = localStorage.getItem("userId");
    call('/baotuan/user/' + type[index], data, function (res) {
        List = List.concat(res.data)
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
