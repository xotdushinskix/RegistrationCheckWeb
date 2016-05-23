package util;

import dao.CompanyDao;
import dao.CustomerDao;
import factory.Factory;
import table.Company;
import table.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public class Main {

    public static void main (String[] args) throws SQLException {
        HibernateUtil.getSessionFactory();

        Factory factory = Factory.getInstance();
        CustomerDao customerDao = factory.getCustomerDao();
        CompanyDao companyDao = factory.getCompanyDao();

        Customer customer = new Customer();
        customer.setFirstName("Dale");
        customer.setLastName("Krakovski");
        customer.setLogin("dal.krak@gmail.com");
        customer.setPassword("dal_krak");
        customerDao.addCustomer(customer);

        Customer customer1 = new Customer();
        customer1.setFirstName("Kevin");
        customer1.setLastName("Tario");
        customer1.setLogin("kev.tario@gmail.com");
        customer1.setPassword("kev.tario");
        customerDao.addCustomer(customer1);

        Company company = new Company();
        company.setCompName("Oracle");
        company.setCompSpecific("software");
        company.setCityLocation("Los-Angeles");
        companyDao.addCompany(company);

        Company company1 = new Company();
        company1.setCompName("Lewis");
        company1.setCompSpecific("wear");
        company1.setCityLocation("San-Hose");
        companyDao.addCompany(company1);

        Company company2 = new Company();
        company2.setCompName("Asus");
        company2.setCompSpecific("hardware");
        company2.setCityLocation("San-Francisco");
        companyDao.addCompany(company2);

//        Customer customer = customerDao.getCustomer("dal.krak@gmail.com");
//        String password = customer.getPassword();
//        if (password.equals("dal_krak")) {
//            System.out.println("ok");
//        } else {
//            System.out.println("bad");
//        }

        //System.out.println(customer.getFirstName());

//        List<Company> companies = companyDao.getAllCompanies();
//        for (Company company : companies) {
//            System.out.println(company.getCompName());
//        }


    }

}
