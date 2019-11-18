/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Cliente;
import ModeloDAO.ClienteDAO;
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
public class Controlador_c extends HttpServlet {

    String listar_c="vistas/listar_c.jsp";
    String add_c="vistas/add_c.jsp";
    String edit_c="vistas/edit_c.jsp";
    Cliente c=new Cliente();
    ClienteDAO dao=new ClienteDAO();
    String rut;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_c</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_c at " + request.getContextPath() + "</h1>");
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
        String action=request.getParameter("accion_c");
        if(action.equalsIgnoreCase("listar_c")){
            acceso=listar_c;            
        }else if(action.equalsIgnoreCase("add_c")){
            acceso=add_c;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String rut=request.getParameter("txtrut");
            String nombre=request.getParameter("txtnombre");
            String direccion=request.getParameter("txtdireccion");
            String celular=request.getParameter("txtcelular");
            c.setRut(rut);
            c.setNombre(nombre);
            c.setDireccion(direccion);
            c.setCelular(celular);
            dao.add(c);
            acceso=listar_c;
        }
        else if(action.equalsIgnoreCase("editar_c")){
            request.setAttribute("rutcli",request.getParameter("rut"));
            acceso=edit_c;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String rut=request.getParameter("txtrut");
            String nombre=request.getParameter("txtnombre");
            String direccion=request.getParameter("txtdireccion");
            String celular=request.getParameter("txtcelular");
            
            c.setRut(rut);
            c.setNombre(nombre);
            c.setDireccion(direccion);
            c.setCelular(celular);
            dao.edit(c);
            acceso=listar_c;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String rut = request.getParameter("rut");
            c.setRut(rut);
            dao.eliminar(rut);
            acceso=listar_c;
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
