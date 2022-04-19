/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.tsi_web_accessdata.entity.Estado;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author henry
 */
@ExtendWith(ArquillianExtension.class)
public class EstadoBeanIT {
    
    @Deployment
    public static WebArchive crearDespliegue(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addPackage("com.mycompany.tsi_web_accessdata.entity")
                .addAsResource("persistence-arquillian.xml")
                .addClass(AbstractDataAccesss.class)
                .addClass(EstadoBeanTest.class)
                .addAsResource("META-INF/persistence.xml","META-INF/persistence.xml")
                .addAsResource("META-INF/sql/datos.sql","META-INF/sql/datos.sql")
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        System.out.println(salida.toString(true));
        return salida;
    }
    
    @Inject
    EstadoBean cut;
    
    public void testFindAll(){
        System.err.println("FindAll");
        Assertions.assertNotNull(cut);
        List<Estado> resultado = cut.findAll();
        Assertions.assertNotNull(resultado);
        Assertions.assertTrue(!resultado.isEmpty());
        System.err.println("La lista posee" + resultado.size());
    }
    
//    
//    public void testCrearDatos() throws Exception {
//        System.out.println("controlador.EstadoBeanIT.testCrearDatos()");
//        assertNotNull(cut);
//        String esperado = EstadoBean.NOMBRE_USUARIO;
//        String resultado = cut.getNombreUsuario(1);
//        assertNotNull(resultado);
//        assertEquals(esperado, resultado);
//    }
//
//    /**
//     * Test of modificarDatos method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testModificarDatos() throws Exception {
//        System.out.println("modificarDatos");
//        Estado nuevo = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        instance.modificarDatos(nuevo);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of eliminarDatos method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testEliminarDatos() throws Exception {
//        System.out.println("eliminarDatos");
//        Estado nuevo = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        instance.eliminarDatos(nuevo);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findAll method, of class EstadoBean.
//     */
////    @org.junit.Test
////    public void testFindAll() throws Exception {
////        System.out.println("findAll");
////        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
////        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
////        List<Estado> expResult = null;
////        List<Estado> result = instance.findAll();
////        assertEquals(expResult, result);
////        container.close();
////        // TODO review the generated test code and remove the default call to fail.
////    }
//
//    /**
//     * Test of finRange method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testFinRange() throws Exception {
//        System.out.println("finRange");
//        int firts = 0;
//        int pageSize = 0;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        List<Estado> expResult = null;
//        List<Estado> result = instance.finRange(firts, pageSize);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of findById method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testFindById() throws Exception {
//        System.out.println("findById");
//        Object id = null;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        Estado expResult = null;
//        Estado result = instance.findById(id);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of contar method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testContar() throws Exception {
//        System.out.println("contar");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        Long expResult = null;
//        Long result = instance.contar();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//    }
//
//    /**
//     * Test of getEntityManager method, of class EstadoBean.
//     */
//    @org.junit.Test
//    public void testGetEntityManager() throws Exception {
//        System.out.println("getEntityManager");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEntityManager();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//    }
}
