package daoImpl;

import dao.CustomerDao;
import org.hibernate.Session;
import table.Customer;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public class CustomerDaoImpl implements CustomerDao {

    public void addCustomer(Customer customer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }

    public Customer getCustomer(String login) throws SQLException {
        Session session = null;
        Customer result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.get(Customer.class, login);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }



    public List<Customer> getAllCustomers() throws SQLException {
        Session session = null;
        List<Customer>customers = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            customers = session.createCriteria(Customer.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return customers;
    }
}
