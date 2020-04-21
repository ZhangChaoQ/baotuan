$(function () {
    getTaskInfo();
    $("#file").change(function () {
        var objUrl = getObjectURL(this.files[0]);//获取文件信息
        console.log("objUrl = " + objUrl);
        if (objUrl) {
            $("#upload-img").html("<img src='" + objUrl + "' ></img>")
        }
    })
})

function getTaskInfo() {
    const data = new Object();
    data.id = getParam("id");
    call('/baotuan/viewUserTask/userTask', data, function (res) {
        $("#taskMoney").html("任务金额：" + res.data.taskMoney + "元");
        $("#taskStatus").html("任务状态：" + res.data.taskStatusName);
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

function commit() {
    if ($("#file")[0].files.length > 0) {
        var type = "file";
        var formData = new FormData();//这里需要实例化一个FormData来进行文件上传
        formData.append(type, $("#file")[0].files[0]);
        upload('/baotuan/uploadFile/upload', formData, function (res) {
            if (res == -1) alert("图片上传失败，请重试")
            const data = new Object();
            data.id = getParam("id");
            data.url = res;
            call('/baotuan/user/commitTask', data, function (res) {
                alert(res.msg)
                setTimeout(function () {
                    navicatTo("myTask")
                }, 1000)
            })
        })
    } else {
        const data = new Object();
        data.id = getParam("id");
        data.url = null;
        call('/baotuan/user/commitTask', data, function (res) {
            alert(res.msg)
            setTimeout(function () {
                navicatTo("myTask")
            }, 1000)
        })
    }
}
