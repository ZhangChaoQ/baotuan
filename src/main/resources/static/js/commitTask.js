$(function() {
	getTaskInfo()
})

function getTaskInfo() {
	const data = new Object();
	data.id = getParam("id");
	call('/baotuan/viewUserTask/userTask', data, function(res) {
		$("#taskMoney").html("任务金额：" + res.data.taskMoney + "元");
		$("#taskStatus").html("任务状态：" + res.data.taskStatusName);
	})
}

function changepic() {
	var reads = new FileReader();
	f = document.getElementById('file').files[0];
	reads.readAsDataURL(f);
	reads.onload = function(e) {
		$("#upload-img").html("<img src=" + this.result + "/>")
	};
}

function commit() {
	const data = new Object();
	data.id = getParam("id");
	data.url=null;
	call('/baotuan/user/commitTask',data,function(res){
		alert(res.msg)
		setTimeout(function(){
			window.history.back();
		},1000)
	})
}
