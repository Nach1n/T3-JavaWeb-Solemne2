
package Intefaces;

import Modelo.Factura;
import java.util.List;


public interface CRUD_f {
    public List listar();
    public List listar_estado_pago();
    public Factura list(String folio);
    public boolean add(Factura fac);
    public boolean edit(Factura fac);
    public boolean eliminar(String folio);
    
}
