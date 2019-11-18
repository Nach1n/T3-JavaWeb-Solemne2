/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Intefaces;

import Modelo.Horasextras;
import java.util.List;

/**
 *
 * @author luis
 */
public interface CRUD_horasextras {
    public List listar();
    public Horasextras list(int folio);
    public boolean add(Horasextras cli);
    public boolean edit(Horasextras cli);
    public boolean eliminar(int folio); 
    
}
