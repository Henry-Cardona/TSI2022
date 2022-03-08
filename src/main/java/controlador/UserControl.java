/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import conexion.Conexion;
import com.mycompany.tsi_web_accessdata.entity.Estado;
import java.util.List;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;
/**
 *
 * @author henry
 */

public class UserControl {
    
    public void CrearUser(Estado id){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.persist(id);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public void EditarUser(Estado id){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.merge(id);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public void EliminarUser(Estado id){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.remove(id);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public List<User> ExtraerUsuarios(){
        Query query = entityManager().createQuery("Select * from User u");
        return query.getResultList();
    }
    
    private EntityManager entityManager(){
        return Conexion.getInstacia().getFabrica().createEntityManager();
    }
}
