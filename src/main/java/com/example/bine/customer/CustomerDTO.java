package com.example.bine.customer;

import com.example.bine.address.AddressDBO;
import com.example.bine.address.AddressDTO;
import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@JGlobalMap
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    Set<AddressDTO> addresses;
}
