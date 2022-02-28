<%-- 
    Document   : Admin_user
    Created on : Jan 2, 2021, 8:55:40 PM
    Author     : admin
--%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.HoaDon"%>
<%@page import="model.SanPham"%>
<%@page import="model.KhachHang"%>
<%@page import="dao.clothDAO"%>
<%@page import="model.user"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link rel="stylesheet" href="css/fullcss.css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.1/css/all.css" integrity="sha384-vp86vTRFVJgpjF9jiIGPEEqYqlDwgyBgEF109VFjmqGmIY/Y4HV4d3Gp2irVfcrp" crossorigin="anonymous">
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
                        <p class="right__desc">CHI TIẾT THỐNG KÊ KHÁCH HÀNG</p>
                        <div class="right__formWrapper">
                            
                            <form  enctype="multipart/form-data">
                                <div class="right__inputWrapper">
                                    
                                    <div class="profile_customer">
                                        <h3 style="text-align: center;font-size: 20px;margin: 0px 10px 10px 0px;">Thông tin khách hàng</h3>
                                        
                                       <ul>
                                           <%
                                            ArrayList<KhachHang> list = new ArrayList<>();
                                            if(session.getAttribute("chitietKH")!=null){
                                            list = (ArrayList<KhachHang>) session.getAttribute("chitietKH");
                                            for(KhachHang u : list){
                                            %>
                                           <li>
                                               <span>Tên KH: </span>
                                                <label for=""><%=u.getTen() %></label>
                                            </li>
                                            <li>
                                                <span>Mã KH:  </span>
                                                <label for=""><%=u.getMaKH() %></label>
                                            </li>
                                             <li>
                                                 <span>Số điện thoại:  </span>
                                                 <label for=""><%=u.getDienthoai() %></label>
                                             </li>
                                             <li>
                                                 <span>Địa chỉ:  </span>
                                                 <label for=""><%=u.getDiachi()%></label>
                                             </li>
                                             <li>
                                                 <span>Email:  </span>
                                                 <label for=""><%=u.getEmail()%></label>
                                             </li>
                                             <li>
                                                 <span>Ngày sinh:  </span>
                                                 <label for=""><%=u.getNgaysinh() %></label>
                                             </li>
                                             <% }} %>
                                        </ul>
                                        
                                    </div>
                                </div>
                            </form>
                            <div style="margin-top: 50px;" class="right__table">
                                <div class="right__tableWrapper">
                                    <table>
                                        <thead>
                                           
                                            <tr>
                                                <th>STT</th>
                                                <th style="text-align: center;">ID</th>
                                                <th>Tên SP</th>
                                                <th>Ngày thuê</th>
                                                <th>Giá thuê (VND)</th>
                                                <th>Tổng số ngày thuê</th>
                                                <th>Thành tiền (VND)</th>
                                            </tr>
                                        </thead>
                                
                                        <tbody>
                                             <%
                                                int dem=1;
                                                ArrayList<SanPham> list1 = new ArrayList<>();
                                                ArrayList<HoaDon> hda = new ArrayList<>();
                                                hda = (ArrayList<HoaDon>) session.getAttribute("HD");
                                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
                                                Date date = new Date();
                                                
                                                float tongtien = 0;
                                                clothDAO cl = new clothDAO();
                                                if(session.getAttribute("listSP")!=null){
                                                list1 = (ArrayList<SanPham>) session.getAttribute("listSP");
                                                for(SanPham sp : list1){
                                                    for(HoaDon h : hda){
                                                        tongtien += ((date.getTime()- h.getNgaythue().getTime())/(3600*1000*24)+1)*sp.getGiathue();
                                            %>
                                            <tr>
                                                <td data-label="STT"><%=dem++ %></td>
                                                <td data-label="ID" style="text-align: center;"><%=sp.getMaSP() %></td>
                                                <td data-label="Tên SP"><%=sp.getTenSP() %></td>
                                              
                                                <td data-label="Ngày thuê" ><%=h.getNgaythue() %></td> 
                                                <td data-label="Giá thuê"><%=sp.getGiathue() %> đ</td>
                                                <td data-label="Tổng số ngày thuê"><%=(date.getTime()- h.getNgaythue().getTime())/(3600*1000*24)+1 %></td>
                                                <td id ="tien" data-label="Thành tiền" " class="right__iconTable"><%=((date.getTime()- h.getNgaythue().getTime())/(3600*1000*24)+1)*sp.getGiathue() %> đ</td>
                                            </tr>
                                             <% }}}%>
                                            <tr>
                                                <td colspan="6">Tổng</td>
                                                <td ><%=tongtien %> đ</td>
                                            </tr>
                                            
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                                            <a style="float:left; margin-top: 7px;" href="#"><form action="show_thongke_view" method="get"><span>Trở lại <i class="fas fa-arrow-circle-left"></i><span></form></a>
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
