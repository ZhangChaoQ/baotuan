function request(url, data, success, fail) {
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: url,
        data: JSON.stringify(data),
        success: function (res) {
            console.log(JSON.stringify(res))
            success(res);
        },
        error: function (res) {
            console.log(JSON.stringify(res))
            fail(res);
        }
    }).then(r => function () {
        debugger
        console.log(r)
    });
}
