/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * @author henry
 */
public abstract class AbstractDataAccesss<T> implements Serializable {

    protected final Class clase;

    public AbstractDataAccesss(Class clase) {
        this.clase = clase;
    }

    public abstract EntityManager getEntityManager();

    public void crearDatos(T nuevo) throws IllegalArgumentException, IllegalStateException {
        if (nuevo != null) {
            EntityManager em = null;
            try {
                em = getEntityManager();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
            }
            if (em != null) {
                em.persist(nuevo);
                return;
            } else {
                throw new IllegalStateException();
            }
        }
        throw new IllegalArgumentException("No se ha podido crear el nuevo registro");
    }

    public void modificarDatos(T nuevo) throws IllegalArgumentException, IllegalStateException {
        if (nuevo != null) {
            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
            }
            if (em != null) {
                em.merge(nuevo);
                return;
            } else {
                throw new IllegalStateException("El registro no se ha modificado.");
            }
        }
        throw new IllegalArgumentException();
    }
    
    public void eliminarDatos(T nuevo) throws IllegalArgumentException, IllegalStateException{
        if (nuevo != null) {
            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
            }
            if (em != null) {
                em.remove(em.merge(nuevo));
                return;
            } else {
                throw new IllegalStateException("El registro no se ha eliminado.");
            }
        }
        throw new IllegalArgumentException();
    }
    
    public List<T> findAll() throws IllegalStateException {
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
        }
        if (em != null) {
            TypedQuery query = consulta(em);
            List datosObtenidos = query.getResultList();
            if (datosObtenidos != null) {
                return datosObtenidos;
            } else {
                return Collections.EMPTY_LIST;
            }
        }
        throw new IllegalStateException("Error en la persistencia");
    }
    
    public List<T> finRange(int firts, int pageSize) throws IllegalStateException{
        EntityManager em = null;
        try {
            em = this.getEntityManager();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
        }
        if (em != null) {
            TypedQuery query = this.consulta(em);
            query.setFirstResult(firts);
            query.setMaxResults(pageSize);
            List datosObtenidos = query.getResultList();
            if (datosObtenidos != null) {
                return datosObtenidos;
            }
            return Collections.EMPTY_LIST;
        }
        throw new IllegalStateException("ERROR");
    }
    
    public T findById(final Object id) throws IllegalArgumentException, IllegalStateException{
        if (id != null) {
            EntityManager em = null;
            try {
                em = this.getEntityManager();
            } catch (Exception e) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
            }
            if (em != null) {
                return (T) em.find(clase, id);
            }
            throw new IllegalStateException("ERROR");
        }
        throw new IllegalArgumentException("ERROR");
    }
    
    protected TypedQuery consulta(EntityManager em){
        if (em != null) {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(clase);
            Root<T> raiz = cq.from(clase);
            cq.select(raiz);
            return em.createQuery(cq);
        }
        throw new IllegalArgumentException("ERROR");
    }
    
    public Long contar() throws IllegalStateException{
        EntityManager em = null;
        try{
            em = this.getEntityManager();
        }catch(Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "EntityManager NULO");
        }
        if(em!=null){
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Long> cq = cb.createQuery(Long.class);
            cq.select(cb.count(cq.from(clase)));
            return em.createQuery(cq).getSingleResult();
        }
        throw new IllegalStateException("No se puede obtener persistencia");
    }
}
