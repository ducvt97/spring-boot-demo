package com.example.test.dao;

import com.example.test.entity.StudentEntity;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

// This class is not ready to use
@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class StudentDao extends AbstractDao<StudentEntity> implements IGenericDao<StudentEntity>{

    protected StudentDao(Class<StudentEntity> entityClass) {
        super(entityClass);
    }

    public StudentEntity findByID(long id){
        return entityManager().find(StudentEntity.class, id);
    }

    public List<StudentEntity> findByNameAndPhone(String name, String phone){
        try{
            CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
            CriteriaQuery<StudentEntity> criteriaQuery = criteriaBuilder.createQuery(StudentEntity.class);

            Root<StudentEntity> student = criteriaQuery.from(StudentEntity.class);
            List<Predicate> predicateList = new ArrayList<Predicate>();

            if(!StringUtils.isEmpty(name)){
                predicateList.add(criteriaBuilder.like(student.get("name"), "%" + name + "%"));
            }

            if(!StringUtils.isEmpty(phone)){
                predicateList.add(criteriaBuilder.like(student.get("phone"), "%" + phone + "%"));
            }

            criteriaQuery.where(predicateList.toArray(new Predicate[0]));

            return entityManager().createQuery(criteriaQuery).getResultList();
        }catch (Exception e){
            throw e;
        }

    }

    public Boolean deleteStudent(long id){
        try{
            CriteriaBuilder criteriaBuilder = entityManager().getCriteriaBuilder();
            CriteriaDelete<StudentEntity> criteriaDelete = criteriaBuilder.createCriteriaDelete(StudentEntity.class);

            Root<StudentEntity> student = criteriaDelete.from(StudentEntity.class);
            Predicate predicate = criteriaBuilder.equal(student.get("id"), id);

            criteriaDelete.where(predicate);
            entityManager().createQuery(criteriaDelete);
            return true;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public StudentEntity findOne(long id) {
        return findOne(id);
    }

    @Override
    public List<StudentEntity> findAll() {
        return null;
    }

    @Override
    public void create(StudentEntity entity) {

    }

    @Override
    public void delete(StudentEntity entity) {

    }

    @Override
    public void deleteById(long entityId) {

    }
}
