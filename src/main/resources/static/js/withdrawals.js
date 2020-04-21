function checkMoney(money) {
    if (money % 100 != 0) {
        alert("金额输入错误，请重新输入")
        return false;
    }
    return true;
}

$(function () {
    $("#surplus").html(localStorage.getItem("surplus"))
})

function withdrawals() {
    var money = $("#money").val();
    if (checkMoney(parseInt(money))) {
        const data = new Object();
        data.id = localStorage.getItem("userId");
        data.money = money;
        call('/baotuan/user/withdrawals', data, function (res) {
            alert(res.msg)
            setTimeout(function () {
                navicatTo("user");
            }, 1000)
        })
    }
}
