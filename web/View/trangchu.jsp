<%-- 
    Document   : index
    Created on : Nov 23, 2020, 12:37:41 AM
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index</title>
        <title> Sea Shoes</title>
        <link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,900;1,100;1,300;1,700;1,900&display=swap" rel="stylesheet">
	<meta charset="utf-8" content="width=device-width,initial-scale=1" >
    </head>
    <body >
    <div class="container">
    <div class="row">
        <div class="col-1 center"
             style="background-color: #57b894; border-top-right-radius:50px; border-bottom-right-radius:50px;">
            <h2 style="color:#ffffff; text-align: center;fontsize: 35px;">Hệ thống quản lý bán hàng</h2>

        </div>
        <div class="col-1 center">
            <form action="LogIn" method="post" class=" form-wap"  >
                <div class="form-wapper center">
                    <div class="form center">
                        <div class="input-group center">
                            <i class="fas fa-user"></i>
                            <input type="text" id="username" name="username" placeholder="Nhập tài khoản ...">
                        </div>
                        <div class="input-group center">
                            <i class="fas fa-lock"></i>
                            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu ...">
                            <i class="fas fa-eye-slash fa-eye" id="password-toggle" onclick="passwordToggle()"></i>
                        </div>
                        <button type="submit">Đăng nhập</button>
                        <p><b>Quên mật khẩu</b></p>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>                                            
    </body>
    <script type="text/javascript">
                const taga = document.getElementsByTagName("a");
		for(var i=0;i<taga.length;i++)
		{
			taga.item(i).addEventListener("click", function()
			{
				submitt(this);
					
			});
		}
                
                function submitt(z)
                {
                    z.children[0].submit();                    
                }
</script>
</html>
