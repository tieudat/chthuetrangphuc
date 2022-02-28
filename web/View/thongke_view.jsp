<%-- 
    Document   : Admin_add_user
    Created on : Jan 2, 2021, 9:52:04 PM
    Author     : admin
--%>

<%@page import="dao.clothDAO"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="model.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%-- 
    Document   : view_oders
    Created on : Dec 29, 2020, 8:34:11 PM
    Author     : Tiêu Đạt
--%>

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
                        <p class="right__desc">THỐNG KÊ KHÁCH HÀNG MƯỢN TRANG PHỤC</p>
                        <div class="right__formWrapper">
                            <div class="right__table">
                             
                                <div class="right__tableWrapper">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>STT</th>
                                                <th style="text-align: center;">Mã KH</th>
                                                <th>Tên</th>
                                                <th>Số lần mượn chưa trả</th>
                                                <th>Tổng số trang phục đang mượn</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                int dem=1;
                                                clothDAO a = new clothDAO();
//                                                Set<KhachHang> li = new HashSet<KhachHang>();
                                                ArrayList<KhachHang> list = new ArrayList<>();
                                                if(session.getAttribute("listKhach")!=null){
                                                list = (ArrayList<KhachHang>) session.getAttribute("listKhach");
                                                for(KhachHang u : list){
                                            %>
                                            <tr>
                                                <td data-label="STT"><%=dem++ %></td>
                                                <td data-label="Mã KH" style="text-align: center;"><%=u.getMaKH() %></td>
                                                <td data-label="Tên"><%=u.getTen() %></td>
                                                <td data-label="Số lần mượn chưa trả"><%=a.numberHD(u.getId()) %></td>
                                                <td data-label="Tổng số trang phục đang mượn"><%=a.numberSP(u.getId()) %> </td>
                                                <td data-label="Xem chi tiết" class="right__iconTable">
                                                    <a href="#"><form action="show_Chitiet" method="get"><input id="id_edit" name="idKH" type="hidden" value="<%=u.getId()%>"><img src="assets/icon-book.svg" alt=""></form></a>
                                                </td>
                                            </tr>
                                            <% } } %>
                                        </tbody>
                                    </table>
                                        
                                </div>
                            </div>
                                        <a style="float:left; margin-top: 7px;" href="#"><form action="show_Thongke" method="get"><span>Trở lại <i class="fas fa-arrow-circle-left"></i><span></form></a>
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