/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces;

import Modelo.Empleado;
import java.util.List;

/**
 *
 * @author luis
 */
public interface CRUD_empleado {
    public List listar();
    public Empleado list(int rut);
    public boolean add(Empleado cli);
    public boolean edit(Empleado cli);
    public boolean eliminar(int rut);  
    
}
