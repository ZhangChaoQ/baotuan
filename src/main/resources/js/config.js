var app = new Object();
app.host = "";

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