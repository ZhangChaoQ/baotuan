var money = 0
var name = ""
$(function() {
	money = getParam("money");
	name = decodeURI(getParam("name"));
	$("#title").html("成为" + name);
	$("#payMoney").html("支付金额："+money+"元");
})

function pay() {
	const data = new Object();
	data.price = 1;
	data.name = name;
	data.userId = localStorage.getItem("userId")
	call("/qpay/pay", data, function(res) {
		$("#goodsname").val(res.goodsname);
		$("#istype").val(res.istype);
		$('#key').val(res.key);
		$('#notify_url').val(res.notify_url);
		$('#orderid').val(res.orderid);
		$('#orderuid').val(res.orderuid);
		$('#price').val(res.price);
		$('#return_url').val(res.return_url);
		$('#uid').val(res.uid);
		$('#submitdemo1').click();
	})
}
