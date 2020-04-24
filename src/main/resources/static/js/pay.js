var money = 0
var name = ""
var memberId=-1
$(function () {
    money = getParam("money");
    memberId = parseInt(getParam("memberId"));
    name = decodeURI(getParam("name"));
    $("#title").html("成为" + name);
    $("#payMoney").html("支付金额：" + money + "元");
    call("/baotuan/payImg/getPayImgByEnabled", null, function (res) {
        $("#payImg").attr("src", app.filePath + res.data.url)
    })
})

function pay() {
    const data = new Object();
    data.payMoney = money;
    data.content = name;
    data.memberId=memberId;
    data.payCode = $("#payCode").val();
    data.userId = localStorage.getItem("userId")
    call("/baotuan/payInfo/addPay", data, function (res) {
        alert(res.msg);
        setTimeout(function () {
            navicatTo("member")
        }, 1000)
    })
}
