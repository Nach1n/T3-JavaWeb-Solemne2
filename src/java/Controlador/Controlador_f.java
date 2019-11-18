
package Controlador;

import Modelo.Factura;
import ModeloDAO.FacturaDAO;
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
public class Controlador_f extends HttpServlet {

    String listar_f="vistas/listar_f.jsp";
    String listar_f_e="vistas/listar_f_e.jsp";
    String add_f="vistas/add_f.jsp";
    String edit_f="vistas/edit_f.jsp";
    Factura f=new Factura();
    FacturaDAO dao=new FacturaDAO();
    String folio;
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador_f</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador_f at " + request.getContextPath() + "</h1>");
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
        String action=request.getParameter("accion_f");
        if(action.equalsIgnoreCase("listar_f")){
            acceso=listar_f;
        }
        else if(action.equalsIgnoreCase("listar_f_e")){
            acceso=listar_f_e;
        }
        else if(action.equalsIgnoreCase("add_f")){
            acceso=add_f;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            float impuesto = 0.19f;
            
            
            String folio=request.getParameter("txtfolio");
            String fecha=request.getParameter("txtfecha");
            String rut_cliente=request.getParameter("txtrut_cliente");
            String descripcion=request.getParameter("txtdescripcion");
            String iva=request.getParameter("txtiva");

            

            float total=(float) (Integer.parseInt(request.getParameter("txttotal")));
            float var1;
            var1 = total*impuesto;
            String neto=Integer.toString((int) (var1+total));
            
            String estado_pago=request.getParameter("txtestado_pago");
            f.setFolio(folio);
            f.setFecha(fecha);
            f.setRut_cliente(rut_cliente);
            f.setDescripcion(descripcion);
            f.setNeto(neto);
            f.setIva(iva);
            f.setTotal(Integer.toString((int) total));
            f.setEstado_pago(estado_pago);
            dao.add(f);
            acceso=listar_f;
        }
        else if(action.equalsIgnoreCase("editar_f")){
            request.setAttribute("foliofac",request.getParameter("folio"));
            acceso=edit_f;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String folio=request.getParameter("txtfolio");
            String fecha=request.getParameter("txtfecha");
            String rut_cliente=request.getParameter("txtrut_cliente");
            String descripcion=request.getParameter("txtdescripcion");
            String neto=request.getParameter("txtneto");
            String iva=request.getParameter("txtiva");
            String total=request.getParameter("txttotal");
            String estado_pago=request.getParameter("txtestado_pago");
            
            f.setFolio(folio);
            f.setFecha(fecha);
            f.setRut_cliente(rut_cliente);
            f.setDescripcion(descripcion);
            f.setNeto(neto);
            f.setIva(iva);
            f.setTotal(total);
            f.setEstado_pago(estado_pago);
            dao.edit(f);
            acceso=listar_f;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String folio = request.getParameter("folio");
            f.setFolio(folio);
            dao.eliminar(folio);
            acceso=listar_f;
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
