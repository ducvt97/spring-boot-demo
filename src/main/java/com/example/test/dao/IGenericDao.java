package com.example.test.dao;

import java.io.Serializable;
import java.util.List;

// This interface is not ready to use
public interface IGenericDao<T extends Serializable> {

    T findOne(final long id);

    List<T> findAll();

    void create(final T entity);

//    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}
