<%-- 
    Document   : payment
    Created on : Nov 23, 2020, 2:36:35 PM
    Author     : admin
--%>

<%@page import="model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Thống kê</title>
	<link rel="stylesheet" type="text/css" href="css/admin_page.css">
        <link rel="stylesheet" type="text/css" href="css/index.css">
        <link rel="stylesheet" type="text/css" href="css/footer.css">
        <link rel="stylesheet" type="text/css" href="css/login.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/8.0.1/normalize.min.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,900;1,100;1,300;1,700;1,900&display=swap" rel="stylesheet">
	<meta charset="utf-8" content="width=device-width,initial-scale=1" >
        
    </head>
    <body>
       <div class="wrapper">
        <div class="container">
            <div class="dashboard">
                <div class="left">
                    <span class="left__icon">
                        <span></span>
                        <span></span>
                        <span></span>
                    </span>
                    <div class="left__content">
                        <div class="left__logo">LOGO</div>
                        <div class="left__profile">
                            <div class="left__image"><img src="assets/logo.jpg" alt=""></div>
                            <p class="left__name">Cửa hàng Quần Áo</p>
                        </div>
                        <ul class="left__menu">
                            <li class="left__menuItem">
                                <a href="#" class="left__title"><form action="show_admin_page" method="get"><img src="assets/icon-dashboard.svg" alt="">Dashboard</form></a>
                            </li>
                            <li class="left__menuItem">
                                <a href="#" class="left__title"><form action="show_Thongke" method="get"><img src="assets/icon-users.svg" alt="">Thống kê</form></a>
                            </li>
                            <li class="left__menuItem">
                                <a href="#" class="left__title"><form action="show_Index"><img src="assets/icon-logout.svg" alt="">Đăng Xuất</form></a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="right">
                    <div class="right__content">
                        <div class="right__title">Bảng điều khiển</div>
                        <p class="right__desc">CHỌN THỐNG KÊ</p>
                        <div class="right__formWrapper">
                            <form action="show_thongke_view" method="get" enctype="multipart/form-data">
                                <div class="right__inputWrapper">
                                    <label for="p_category">Danh mục</label>
                                    <select name="">
                                        <option disabled selected>Chọn loại thống kê</option>
                                        <option value="1">Thống kê khách hàng mượn trang phục</option>
                                        <option value="2">Thống kê khách hàng mượn nhiều</option>
                                        <option value="3">Thống kê doanh thu</option>
                                    </select>
                                </div>
                                <button class="btn" type="submit">Thống kê</button>
                            </form>
                                    
                        </div>
                        
                    </div>
                    
                </div>
                
            </div>
        </div>
    </div>
    <script src="js/main.js"></script>
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
