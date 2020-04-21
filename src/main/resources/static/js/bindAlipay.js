$(function () {
    if (localStorage.getItem("alipayUrl") != "null") {
        $("#alipayName").val(localStorage.getItem("alipayName"));
        $("#alipayAccount").val(localStorage.getItem("alipayAccount"));
        $("#upload-img").html("<img src='" + app.filePath + localStorage.getItem("alipayUrl") + "' ></img>")
    }
    $("#file").change(function () {
        var objUrl = getObjectURL(this.files[0]);//获取文件信息
        console.log("objUrl = " + objUrl);
        if (objUrl) {
            $("#upload-img").html("<img src='" + objUrl + "' ></img>")
        }
    })
})

function bindAlipay() {
    var type = "file";
    var formData = new FormData();//这里需要实例化一个FormData来进行文件上传
    formData.append(type, $("#file")[0].files[0]);
    upload('/baotuan/uploadFile/upload', formData, function (res) {
        if (res == -1) alert("图片上传失败，请重试")
        const data = new Object();
        data.id = localStorage.getItem("userId");
        data.alipayUrl = res;
        data.alipayName = $("#alipayName").val();
        data.alipayAccount = $("#alipayAccount").val();
        call('/baotuan/user/bindAlipay', data, function (res) {
            alert(res.msg);
            if (res.code) {
                setTimeout(function () {
                    self.location = document.referrer;
                }, 1000)
            }
        })
    })
}


function getObjectURL(file) {
    var url = null;
    if (window.createObjectURL != undefined) {
        url = window.createObjectURL(file);
    } else if (window.URL != undefined) { // mozilla(firefox)
        url = window.URL.createObjectURL(file);
    } else if (window.webkitURL != undefined) { // webkit or chrome
        url = window.webkitURL.createObjectURL(file);
    }
    return url;
}