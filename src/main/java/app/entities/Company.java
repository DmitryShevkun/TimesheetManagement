package app.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String logo;
    private Integer ownerId;

    public Company() {
    }

    public Company(Integer id, String name, String logoUrl, Integer ownerId) {
        this.id = id;
        this.name = name;
        this.logo = logoUrl;
        this.ownerId = ownerId;
    }

    public Company(Company company) {
        this(company.getId(),
                company.getName(),
                company.getLogo(),
                company.getOwnerId());
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogo() {
        return logo;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(getId(), company.getId()) &&
                Objects.equals(getName(), company.getName()) &&
                Objects.equals(getLogo(), company.getLogo()) &&
                Objects.equals(getOwnerId(), company.getOwnerId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLogo(), getOwnerId());
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", logo='" + logo + '\'' +
                ", ownerId=" + ownerId +
                '}';
    }

}