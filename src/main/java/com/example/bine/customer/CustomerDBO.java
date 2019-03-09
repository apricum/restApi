package com.example.bine.customer;

import com.example.bine.address.AddressDBO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//@Data
@Entity
@Table(name = "CUSTOMER")
//@NoArgsConstructor
//@AllArgsConstructor
public class CustomerDBO implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "FIRSTNAME" )
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_ADDRESS", joinColumns = @JoinColumn(name="CUSTOMER_ID"), inverseJoinColumns = @JoinColumn(name="ADDRESS_ID"))
    Set<AddressDBO> addresses = new HashSet<>();

    public CustomerDBO() {
    }

    public CustomerDBO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<AddressDBO> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<AddressDBO> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDBO that = (CustomerDBO) o;
        return id.equals(that.id) &&
                firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }

    @Override
    public String toString() {
        return "CustomerDBO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
