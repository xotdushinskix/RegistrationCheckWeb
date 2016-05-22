package dao;

import table.Company;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by FromxSoul on 22.05.2016.
 */
public interface CompanyDao {

    void addCompany(Company company) throws SQLException;
    Company getCompany(int companyId) throws SQLException;
    List<Company> getAllCompanies() throws SQLException;

}
