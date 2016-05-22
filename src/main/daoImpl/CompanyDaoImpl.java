package daoImpl;

import dao.CompanyDao;
import org.hibernate.Session;
import table.Company;
import util.HibernateUtil;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public class CompanyDaoImpl implements CompanyDao {

    public void addCompany(Company company) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(company);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
    }



    public Company getCompany(int companyId) throws SQLException {
        Session session = null;
        Company result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            result = session.get(Company.class, companyId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return result;
    }



    public List<Company> getAllCompanies() throws SQLException {
        Session session = null;
        List<Company>companies = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            companies = session.createCriteria(Company.class).list();
         } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if ((session != null) && (session.isOpen())) {
                session.close();
            }
        }
        return companies;
    }
}
