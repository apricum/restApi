package com.example.bine.address;

import com.example.bine.customer.CustomerDBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@Data
@Entity
@Table(name="ADDRESS")
//@NoArgsConstructor
//@AllArgsConstructor
public class AddressDBO {

    @Id
    @Column(name="ID")
    Long id;
    @Column(name="STREET")
    String street;
    @Column(name="NUMBER")
    Integer number;
    @Column(name="CITY")
    String city;
    @Column(name="ZIP_CODE")
    String zipCode;
    @Column(name="COUNTRY")
    String country;

    @ManyToMany(mappedBy = "addresses")
    Set<CustomerDBO> customers = new HashSet<>();

    public AddressDBO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<CustomerDBO> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<CustomerDBO> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDBO that = (AddressDBO) o;
        return id.equals(that.id) &&
                street.equals(that.street) &&
                number.equals(that.number) &&
                city.equals(that.city) &&
                zipCode.equals(that.zipCode) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, number, city, zipCode, country);
    }

    @Override
    public String toString() {
        return "AddressDBO{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", number=" + number +
                ", city='" + city + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
