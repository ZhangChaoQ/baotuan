function changepic() {
	var reads = new FileReader();
	f = document.getElementById('file').files[0];
	reads.readAsDataURL(f);
	reads.onload = function(e) {
		$("#upload-img").html("<img src=" + this.result + "/>")
	};
}
function bindAlipay(){
	const data=new Object();
	data.id=localStorage.getItem("userId");
}