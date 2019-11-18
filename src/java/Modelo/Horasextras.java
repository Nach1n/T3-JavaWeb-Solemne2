/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author luis
 */
public class Horasextras {
    int folio;
    String fecha;
    String tipo_dia;
    String cantidad;
    int rut_empleado;
    String hora_final;
    
    public Horasextras(){
        
    }

    public Horasextras(int folio, String fecha, String tipo_dia, String cantidad, int rut_empleado, String hora_final) {
        this.folio = folio;
        this.fecha = fecha;
        this.tipo_dia = tipo_dia;
        this.cantidad = cantidad;
        this.rut_empleado = rut_empleado;
        this.hora_final = hora_final;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipo_dia() {
        return tipo_dia;
    }

    public void setTipo_dia(String tipo_dia) {
        this.tipo_dia = tipo_dia;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public int getRut_empleado() {
        return rut_empleado;
    }

    public void setRut_empleado(int rut_empleado) {
        this.rut_empleado = rut_empleado;
    }

    public String getHora_final() {
        return hora_final;
    }

    public void setHora_final(String hora_final) {
        this.hora_final = hora_final;
    }
    
}
