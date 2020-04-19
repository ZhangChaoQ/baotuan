$(function () {

})

function checkPhone(phone) {
    if (!/^1[3456789]\d{9}$/.test(phone)) {
        alert("手机号格式错误,请检查输入")
        return false;
    }
    return true;
}

function toRegister() {
    navicatTo('register');
}

function toReset() {
    navicatTo('reset');
}

function Login() {
    const phone = $("#phone").val();
    const password = $("#password").val();
    if (phone.length == 0) {
        alert('请输入手机号')
        return;
    }
    if (!checkPhone(phone)) return;
    if (password.length == 0) {
        alert('请输入密码');
        return;
    }
    const data = new Object();
    data.phone = phone;
    data.password = password;
    call('/baotuan/user/login', data, function (res) {
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
}
