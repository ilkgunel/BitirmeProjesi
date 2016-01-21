/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Batuhan
 */
public abstract class GenericJPADAOImpl<T, PK extends Serializable> {

    protected Class<T> entityClass;

    @PersistenceContext
    protected EntityManager entityManager;

    public GenericJPADAOImpl() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    public T create(T t) {      
        this.entityManager.persist(t);
        return t;
    }

    //Constructor içerisinde yapılan işlem generic class a parametre olarak verilecek class ın 
    //elde edilmesine yarıyor.
    public T read(PK id) {
        T t = this.entityManager.find(entityClass, id);
        return t;
    }

    public T update(T t) {
        this.entityManager.merge(t);
        return t;
    }

    public T delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
        return t;
    }

    public Connection getConnection() {
        return this.entityManager.unwrap(Connection.class);
    }

    public List<T> readAll() {
        Query query = this.entityManager.createQuery(String.format("SELECT e FROM %s e", entityClass.getSimpleName()));
        return (List<T>) query.getResultList();
    }

}
