var app = new Object();
//app.host = "http://192.168.0.121:8088";
app.host = "http://119.8.37.167:8088";
app.host = "http://192.168.0.108:8088"
app.filePath = "http://119.8.37.167";

//app.host = "http://192.168.31.46:8088";

function call(url, data, success) {
    $.ajax({
        url: app.host + url,
        dataType: 'json',
        data: data,
        method: 'POST',
        success: function (res) {
            success(res);
        }
    })
}

function upload(url, formData, success) {
    $.ajax({
        type: "post",
        url: app.host + url,
        data: formData,
        processData: false,
        contentType: false,
        success: function (res) {
            success(res)
        }
    })
}

function getParam(name) {
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i = 0; i < vars.length; i++) {
        var pair = vars[i].split("=");
        if (pair[0] == name) {
            return pair[1];
        }
    }
    return null;
}

$(function () {
    if (localStorage.getItem("height") == "undefined" || localStorage.getItem("height") == null) {
        localStorage.setItem("height", window.innerHeight)
        localStorage.setItem("width", window.innerWidth)
        $("body").css("height", window.innerHeight)
        $("body").css("width", window.innerWidth)
    } else {
        let height = localStorage.getItem("height")
        let width = localStorage.getItem("width")
        $("body").css("height", height)
        $("body").css("width", width)
    }
    $("#nav-task").click(function () {
        navicatTo("task");
    })
    $("#nav-myTask").click(function () {
        navicatTo("myTask")
    })
    $("#nav-member").click(function () {
        navicatTo("member")
    })
    $("#nav-user").click(function () {
        navicatTo("user")
    })
    var winHeight = $(window).height();  //获取当前页面高度
    $(window).resize(function () {
        var thisHeight = $(this).height();
        if (winHeight - thisHeight > 100) {
            //键盘弹出
            $('.register').hide();
        } else {
            //键盘收起
            $('.register').show();

        }
    })
    $(".back").click(function () {
        self.location = document.referrer;
    })
    var lo = location.href;
    if ((lo.indexOf("index") == -1 && lo.indexOf("rest") == -1 && lo.indexOf("register") == -1) && (localStorage.getItem("userId") == "undefined" || localStorage.getItem("userId") == null)) {
        navicatTo("index");
    } else {
        var data = new Object();
        data.id = localStorage.getItem("userId");
        call('/baotuan/user/isenabled', data, function (res) {
            if (res.data) navicatTo("task");
            else navicatTo("index");
        })
    }
})

function navicatTo(url) {
    var str = location.href.toString();
    if (str.indexOf("qpay") != -1) {
        location.href = "../BaoTuanAppTest/" + url;
    } else {
        location.href = url;
    }
}

function DateTimeFormatter(value) {
    if (value != null) {
        var dateee = new Date(value).toJSON();
        var date = new Date(+new Date(dateee) + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '');
        return date;
    } else {
        return null;
    }
}

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}
window.alert = alert;

function alert(data) {
    var a = document.createElement("div"),
        p = document.createElement("p"),
        textNode = document.createTextNode(data ? data : "");
// 控制样式

    css(a, {
        'position': 'fixed',
        'left': '0px',
        'right': '0px',
        'top': '40%',
        'width': '60%',
        'margin': '0px auto',
        'background-color': 'rgb(128, 128, 128)',
        'font-size': '1rem',
        'text-align': 'center',
        'color': 'white',
        'border-radius': '10px'
    });
// 内部结构套入
    p.appendChild(textNode);
    a.appendChild(p);
// 整体显示到页面内
    document.getElementsByTagName("body")[0].appendChild(a);
// 确定绑定点击事件删除标签
    setTimeout(function () {
        a.parentNode.removeChild(a);
    }, 1000)

}

window.history.back = back;

function back() {

}

function css(targetObj, cssObj) {
    var str = targetObj.getAttribute("style") ? targetObj.getAttribute("style") : "";
    for (var i in cssObj) {
        str += i + ":" + cssObj[i] + ";";
    }
    targetObj.style.cssText = str;
}