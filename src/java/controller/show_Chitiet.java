/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.clothDAO;
import dao.userDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.HoaDon;
import model.KhachHang;
import model.SanPham;
import model.SanPhamThue;
import model.user;

/**
 *
 * @author admin
 */
@WebServlet(name = "show_Chitiet", urlPatterns = {"/show_Chitiet"})
public class show_Chitiet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet show_Chitiet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet show_Chitiet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession ses = request.getSession();
        ArrayList<KhachHang> chitiet = new ArrayList<>();
        clothDAO ud = new clothDAO();
        String id = request.getParameter("idKH");
        int idKH = Integer.parseInt(id);
        chitiet = ud.getListKH(idKH);
        ses.setAttribute("chitietKH", chitiet);
        
        //getTTKH
        ArrayList<SanPhamThue> dssp = new ArrayList<>();
        SanPham a = new SanPham();
        HoaDon b = new HoaDon();
        ArrayList<SanPham> ds = new ArrayList<>();
        ArrayList<HoaDon> hd = new ArrayList<>();
        dssp = ud.getListSPT(idKH);
        
        //getSPKH
        for (SanPhamThue abc : dssp) {
            a = abc.getSp();
            b=abc.getHd();
            ds.add(a);
            hd.add(b);
        }
        //Lấy ngày thuê
        ArrayList<HoaDon> hd1 = new ArrayList<>();
        for(HoaDon x : hd){
            hd1 = ud.getListHD(x.getIdHD());
        }
        ses.setAttribute("HD", hd1);
        System.out.println(hd1);
//        System.out.println(hd2);
//        for(HoaDon dsh: hd2){
//            System.out.println(dsh.getNgaythue());
//        }
        
        ArrayList<SanPham> full = new ArrayList<>();
        ArrayList<SanPham> sp1 = new ArrayList<>();
        for(SanPham sp: ds){
          int idSP = sp.getId();
          full = ud.getSP(idSP);
          sp = full.get(0);
          sp1.add(sp);
       }
        ses.setAttribute("listSP", sp1);
        
        
        RequestDispatcher dis = request.getRequestDispatcher("/View/thongkechitiet.jsp");
        dis.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
