/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD_horasextras;
import Modelo.Horasextras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class HorasextrasDAO implements CRUD_horasextras {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Horasextras h = new Horasextras();
    
    @Override
    public List listar() {
        ArrayList<Horasextras>list=new ArrayList<>();
        String sql="select * from Horas_Extras";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Horasextras cli=new Horasextras();
                cli.setFolio(rs.getInt("folio"));
                cli.setFecha(rs.getString("fecha"));
                cli.setTipo_dia(rs.getString("tipo_dia"));
                cli.setCantidad(rs.getString("cantidad"));
                cli.setRut_empleado(rs.getInt("rut_empleado"));
                cli.setHora_final(rs.getString("hora_final"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
        
    }

    @Override
    public Horasextras list(int folio) {
        String sql="select * from Horas_Extras where folio="+folio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                h.setFolio(rs.getInt("folio"));
                h.setFecha(rs.getString("fecha"));
                h.setTipo_dia(rs.getString("tipo_dia"));
                h.setCantidad(rs.getString("cantidad"));
                h.setRut_empleado(rs.getInt("rut_empleado"));
                h.setHora_final(rs.getString("hora_final"));
                
            }
        } catch (Exception e) {
        }
        return h;
    }

    @Override
    public boolean add(Horasextras cli) {
        String sql="insert into Horas_Extras(folio, fecha, tipo_dia, cantidad, rut_empleado, hora_final)values('"+cli.getFolio()+"','"+cli.getFecha()+"','"+cli.getTipo_dia()+"','"+cli.getCantidad()+"','"+cli.getRut_empleado()+"','"+cli.getHora_final()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Horasextras cli) {
        String sql="update Horas_Extras set folio='"+cli.getFolio()+"',fecha='"+cli.getFecha()+"',tipo_dia='"+cli.getTipo_dia()+"',cantidad='"+cli.getCantidad()+"',rut_empleado='"+cli.getRut_empleado()+"',hora_final='"+cli.getHora_final()+"'where folio="+cli.getFolio();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int folio) {
        String sql="delete from Horas_Extras where folio="+folio;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
    
}
