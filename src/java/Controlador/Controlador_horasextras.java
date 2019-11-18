/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Horasextras;
import ModeloDAO.HorasextrasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
public class Controlador_horasextras extends HttpServlet {

    String listar_horasextras="vistas/list_horasextras.jsp";
    String add_horasextras="vistas/add_horasextras.jsp";
    String edit_horasextras="vistas/edit_horasextras.jsp";
    Horasextras h=new Horasextras();
    HorasextrasDAO dao=new HorasextrasDAO();
    String rut;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_horasextras</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_horasextras at " + request.getContextPath() + "</h1>");
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
        String acceso="";
        String action=request.getParameter("accion_horasextras");
        if(action.equalsIgnoreCase("listar_horasextras")){
            acceso=listar_horasextras;            
        }else if(action.equalsIgnoreCase("add_horasextras")){
            acceso=add_horasextras;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int monto = 1000;
            int folio = Integer.parseInt(request.getParameter("txtfolio"));
            String fecha = request.getParameter("txtfecha");
            String tipo_dia = request.getParameter("txttipo_dia");
            String cantidad = request.getParameter("txtcantidad");
            int rut_empleado_sbase = Integer.parseInt(request.getParameter("txtrut_empleado"));
            String hora_final = request.getParameter("txthora_final")+monto;
            h.setFolio(folio);
            h.setFecha(fecha);
            h.setTipo_dia(tipo_dia);
            h.setCantidad(cantidad);
            h.setRut_empleado(rut_empleado_sbase);
            h.setHora_final(hora_final);
            dao.add(h);
            acceso=listar_horasextras;
        }
        else if(action.equalsIgnoreCase("editar_horasextras")){
            request.setAttribute("foliocli",request.getParameter("folio"));
            acceso=edit_horasextras;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int folio = Integer.parseInt(request.getParameter("txtfolio"));
            String fecha=request.getParameter("txtfecha");
            String tipo_dia=request.getParameter("txttipo_dia");
            String cantidad=request.getParameter("txtcantidad");
            int rut_empleado=Integer.parseInt(request.getParameter("txtrut_empleado"));
            String hora_final=request.getParameter("txthora_final");
            
            h.setFolio(folio);
            h.setFecha(fecha);
            h.setTipo_dia(tipo_dia);
            h.setCantidad(cantidad);
            h.setRut_empleado(rut_empleado);
            h.setHora_final(hora_final);
            dao.edit(h);
            acceso=listar_horasextras;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int folio = Integer.parseInt(request.getParameter("folio"));
            h.setFolio(folio);
            dao.eliminar(folio);
            acceso=listar_horasextras;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
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
