package table;

import javax.persistence.*;

/**
 * Created by FromxSoul on 22.05.2016.
 */
@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int companyId;

    @Column(name = "company_name")
    private String compName;

    @Column(name = "company_specific")
    private String compSpecific;

    @Column(name = "city_location")
    private String cityLocation;

    public Company() {

    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompSpecific() {
        return compSpecific;
    }

    public void setCompSpecific(String compSpecific) {
        this.compSpecific = compSpecific;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(String cityLocation) {
        this.cityLocation = cityLocation;
    }
}
