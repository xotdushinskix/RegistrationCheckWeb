package dao;

import table.Customer;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public interface CustomerDao {

    void addCustomer(Customer customer) throws SQLException;
    Customer getCustomer(String login) throws SQLException;
    List<Customer> getAllCustomers() throws SQLException;

}
