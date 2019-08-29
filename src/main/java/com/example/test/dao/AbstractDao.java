package com.example.test.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

// This class is not ready to use
@Service
public abstract class AbstractDao<E extends Serializable> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<E> entityClass;

    protected AbstractDao(final Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Transactional
    public EntityManager entityManager() {
        return entityManager;
    }

    @Transactional
    public E findById(final Long entityId) {
        return entityManager.find(entityClass, entityId);
    }

    @Transactional
    public void save(final E entityToBeSaved) {
        entityManager.persist(entityManager.merge(entityToBeSaved));
    }

//    @Transactional
//    public void update(final E entityToBeUpdated) {
//        entityManager.merge(entityToBeUpdated);
//    }

    @Transactional
    public void remove(final E entityToBeRemoved) {
        entityManager.remove(entityToBeRemoved);
    }

    @Transactional
    public void delete(final Long id) {
        entityManager.remove(findById(id));
    }

}
