
function refresh() {
	document.getElementById("revix").src="http://222.24.63.59:9067/getcode?"+Math.random();
}

function login(){
    var mail = $("#doc-ipt-email-1").val();
    var pass = $("#doc-ipt-pwd-1").val();
    var yanzhengma = $("#doc-ipt-yanzhengma-1").val();
    $.ajax({
        type : "post",
        url : "http://222.24.63.59:9067/user/login",
        data : {
            "email": mail,
            "password":pass,
            "revix":yanzhengma
        },
        xhrFields: {
                withCredentials: true
        },
//		contentType: "application/json; charset=utf-8",
        success : function(result){
            if(result.status == 200) {
            	console.log("success");
            	alert(result.msg);
//             	window.location.href="baidu.com";
            }
            else {
            	console.log(result.msg);
            	console.log("error")
            	if(result.msg == "username or password error")
            		document.getElementById("btn_11").click();
            	else if(result.msg == "revix error")
            		document.getElementById("btn_12").click();
            }
        },
        error : function(result) {
        	alert(result.msg);
        	alert("error");
        }
           
    });
};


