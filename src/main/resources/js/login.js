function checkPhone(phone) {
    if (!/^1[3456789]\d{9}$/.test(phone)) {
        alert("手机号格式错误,请检查输入")
        return false;
    }
    return true;
}

function toRegister() {
    location.href = '../register.html';
}

function toReset() {
    location.href = '../reset.html';
}

function Login() {
    const phone = $("#phone").val();
    const password = $("#password").val();
    if (phone.length == 0) {
        alert('请输入手机号')
        return;
    }
    if (!checkPhone()) return;
    if (password.length == 0) {
        alert('请输入密码');
        return;
    }
    const data = new Object()
    data.phone = phone;
    data.password = password;
    call('/baotuan/user/login', data, function (res) {
        alert(res.data.msg);
        if (res.data.code) {
            $.cookie("userInfo", res.data.data);
            $.cookie("userId", res.data.data.id);
            location.href = "../task.html";
        }
    })
}
