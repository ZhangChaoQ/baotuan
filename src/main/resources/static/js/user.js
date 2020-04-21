$(function () {
    getUserInfo();
    $("#upMember").click(function () {
        navicatTo("member");
    })
    $("#task").click(function () {
        navicatTo("task");
    })
    $("#notic").click(function () {
        navicatTo("notic");
    })
    $("#Alipay").click(function () {
        navicatTo("bindAlipay");
    })
    $("#mySurplus").click(function () {
        navicatTo("brokerage");
    })
    $("#myTeam").click(function () {
        navicatTo("myTeam");
    })
    $("#myInvite").click(function () {
        navicatTo("myInvite");
    })
    var height = $(window).innerHeight() - parseInt($(".head").css("height").replace("px",""))- parseInt($(".user").css("height").replace("px",""))- parseInt($(".slogan").css("height").replace("px",""))- parseInt($(".surplus-div").css("height").replace("px",""))- parseInt($(".tab-div").css("height").replace("px",""))-100;
    $(".list").css("height", height);
})

function getUserInfo() {
    const data = new Object();
    data.id = localStorage.getItem("userId")
    call('/baotuan/user/getUserInfo', data, function (res) {
        $("#inviter").html("推荐人：" + res.data.inviterInviteCode);
        if (res.data.memberName != null) $("#member").html(res.data.taskNumber + '任务/天  ' + res.data.memberName);
        $("#name").html('用户名：' + res.data.name);
        $("#surplus").html(res.data.money);
        localStorage.setItem("surplus", res.data.money)
        localStorage.setItem("alipayAccount", res.data.alipayAccount);
        localStorage.setItem("alipayName", res.data.alipayName);
        localStorage.setItem("alipayUrl", res.data.url);
        if (!res.data.enabled) navicatTo("index");
    })
}

function toWithdrawals() {
    navicatTo("withdrawals");
}

function loginOut() {
    localStorage.removeItem("userId");
    navicatTo("index")
}