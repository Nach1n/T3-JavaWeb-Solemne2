/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD_empleado;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class EmpleadoDAO implements CRUD_empleado {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Empleado e = new Empleado();
    

    @Override
    public List listar() {
        ArrayList<Empleado>list=new ArrayList<>();
        String sql="select * from Empleado";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Empleado cli=new Empleado();
                cli.setRut(rs.getInt("rut"));
                cli.setNombre(rs.getString("nombre"));
                cli.setApellido(rs.getString("apellido"));
                cli.setCelular(rs.getString("celular"));
                cli.setDpto(rs.getString("dpto"));
                cli.setSbase(rs.getString("sbase"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
        
    }

    @Override
    public Empleado list(int rut) {
        String sql="select * from Empleado where rut="+rut;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                e.setRut(rs.getInt("rut"));
                e.setNombre(rs.getString("nombre"));
                e.setApellido(rs.getString("apellido"));
                e.setCelular(rs.getString("celular"));
                e.setDpto(rs.getString("dpto"));
                e.setSbase(rs.getString("sbase"));
                
            }
        } catch (Exception e) {
        }
        return e;
    }

    @Override
    public boolean add(Empleado cli) {
        String sql="insert into Empleado(rut, nombre, apellido, celular, dpto, sbase)values('"+cli.getRut()+"','"+cli.getNombre()+"','"+cli.getApellido()+"','"+cli.getCelular()+"','"+cli.getDpto()+"','"+cli.getSbase()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Empleado cli) {
        String sql="update Empleado set rut='"+cli.getRut()+"',nombre='"+cli.getNombre()+"',apellido='"+cli.getApellido()+"',celular='"+cli.getCelular()+"',dpto='"+cli.getDpto()+"',sbase='"+cli.getSbase()+"'where rut="+cli.getRut();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int rut) {
        String sql="delete from Empleado where rut="+rut;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
