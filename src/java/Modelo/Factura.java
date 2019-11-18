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
public class Factura {

    String folio;
    String fecha;
    String rut_cliente;
    String descripcion;
    String neto;
    String iva;
    String total;
    String estado_pago;

    public Factura() {
    }

    public Factura(String folio, String fecha, String rut_cliente, String descripcion, String neto, String iva, String total, String estado_pago) {
        this.folio = folio;
        this.fecha = fecha;
        this.rut_cliente = rut_cliente;
        this.descripcion = descripcion;
        this.neto = neto;
        this.iva = iva;
        this.total = total;
        this.estado_pago = estado_pago;
    }
    
    

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getRut_cliente() {
        return rut_cliente;
    }

    public void setRut_cliente(String rut_cliente) {
        this.rut_cliente = rut_cliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNeto() {
        return neto;
    }

    public void setNeto(String neto) {
        this.neto = neto;
    }

    public String getIva() {
        return iva;
    }

    public void setIva(String iva) {
        this.iva = iva;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getEstado_pago() {
        return estado_pago;
    }

    public void setEstado_pago(String estado_pago) {
        this.estado_pago = estado_pago;
    }

}
