var mailcode = '';
$(function () {
    /*$("#verCodeBtn").click(function () {
        const phone = $("#phone").val()
        if (checkPhone(phone)) {
            const data = new Object();
            data.phone = phone;
            call('/baotuan/sendMsg/sendmsg', data, function (res) {
                mailcode = res.data.data.code;
            })
        }
    });*/
})

function Login() {
    const phone = $("#phone").val();
    const data = new Object();
    const co = $("#code").val();
    data.phone = phone;
    data.password = $("#password").val();
    data.inviteCode = $("#inviteCode").val();
    if (checkPhone(phone)) {
       /* if (mailcode == '') {
            alert('请输入验证码');
            return;
        }
        if (mailcode != co) {
            alert('验证码错误');
            return;
        }*/
        call('/baotuan/user/addUser', data, function (res) {
            if (res.code) {
                localStorage.setItem("memberId", res.data.memberId);
                localStorage.setItem("userMemberMoney", res.data.userMemberMoney);
                localStorage.setItem("userId", res.data.id);
                localStorage.setItem("taskNumber", res.data.taskNumber);
                localStorage.setItem("memberName", res.data.memberName);
                localStorage.setItem("inviterCode", res.data.inviterCode);
                localStorage.setItem("inviteCode", res.data.inviteCode);
                navicatTo("task")
            } else {
                alert(res.msg)
            }
        })
    }
}

function checkPhone(phone) {
    if (!/^1[3456789]\d{9}$/.test(phone)) {
        alert("手机号格式错误,请检查输入")
        return false;
    }
    return true;
}

function toReset() {
    navicatTo('reset');
}

function toLogin() {
    navicatTo('index');
}
