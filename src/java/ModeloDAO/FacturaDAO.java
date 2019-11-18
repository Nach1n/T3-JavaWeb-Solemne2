
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD_f;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class FacturaDAO implements CRUD_f {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Factura f = new Factura();

    @Override
    public List listar() {
        ArrayList<Factura>list=new ArrayList<>();
        String sql="select * from Factura";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Factura fac=new Factura();
                fac.setFolio(rs.getString("folio"));
                fac.setFecha(rs.getString("fecha"));
                fac.setRut_cliente(rs.getString("rut_cliente"));
                fac.setDescripcion(rs.getString("descripcion"));
                fac.setNeto(rs.getString("neto"));
                fac.setIva(rs.getString("iva"));
                fac.setTotal(rs.getString("total"));
                fac.setEstado_pago(rs.getString("estado_pago"));
                list.add(fac);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    @Override
    public List listar_estado_pago() {
        ArrayList<Factura>list_f_e=new ArrayList<>();
        String sql="select * from Factura where estado_pago = 0";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Factura fac=new Factura();
                fac.setFolio(rs.getString("folio"));
                fac.setFecha(rs.getString("fecha"));
                fac.setRut_cliente(rs.getString("rut_cliente"));
                fac.setDescripcion(rs.getString("descripcion"));
                fac.setNeto(rs.getString("neto"));
                fac.setIva(rs.getString("iva"));
                fac.setTotal(rs.getString("total"));
                fac.setEstado_pago(rs.getString("estado_pago"));
                list_f_e.add(fac);
            }
        } catch (Exception e) {
        }
        return list_f_e;
    }

    @Override
    public Factura list(String folio) {
        String sql="select * from Factura where folio="+folio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                f.setFolio(rs.getString("folio"));
                f.setFecha(rs.getString("fecha"));
                f.setRut_cliente(rs.getString("rut_cliente"));
                f.setDescripcion(rs.getString("descripcion"));
                f.setNeto(rs.getString("neto"));
                f.setIva(rs.getString("iva"));
                f.setTotal(rs.getString("total"));
                f.setEstado_pago(rs.getString("estado_pago"));
                
            }
        } catch (Exception e) {
        }
        return f;
    }

    @Override
    public boolean add(Factura fac) {
        String sql="insert into Factura(folio, fecha, rut_cliente, descripcion, neto, iva, total, estado_pago)values('"+fac.getFolio()+"','"+fac.getFecha()+"','"+fac.getRut_cliente()+"','"+fac.getDescripcion()+"','"+fac.getNeto()+"','"+fac.getIva()+"','"+fac.getTotal()+"','"+fac.getEstado_pago()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Factura fac) {
        String sql="update Factura set folio='"+fac.getFolio()+"',fecha='"+fac.getFecha()+"',rut_cliente='"+fac.getRut_cliente()+"',descripcion='"+fac.getDescripcion()+"',neto='"+fac.getNeto()+"',iva='"+fac.getIva()+"',total='"+fac.getTotal()+"',estado_pago='"+fac.getEstado_pago()+"'where folio="+fac.getFolio();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(String folio) {
        String sql="delete from Factura where folio="+folio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }


    
}
