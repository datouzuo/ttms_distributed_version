function signup(){
    var mail = $("#doc-ipt-email-2").val();
    var pass = $("#doc-ipt-pwd-2").val();
    var username = $("#doc-ipt-username-2").val();
    var telnum = $("#doc-ipt-telephone-2").val();
    var yanzhengma = $("#doc-ipt-yanzhengma-2").val();
    $.ajax({
        type : "post",
        url : "http://222.24.63.59:9067/user/registerservice",
        data : {
            "email": mail,
            "password":pass,
            "username":username,
            "phone":telnum,
            "revix":yanzhengma
        },
      
        xhrFields: {
                withCredentials: true
        },
        success : function(result){
        	alert("success");
            if(result.status == 200) {
               	alert("success"+result.msg);
            }
            else {
            	alert("error"+result.msg+yanzhengma);
            }
        },
        error : function(result) {
     
        }
           
    });
};

function checkmail() {
	var mail = $("#doc-ipt-email-2").val();
	if(mail == '') {
		document.getElementById("icon_mail_success").style.display="none";
	    document.getElementById("icon_mail_error").style.display="inline";
		return;
	}
	$.ajax({
		type:"get",
		url:"http://222.24.63.59:9067/user/registercheck",
		data:{
			"msg":mail,
			"type":2
		},
		xhrFields: {
                withCredentials: true
        },
        success: function(result) {
        	if(mail.length != 0){
	        	if(result.status == 200) {       		
	        		document.getElementById("icon_mail_error").style.display="none";
	        		document.getElementById("icon_mail_success").style.display="inline";	     		
	        	}
	        	else if(result.status != 200){
	        		document.getElementById("icon_mail_success").style.display="none";
	        		document.getElementById("icon_mail_error").style.display="inline";
	        	}
	        }
        },
        error:function(result) {
        	
        }
	});
};

function checkuser() {
	var username = $("#doc-ipt-username-2").val();
	if(username =='') {
		document.getElementById("icon_username_success").style.display="none";
	    document.getElementById("icon_username_error").style.display="inline";
	    return;
	}
	$.ajax({
		type:"get",
		url:"http://222.24.63.59:9067/user/registercheck",
		data:{
			"msg":username,
			"type":1
		},
		xhrFields: {
                withCredentials: true
        },
        success: function(result) {
        	if(username.length != 0){
	        	if(result.status == 200) {
	        		document.getElementById("icon_username_error").style.display="none";
	        		document.getElementById("icon_username_success").style.display="inline";
	        	}
	        	else{
	        		document.getElementById("icon_username_success").style.display="none";
	        		document.getElementById("icon_username_error").style.display="inline";
	        	}
	        }
        },
        error:function(result) {
        	
        }
	});
};

function checkpass() {
	var pass = $("#doc-ipt-pwd-2").val();
	if(pass.length != 0) {
		document.getElementById("icon_pwd_error").style.display="none";
	    document.getElementById("icon_pwd_success").style.display="inline";
	}
	else {
		document.getElementById("icon_pwd_success").style.display="none";
	    document.getElementById("icon_pwd_error").style.display="inline";
	}
}

function checktel() {
	var tel = $("#doc-ipt-telephone-2").val();
	if(tel =='') {
		document.getElementById("icon_tel_success").style.display="none";
	    document.getElementById("icon_tel_error").style.display="inline";
	    return;
	}
	$.ajax({
		type:"get",
		url:"http://222.24.63.59:9067/user/registercheck",
		data:{
			"msg":tel,
			"type":3
		},
		xhrFields: {
                withCredentials: true
        },
        success: function(result) {
        	if(tel.length != 0){
	        	if(result.status == 200) {
	        	
	        		document.getElementById("icon_tel_error").style.display="none";
	        		document.getElementById("icon_tel_success").style.display="inline";
	        	}
	        	else{
	        		
	        		document.getElementById("icon_tel_success").style.display="none";
	        		document.getElementById("icon_tel_error").style.display="inline";
	        	}
	        }
        },
        error:function(result) {
        	
        }
	});
};

function refresh() {
	document.getElementById("revix").src="http://222.24.63.59:9067/getcode?"+Math.random();
}

function check_activecode() {
	var activecode = $("#activecode").val();
	$.ajax({
		type:"post",
		url:"http://222.24.63.59:9067/user/mail/"+activecode,
//		data:{
//			"" : activecode
//		},
		xhrFields: {
                withCredentials: true
        },
        success: function(result) {
        	if(result.status == 200) {
        		window.location.href="login.html";
        	}
        	else {
        		alert("未成功")
        	}
        },
        error:function(result) {
        	alert("error");
        }
	});
}
