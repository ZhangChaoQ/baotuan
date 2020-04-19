var counts = 60;

function checkPhone(phone) {
    alert(phone)
    if (!/^1[3456789]\d{9}$/.test(phone)) {
        alert("手机号格式错误,请检查输入")
        return false;
    }
    return true;
}

function settime(val) {
    if (counts == 0) {
        val.removeAttribute("disabled");
        val.value = "获取验证码";
        counts = 60;
        return false;
    } else {
        val.setAttribute("disabled", true);
        val.value = "重新发送（" + counts + "）";
        counts--;
    }
    setTimeout(function () {
        settime(val);
    }, 1000);
}

var mailcode = '';
$(function () {
    //获取验证码
    $("#verCodeBtn").click(function () {
        const phone = $("#phone").val()
        if (checkPhone(phone)) {
            const data = new Object();
            data.phone = phone;
            call('/baotuan/sendMsg/sendmsg', data, function (res) {
                mailcode = rest.data.data.code;
            })
        }
    });
})

function Login() {
    const phone = $("#phone").val()
    const code = $("#password").val()
    const data = new Object();
    data.phone = phone;
    if (checkPhone(phone)) {
        if (mailcode.equals(code)) {
            call('/baotuan/user/loginByPhone', data, function (res) {
                alert(JSON.stringify(res.data));
                if (res.code) {
                    localStorage.setItem("memberId", res.data.memberId);
                    localStorage.setItem("userMemberMoney", res.data.userMemberMoney);
                    localStorage.setItem("userId", res.data.id);
                    localStorage.setItem("taskNumber", res.data.taskNumber);
                    localStorage.setItem("memberName", res.data.memberName);
                    localStorage.setItem("inviterCode", res.data.inviterCode);
                    localStorage.setItem("inviteCode", res.data.inviteCode);
                    navicatTo("task");
                }
            })
        } else {
            alert("验证码错误")
        }
    }
}

function toRegister() {
    navicatTo("register");
}
