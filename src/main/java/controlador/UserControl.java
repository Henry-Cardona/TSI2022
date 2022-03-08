/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.persistence.EntityManager;
import conexion.Conexion;
import com.mycompany.tsi_web_accessdata.entity.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.xml.registry.infomodel.User;
/**
 *
 * @author henry
 */

public class UserControl {
    
    Date fechaahora = new Date();
    Estado estado = Estado();
    Objeto objeto = Objeto();
    
    public void CrearUser(String estado){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.persist(estado);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public void EditarUser(String estado){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.merge(estado);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public void EliminarUser(String estado){
        EntityManager enti = entityManager();
        try {
            enti.getTransaction().begin();
            enti.remove(estado);
            enti.getTransaction().commit();
        } catch (Exception e) {
            enti.getTransaction().rollback();
        }
    }
    
    public List<User> ExtraerUsuarios(){
        try {
            Query query = entityManager().createQuery("Select * from User u");
            return query.getResultList();
        } catch (Exception e) {
            List error = new ArrayList();
            error.add(e);
            return error;
        }
    }
    
    
    
    private EntityManager entityManager(){
        return Conexion.getInstacia().getFabrica().createEntityManager();
    }

    private Estado Estado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Objeto Objeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
