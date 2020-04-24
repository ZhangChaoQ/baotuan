var memberList = [];
$(function () {
    getMemberList();
    getUserInfo();
})

function getUserInfo() {
    const data = new Object();
    data.id = localStorage.getItem("userId")
    call('/baotuan/user/getUserInfo', data, function (res) {
        localStorage.setItem("memberId", res.data.memberId);
        localStorage.setItem("userMemberMoney", res.data.userMemberMoney);
    })
}

function getMemberList() {
    const data = new Object();
    call('/baotuan/member/memberList', data, function (res) {
        memberList = memberList.concat(res.data);
        bindList();
    });
}

function bindList() {
    $("#memberList").empty()
    for (var i = 0; i < memberList.length; i++) {
        let html =
            "<div class='bt-card member-div'>" +
            "	<div class='vip-logo'>" +
            "		<image class='logo-vip' src='../img/images/mipmap-hdpi/vip.png'></image>" +
            "	</div>" +
            "	<div class='task-context'>" +
            "		<div class='title'>" +
            "			<h4-small>" + memberList[i].name + "<big><big>" + memberList[i].money + '元' + "</big></big></h4-small>" +
            "		</div>" +
            "		<div class='subtitle'>" +
            "			<h4-small>" + memberList[i].context + "(剩余10个)</h4-small>" +
            "		</div>" +
            "	</div>" +
            "	<div class='task-money'>" +
            "		<div>" +
            "			<button class='btn-updateusermember' onclick='checkUp(" + memberList[i].id + "," + memberList[i].money + ",\"" + memberList[i].name + "\")'>立即购买</button>" +
            "		</div>" +
            "	</div>" +
            "</div>"
        $("#memberList").append(html)
    }
}

function checkUp(id, money, name) {
    let memberId = localStorage.getItem("memberId");
    let userMemberMoney = localStorage.getItem("userMemberMoney");
    if (memberId > id) {
        alert('您的会员等级高于此会员，请重新选择');
    } else if (memberId == id) {
        alert('这是您当前会员等级，请重新选择');
    } else {
        navicatTo('pay?money=' + (money - userMemberMoney) + "&name=" + encodeURI(name)+"&memberId="+id);
    }
}
