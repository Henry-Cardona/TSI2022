/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author henry
 */

public class Conexion {
    
    private static Conexion instacia = new Conexion();
    private EntityManagerFactory fabrica;
    
    private Conexion(){
        fabrica = Persistence.createEntityManagerFactory("my_persistence_unit");
    }

    public static Conexion getInstacia() {
        return instacia;
    }

    public EntityManagerFactory getFabrica() {
        return fabrica;
    }
    
}
