package factory;

import dao.CompanyDao;
import dao.CustomerDao;
import daoImpl.CompanyDaoImpl;
import daoImpl.CustomerDaoImpl;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public class Factory {

    private static Factory instance = null;
    private static CustomerDao customerDao = null;
    private static CompanyDao companyDao = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public static synchronized CustomerDao getCustomerDao() {
        if (customerDao == null) {
            customerDao = new CustomerDaoImpl();
        }
        return customerDao;
    }


    public static synchronized CompanyDao getCompanyDao() {
        if (companyDao == null) {
            companyDao = new CompanyDaoImpl();
        }
        return companyDao;
    }



}
