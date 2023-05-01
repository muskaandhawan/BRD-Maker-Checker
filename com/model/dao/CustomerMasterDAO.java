package com.model.dao;

import com.model.dao.daointerface.CustomerMasterDAOInterface;
import com.model.entity.CustomerMaster;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CustomerMasterDAO implements CustomerMasterDAOInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCustomer(CustomerMaster customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(customer);
            transaction.commit();
        }
    }

    @Override
    public void updateCustomer(CustomerMaster customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(customer);
            transaction.commit();
        }
    }

    @Override
    public void deleteCustomer(CustomerMaster customer){
        try(Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(customer);
            transaction.commit();
        }
    }

    @Override
    public CustomerMaster getById(String id){
        try(Session session = sessionFactory.openSession()) {
            return session.get(CustomerMaster.class, id);
        }
    }

    @Override
    public void saveOrUpdateCustomer(CustomerMaster customer){
        try(Session session = sessionFactory.openSession()){
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(customer);
            transaction.commit();
        }
    }

    @Override
    public List<CustomerMaster> getCustomers(){
        try(Session session = sessionFactory.openSession()){
            return session.createQuery(" from CustomerMaster", CustomerMaster.class).list();
        }
    }
}
