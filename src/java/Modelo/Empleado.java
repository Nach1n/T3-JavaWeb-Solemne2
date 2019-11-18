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
public class Empleado {

    int rut;
    String nombre;
    String apellido;
    String celular;
    String dpto;
    String sbase;
    
    public Empleado() {
    }

    public Empleado(int rut, String nombre, String apellido, String celular, String dpto, String sbase) {
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;
        this.dpto = dpto;
        this.sbase = sbase;
    }

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getSbase() {
        return sbase;
    }

    public void setSbase(String sbase) {
        this.sbase = sbase;
    }
    
    
    

}
