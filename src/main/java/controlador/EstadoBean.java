/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.tsi_web_accessdata.entity.Estado;
import java.io.Serializable;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author henry
 */

@Stateless
@LocalBean

public class EstadoBean extends AbstractDataAccesss<Estado> implements Serializable{
    
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;
    
    public EstadoBean(){
        super(Estado.class);
    }
            
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}
