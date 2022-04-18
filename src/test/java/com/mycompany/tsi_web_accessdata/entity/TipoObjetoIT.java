/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tsi_web_accessdata.entity;

import controlador.AbstractDataAccesss;
import java.util.Date;
import java.util.List;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author henry
 */
@ExtendWith(ArquillianExtension.class)
public class TipoObjetoIT {
    
    public TipoObjetoIT() {
    }

    /**
     * Test of getIdTipoObjeto method, of class TipoObjeto.
     */
    @Test
    public void testGetIdTipoObjeto() {
        System.out.println("getIdTipoObjeto");
        TipoObjeto instance = new TipoObjeto();
        Integer expResult = null;
        Integer result = instance.getIdTipoObjeto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdTipoObjeto method, of class TipoObjeto.
     */
    @Test
    public void testSetIdTipoObjeto() {
        System.out.println("setIdTipoObjeto");
        Integer idTipoObjeto = null;
        TipoObjeto instance = new TipoObjeto();
        instance.setIdTipoObjeto(idTipoObjeto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getActivo method, of class TipoObjeto.
     */
    @Test
    public void testGetActivo() {
        System.out.println("getActivo");
        TipoObjeto instance = new TipoObjeto();
        Boolean expResult = null;
        Boolean result = instance.getActivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setActivo method, of class TipoObjeto.
     */
    @Test
    public void testSetActivo() {
        System.out.println("setActivo");
        Boolean activo = null;
        TipoObjeto instance = new TipoObjeto();
        instance.setActivo(activo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaCreacion method, of class TipoObjeto.
     */
    @Test
    public void testGetFechaCreacion() {
        System.out.println("getFechaCreacion");
        TipoObjeto instance = new TipoObjeto();
        Date expResult = null;
        Date result = instance.getFechaCreacion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaCreacion method, of class TipoObjeto.
     */
    @Test
    public void testSetFechaCreacion() {
        System.out.println("setFechaCreacion");
        Date fechaCreacion = null;
        TipoObjeto instance = new TipoObjeto();
        instance.setFechaCreacion(fechaCreacion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getObjetoList method, of class TipoObjeto.
     */
    @Test
    public void testGetObjetoList() {
        System.out.println("getObjetoList");
        TipoObjeto instance = new TipoObjeto();
        List<Objeto> expResult = null;
        List<Objeto> result = instance.getObjetoList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setObjetoList method, of class TipoObjeto.
     */
    @Test
    public void testSetObjetoList() {
        System.out.println("setObjetoList");
        List<Objeto> objetoList = null;
        TipoObjeto instance = new TipoObjeto();
        instance.setObjetoList(objetoList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class TipoObjeto.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        TipoObjeto instance = new TipoObjeto();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class TipoObjeto.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        TipoObjeto instance = new TipoObjeto();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class TipoObjeto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        TipoObjeto instance = new TipoObjeto();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
