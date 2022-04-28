/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import com.mycompany.tsi_web_accessdata.entity.Estado;
import com.mycompany.tsi_web_accessdata.entity.JAXRSConfiguration;
import java.io.StringReader;
import java.net.URL;
import java.util.Date;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.persistence.EntityManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 *
 * @author henry
 */
@ExtendWith(ArquillianExtension.class)
public class EstadoBeanIT {
    //esto es una prueba d enuevo
//    @Deployment
//    @RunAsClient
//    public static WebArchive crearDespliegue(){
//        WebArchive salida = ShrinkWrap.create(WebArchive.class)
//                .addPackage("com.mycompany.tsi_web_accessdata.entity")
//                .addAsResource("persistence-arquillian.xml")
//                .addClass(AbstractDataAccesss.class)
//                .addClass(EstadoBeanTest.class)
//                .addClass(JAXRSConfiguration.class)
//                .addClass(EstadoBeanIT.class)
//                .addAsResource("jenkins/META-INF/persistence.xml","jenkins/META-INF/persistence.xml")
//                .addAsResource("jenkins/META-INF/sql/datos.sql","jenkins/META-INF/sql/datos.sql")
//                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
//        System.out.println(salida.toString(true));
//        return salida;
//    }
    
    @ArquillianResource
    URL url;
    
    @Test
    @Order(1)
    @RunAsClient
    public void testFindAll(){
        System.out.println("findAll");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado").request("application/json").get();
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String totalTexto = respuesta.getHeaderString("Total-registros");
        Assertions.assertNotEquals(Integer.valueOf(0), Integer.valueOf(totalTexto));
        String cuerpoString = respuesta.readEntity(String.class);
        JsonReader lector = Json.createReader(new StringReader(cuerpoString));
        JsonArray listaJson = lector.readArray();
        int totalRegistros = listaJson.size();
        Assertions.assertTrue(totalRegistros>0);
        for(int i=0; i< listaJson.size(); i++){
            JsonObject objeto = listaJson.getJsonObject(i);
            System.out.println("ID: "+objeto.getInt("idEstado"));
        }
    }
    
    @Test
    @Order(2)
    @RunAsClient
    public void testFindById(){
        System.out.println("findById");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado/2").request("application/json").get();
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String cuerpoString = respuesta.readEntity(String.class);
        Assertions.assertTrue(!cuerpoString.isEmpty());
        System.out.println(cuerpoString);
    }
    
    @Test
    @Order(3)
    @RunAsClient
    public void testContar(){
        System.out.println("contar");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado/contar").request("application/json").get();
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String cuerpoString = respuesta.readEntity(String.class);
        Assertions.assertTrue(!cuerpoString.isEmpty());
        System.out.println("Tabla posee "+cuerpoString+" registros");
    }
    
    @Test
    @Order(4)
    @RunAsClient
    public void testCrear(){
        System.out.println("crear");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        Estado nuevo = new Estado();
        nuevo.setFechaCreacion(new Date());
        nuevo.setNombre("Prueba");
        nuevo.setObservaciones("Sin observacion");
        nuevo.setIdEstado(8);
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado").request("application/json").post(Entity.json(nuevo));
        System.out.println(respuesta.getStatus());
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String cuerpoString = respuesta.readEntity(String.class);
        Assertions.assertTrue(!cuerpoString.isEmpty());
        System.out.println(cuerpoString);
        Response contar = target.path("estado/contar").request("application/json").get();
        System.out.println("Tabla posee "+contar.readEntity(String.class)+" registros");
    }
    
    @Test
    @Order(5)
    @RunAsClient
    public void testModificar(){
        System.out.println("modificar");
        int resultadoEsperado = 200;
        Client cliente = ClientBuilder.newClient();
        Estado nuevo = new Estado();
        nuevo.setFechaCreacion(new Date());
        nuevo.setNombre("segunda prueba");
        nuevo.setObservaciones("Sin observacion");
        nuevo.setIdEstado(8);
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado").request("application/json").put(Entity.json(nuevo));
        System.out.println(respuesta.getStatus());
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        String cuerpoString = respuesta.readEntity(String.class);
        Assertions.assertTrue(!cuerpoString.isEmpty());
        System.out.println(cuerpoString);
    }
    
    @Test
    @Order(6)
    @RunAsClient
    public void testEliminar(){
        System.out.println("eliminar");
        int resultadoEsperado = 204;
        Client cliente = ClientBuilder.newClient();
        WebTarget target = cliente.target(url.toString()+"resources/");
        Response respuesta = target.path("estado/8").request("application/json").delete();
        System.out.println(respuesta.getStatus());
        Assertions.assertEquals(resultadoEsperado, respuesta.getStatus());
        Response contar = target.path("estado/contar").request("application/json").get();
        System.out.println("Tabla posee "+contar.readEntity(String.class)+" registros");
    }
}
