/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.tsi_web_accessdata.entity.Estado;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.mockito.Mockito;

/**
 *
 * @author henry
 */
public class EstadoBeanTest {
    
    public EstadoBeanTest() {
    }

    /**
     * Test of crearDatos method, of class EstadoBean.
     */
    @Test
    public void testCrearDatos() throws Exception {
        System.out.println("crearDatos");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.crearDatos(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.crearDatos(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.crearDatos(nuevo);
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.crearDatos(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of modificarDatos method, of class EstadoBean.
     */
    @Test
    public void testModificarDatos() throws Exception {
        System.out.println("modificarDatos");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.modificarDatos(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.modificarDatos(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.modificarDatos(nuevo);
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.modificarDatos(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of eliminarDatos method, of class EstadoBean.
     */
    @Test
    public void testEliminarDatos() throws Exception {
        System.out.println("eliminarDatos");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        assertThrows(IllegalArgumentException.class, () ->{
            cut.eliminarDatos(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.eliminarDatos(nuevo);
        });
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        cut.em = mockEM;
        cut.eliminarDatos(nuevo);
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.eliminarDatos(nuevo);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findAll method, of class EstadoBean.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("finAll");
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        EstadoBean cut = new EstadoBean();
        List esperado = new ArrayList();

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findAll();
        } catch (Exception ex) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();

        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
            cut.em = mockEM;
            List datos = cut.findAll();
        } catch (Exception ex) {

        }
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(null);
            cut.em = mockEM;
            List datos = cut.findAll();
        } catch (Exception ex) {

        }
    }

    /**
     * Test of finRange method, of class EstadoBean.
     */
    @Test
    public void testFinRange() throws Exception {
        System.out.println("findRange");
        int primer_intervalo = 1;
        int segundo_intervalo = 2;
        List esperado = new ArrayList();

        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);

        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Estado.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        EstadoBean cut = new EstadoBean();

        assertThrows(IllegalStateException.class, () -> {
            cut.findAll();
        });

        try {
            cut.em = null;
            cut.finRange(primer_intervalo, segundo_intervalo);
            fail("entitymanager null");
        } catch (Exception ex) {
        }

        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(esperado);
            cut.em = mockEM;
            List datos = cut.finRange(primer_intervalo, segundo_intervalo);
        } catch (Exception ex) {

        }
        try {
            Mockito.when(mockTQ.getResultList()).thenReturn(null);
            cut.em = mockEM;
            List datos = cut.finRange(primer_intervalo, segundo_intervalo);
        } catch (Exception ex) {

        }
        
        cut.em = mockEM;
        List resultado = new ArrayList();
        resultado = cut.finRange(primer_intervalo, segundo_intervalo);
        assertNotNull(resultado);
        assertEquals(esperado, resultado);

        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.finRange(primer_intervalo, segundo_intervalo);
        } catch (Exception ex) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    /**
     * Test of findById method, of class EstadoBean.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findAll");
        Integer id = 1;
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        
        Estado esperando = new Estado();
        EstadoBean cut = new EstadoBean();
        Mockito.when(mockEM.find(Estado.class, id)).thenReturn(esperando);
        assertThrows(IllegalArgumentException.class, () ->{
            cut.findById(null);
        });
        assertThrows(IllegalStateException.class, () ->{
            cut.findById(id);
        });
        cut.em = mockEM;
        Estado encontrado = cut.findById(id);
        assertNotNull(encontrado);
        assertEquals(esperando, encontrado);
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.findById(id);
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }
    
    /**
     * Test of findById method, of class EstadoBean.
     */
    @Test
    public void testcontar() throws Exception {
        
        /**
         * Declaración de todas las variables a utilizar en el test.
         */
        
        System.out.println("contar");
        Long esperado = Long.valueOf(1);
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        
        /**
         * Desarrollo del test.
         */
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(esperado);
        EstadoBean cut = new EstadoBean();
        
        assertThrows(IllegalStateException.class, () ->{
            cut.contar();
        });
        
        cut.em = mockEM;
        Long resultado = cut.contar();
        assertNotNull(resultado);
        assertEquals(esperado, resultado);
        
        try {
            cut.em = null;
            cut.contar();
            fail("El EntityManager era NULO.");
        } catch (Exception e) {
        }
        
        EstadoBean espia = Mockito.spy(EstadoBean.class);
        espia.em = mockEM;
        
        Mockito.when(espia.getEntityManager()).thenThrow(NullPointerException.class);
        try {
            espia.contar();
        } catch (Exception e) {
        }
        Mockito.verify(espia, Mockito.times(1)).getEntityManager();
    }

    
    /**
     * Test of consulta method, of class EstadoBean.
     */
    @Test
    public void consulta() throws Exception {
        System.out.println("consulta");
        Estado nuevo = new Estado();
        EstadoBean cut = new EstadoBean();
        EntityManager mockEM = Mockito.mock(EntityManager.class);
        CriteriaBuilder mockCB = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery mockCQ = Mockito.mock(CriteriaQuery.class);
        TypedQuery mockTQ = Mockito.mock(TypedQuery.class);
        
        /**
         * Desarrollo del test.
         */
        
        Mockito.when(mockEM.getCriteriaBuilder()).thenReturn(mockCB);
        Mockito.when(mockCB.createQuery(Long.class)).thenReturn(mockCQ);
        Mockito.when(mockEM.createQuery(mockCQ)).thenReturn(mockTQ);
        Mockito.when(mockTQ.getSingleResult()).thenReturn(nuevo);
        assertThrows(IllegalArgumentException.class, () ->{
            cut.consulta(null);
        });
        
        cut.em = mockEM;
        //cut.consulta(mockEM);
    }
    
    
    /**
     * Test of getEntityManager method, of class EstadoBean.
     */
//    @Test
//    public void testGetEntityManager() throws Exception {
//        System.out.println("getEntityManager");
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        EstadoBean instance = (EstadoBean)container.getContext().lookup("java:global/classes/EstadoBean");
//        EntityManager expResult = null;
//        EntityManager result = instance.getEntityManager();
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
