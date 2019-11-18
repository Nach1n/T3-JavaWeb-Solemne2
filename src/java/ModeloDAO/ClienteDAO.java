/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import Config.Conexion;
import Intefaces.CRUD_c;
import Modelo.Cliente;
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
public class ClienteDAO implements CRUD_c {
    Conexion cn=new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente c = new Cliente();

    @Override
    public List listar() {
        ArrayList<Cliente>list=new ArrayList<>();
        String sql="select * from Cliente";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli=new Cliente();
                cli.setRut(rs.getString("rut"));
                cli.setNombre(rs.getString("nombre"));
                cli.setDireccion(rs.getString("direccion"));
                cli.setCelular(rs.getString("celular"));
                list.add(cli);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Cliente list(String rut) {
        String sql="select * from Cliente where rut="+rut;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                c.setRut(rs.getString("rut"));
                c.setNombre(rs.getString("nombre"));
                c.setDireccion(rs.getString("direccion"));
                c.setCelular(rs.getString("celular"));
                
            }
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public boolean add(Cliente cli) {
       String sql="insert into Cliente(rut, nombre, direccion, celular)values('"+cli.getRut()+"','"+cli.getNombre()+"','"+cli.getDireccion()+"','"+cli.getCelular()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Cliente cli) {
        String sql="update Cliente set rut='"+cli.getRut()+"',nombre='"+cli.getNombre()+"',direccion='"+cli.getDireccion()+"',celular='"+cli.getCelular()+"'where rut="+cli.getRut();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(String rut) {
        String sql="delete from Cliente where rut="+rut;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
    
}
