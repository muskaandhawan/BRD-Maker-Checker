package com.model.dao;

import com.model.dao.daointerface.CustomerTempDAOInterface;
import com.model.entity.CustomerTemp;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerTempDAO implements CustomerTempDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(CustomerTemp customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }

    @Override
    public void updateCustomer(CustomerTemp customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }

    public void deleteCustomer(CustomerTemp customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }

    public CustomerTemp getById(String id){
        try(Session session = sessionFactory.openSession()) {
            return session.get(CustomerTemp.class, id);
        }
    }

    public void saveOrUpdateCustomer(CustomerTemp customer){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        }
    }

    public List<CustomerTemp> getCustomers(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery("from CustomerTemp", CustomerTemp.class).getResultList();
        }
    }
}