/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.daoImpl;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.util.List;
import javax.persistence.Cache;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Batuhan
 * @param <T>
 * @param <PK>
 */
public abstract class JPAService<T, PK extends Serializable> {

    protected Class<T> entityClass;
    protected Integer id;

    @PersistenceContext
    protected EntityManager entityManager;

    public JPAService() {
        ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
    }

    public T create(T t) {
        this.entityManager.persist(t);
        this.entityManager.flush();
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
        this.entityManager.flush();
        return t;
    }

    public T delete(T t) {
        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
        this.entityManager.flush();
        return t;
    }

    public boolean isCachable(T t, Integer id) throws Exception {
        Field field = this.entityClass.getField("id");
        this.id = field.getInt(this.entityClass);
        
        Cache cache = getEntityManagerFactory().getCache();
        return cache.contains(this.entityClass, id);
    }
    
    
    
    public void evictCacheForEntity(){
        getEntityManagerFactory().getCache().evict(this.entityClass);
    }

    public void evictAllCache() {
        getEntityManagerFactory().getCache().evictAll();
    }

    public Connection getConnection() {
        return this.entityManager.unwrap(Connection.class);
    }

    public List<T> readAll() {
        Query query = this.entityManager.createQuery(String.format("SELECT e FROM %s e", entityClass.getSimpleName()));
        return (List<T>) query.getResultList();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManager.getEntityManagerFactory();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public <T> List<T> selectAllUsingNativeQuery() {
        Query query = getEntityManager().createNativeQuery("SELECT * FROM " + entityClass.getSimpleName());
        List<T> entityList = (List<T>) query.getResultList();
        return entityList;
    }

    public int deleteUsingNativeQueryById(Integer id) {
        if (id != 0 && id > 0) {
            Query query = getEntityManager().createNativeQuery("DELETE * FROM " + entityClass.getSimpleName() + " WHERE id=?");
            query.setParameter(1, id);

            return query.executeUpdate();
        }
        return -1;
    }

    public <T> List<T> readAllASCUsingCriteriaAPI(Class<T> classz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
        Root<T> from = criteriaQuery.from(classz);

        criteriaQuery.select(from);
        criteriaQuery.orderBy(criteriaBuilder.asc(from.get("id")));
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        List<T> resultList = typedQuery.getResultList();

        return resultList;
    }
    
     public <T> List<T> readAllDESCUsingCriteriaAPI(Class<T> classz) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = (CriteriaQuery<T>) criteriaBuilder.createQuery();
        Root<T> from = criteriaQuery.from(classz);

        criteriaQuery.select(from);
        criteriaQuery.orderBy(criteriaBuilder.desc(from.get("id")));
        TypedQuery<T> typedQuery = entityManager.createQuery(criteriaQuery);
        List<T> resultList = typedQuery.getResultList();

        return resultList;
    }

}
