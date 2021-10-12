package com.evgeniy.spring.mvcCrud.dao;

import com.evgeniy.spring.mvcCrud.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getStudents() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        Root<Student> root = cq.from(Student.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student book = session.byId(Student.class).load(id);
        session.delete(book);
    }

    @Override
    public void saveStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(student);
    }

    @Override
    public Student getStudent(int theId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student = currentSession.get(Student.class, theId);
        return student;
    }
}
