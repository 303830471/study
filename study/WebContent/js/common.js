/*
 * 注册用户
 */
function register(option){
	var urls = "../study/OperateUsers?type=register&user="+$("#username").val()+"&pssd=" + $("#password").val();
	var data = $.ajax({
		  type:"GET",
		  url: urls,
		  async: false,
		  dataType: 'json',
//		  data:encodeURI(sKey),
		  success:function (data, textStatus) {
		 	
	 	  },
	 	  error:function(textStatus){
	 		 
	 	  }
	}).responseText;
	var resultjson = JSON.parse(data);
	if(resultjson.result=="ok"){
		
		
	}else{
		$("#showMsg").text(resultjson.info);
		alert(resultjson.info);
		
	}
	//window.location.reload("http://localhost:8080/study/");
	
}

function showData(option){
	var resultjson = operateSolr(option);
	$("#showData").text(JSON.stringify(resultjson));
}
function operateSolr(option){
	text = $("#search").val();
	var data = $.ajax({
		  type:"GET",
		  url: "../OperateSolr?type="+option+"&q=" + text,
		  async: false,
		  dataType: 'json',
//		  data:encodeURI(sKey),
		  success:function (data, textStatus) {
		 	
	 	  },
	 	  error:function(textStatus){
	 		 
	 	  }
	}).responseText;
	return JSON.parse(data);
}