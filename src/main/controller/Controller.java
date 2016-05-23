package controller;

import dao.CompanyDao;
import dao.CustomerDao;
import factory.Factory;
import table.Company;
import table.Customer;
import util.HibernateUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by FromxSoul on 22.05.2016.
 */
@WebServlet("/Controller")
public class Controller extends Forward {
    private static String START_PAGE = "/index.jsp";
    private static String REPEAT_LOGIN = "/loginRepeat.jsp";
    private static String OK_PAGE = "/ok.jsp";
    private Factory factory = Factory.getInstance();
    private CustomerDao customerDao = factory.getCustomerDao();
    private CompanyDao companyDao = factory.getCompanyDao();
    private Customer customer;
    private Company company;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();
        request.getParameter("action");
            super.forward(START_PAGE, request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();

        String customerLogin = request.getParameter("login");
        String customerPassword = request.getParameter("password");

        if (request.getParameter("site_enter") !=null) {
            try {
                try {
                    customer = customerDao.getCustomer(customerLogin);
                } catch (Exception e) {
                    super.forward(REPEAT_LOGIN, request, response);
                }
                try {
                    String password = customer.getPassword();
                    if (password.equals(customerPassword)) {
                        request.setAttribute("companies", companyDao.getAllCompanies());
                        super.forward(OK_PAGE, request, response);
                    } else {
                        super.forward(REPEAT_LOGIN, request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                } catch (Exception e) {
                    super.forward(REPEAT_LOGIN, request, response);
                }
        }
    }
}
