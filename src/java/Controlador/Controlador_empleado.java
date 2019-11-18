/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Empleado;
import ModeloDAO.EmpleadoDAO;
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
public class Controlador_empleado extends HttpServlet {

    String listar_empleado="vistas/list_empleado.jsp";
    String add_empleado="vistas/add_empleado.jsp";
    String edit_empleado="vistas/edit_empleado.jsp";
    Empleado e=new Empleado();
    EmpleadoDAO dao=new EmpleadoDAO();
    String rut;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_empleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_empleado at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion_empleado");
        if(action.equalsIgnoreCase("listar_empleado")){
            acceso=listar_empleado;            
        }else if(action.equalsIgnoreCase("add_empleado")){
            acceso=add_empleado;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            int rut = Integer.parseInt(request.getParameter("txtrut"));
            String nombre = request.getParameter("txtnombre");
            String apellido = request.getParameter("txtapellido");
            String celular = request.getParameter("txtcelular");
            String dpto = request.getParameter("txtdpto");
            String sbase = request.getParameter("txtsbase");
            e.setRut(rut);
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setCelular(celular);
            e.setDpto(dpto);
            e.setSbase(sbase);
            dao.add(e);
            acceso=listar_empleado;
        }
        else if(action.equalsIgnoreCase("editar_empleado")){
            request.setAttribute("rutcli",request.getParameter("rut"));
            acceso=edit_empleado;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            int rut = Integer.parseInt(request.getParameter("txtrut"));
            String nombre=request.getParameter("txtnombre");
            String apellido=request.getParameter("txtapellido");
            String celular=request.getParameter("txtcelular");
            String dpto=request.getParameter("txtdpto");
            String sbase=request.getParameter("txtsbase");
            
            e.setRut(rut);
            e.setNombre(nombre);
            e.setApellido(apellido);
            e.setCelular(celular);
            e.setDpto(dpto);
            e.setSbase(sbase);
            dao.edit(e);
            acceso=listar_empleado;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            int rut = Integer.parseInt(request.getParameter("rut"));
            e.setRut(rut);
            dao.eliminar(rut);
            acceso=listar_empleado;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
