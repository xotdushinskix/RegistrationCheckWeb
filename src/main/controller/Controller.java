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
public class Controller extends HttpServlet {

    private Factory factory = Factory.getInstance();
    private CustomerDao customerDao = factory.getCustomerDao();
    private CompanyDao companyDao = factory.getCompanyDao();
    private Customer customer;
    private Company company;



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();
        request.getParameter("action");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HibernateUtil.getSessionFactory();

        String customerLogin = request.getParameter("login");
        String customerPassword = request.getParameter("password");

        if (request.getParameter("site_enter") !=null) {
            try {
                customer = customerDao.getCustomer(customerLogin);
                String password = customer.getPassword();
                if (password.equals(customerPassword)) {
                    request.setAttribute("companies", companyDao.getAllCompanies());
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/ok.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/loginRepeat.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
