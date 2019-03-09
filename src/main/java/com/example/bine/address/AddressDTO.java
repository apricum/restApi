package com.example.bine.address;


import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@JGlobalMap
@NoArgsConstructor
@AllArgsConstructor
public class AddressDTO {

    Long id;
    String street;
    Integer number;
    String city;
    String zipCode;
    String country;


}
