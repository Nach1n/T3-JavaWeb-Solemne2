/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author luis
 */
public interface CRUD_c {
    public List listar();
    public Cliente list(String rut);
    public boolean add(Cliente cli);
    public boolean edit(Cliente cli);
    public boolean eliminar(String rut);  
    
}
