function download() {
	location.href = "http:119.8.37.167:8088/apk/a.apk";
}
$(function() {
	$(".invoteCode").html(localStorage.getItem("inviteCode"))
})

function copyUrl() {
	var Url2 = $(".nivi")("biao1");
	Url2.select(); // 选择对象
	document.execCommand("Copy"); // 执行浏览器复制命令
	alert("复制成功");
}
