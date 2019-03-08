package com.example.bine.customer;

import com.googlecode.jmapper.annotations.JGlobalMap;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JGlobalMap
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {

    private Long id;

    private String firstName;


    private String lastName;
}
