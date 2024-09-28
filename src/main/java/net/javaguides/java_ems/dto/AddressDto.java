package net.javaguides.java_ems.dto;

import lombok.Data;

@Data
public class AddressDto {
    private Long id;
    private String city;
    private String street;
    private String zipCode;
    private Long employeeId;
}
