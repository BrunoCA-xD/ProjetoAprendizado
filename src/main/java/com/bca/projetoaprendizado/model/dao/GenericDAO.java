/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bca.projetoaprendizado.model.dao;

import com.bca.projetoaprendizado.util.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import java.util.function.Predicate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.Query;

/**
 *
 * @author bruno
 */
public abstract class GenericDAO<T, I extends Serializable> {

    //Fonte preciosa https://developer.jboss.org/wiki/GenericDataAccessObjects
    protected EntityManager entityManager;

    private Class<T> persistedClass;

    protected GenericDAO() {
    }

    protected GenericDAO(Class<T> persistedClass) {
        this();
        this.persistedClass = persistedClass;
        entityManager = HibernateUtil.getSessionFactory().createEntityManager();
    }

    public boolean salvar(T entity) {
        System.out.println(entityManager.getClass());
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.persist(entity);
        entityManager.flush();
        t.commit();
        return true;

    }

    public T atualizar(T entity) {
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        entityManager.merge(entity);
        entityManager.flush();
        t.commit();
        return entity;

    }

    public void remover(I id) {
        T entity = encontrar(id);
        EntityTransaction t = entityManager.getTransaction();
        t.begin();
        T mergedEntity = entityManager.merge(entity);
        entityManager.remove(mergedEntity);
        entityManager.flush();
        t.commit();
    }

    public List<T> getList() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        query.from(persistedClass);
        System.out.println("\n\n\n\n" + persistedClass.getSimpleName().substring(0, persistedClass.getSimpleName().length() - 2));
        return entityManager.createQuery(query).getResultList();
    }

    public List<T> getList(String col, String search) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(persistedClass);
        Query q = entityManager.createQuery("SELECT p FROM "
                + persistedClass.getSimpleName()
                + " p WHERE p." + col + " LIKE :search");
        q.setParameter("search", search +"%");
        return q.getResultList();

    }

    public T encontrar(I id) {

        return entityManager.find(persistedClass, id);
    }
}
