package net.javaguides.java_ems.mapper;

import net.javaguides.java_ems.dto.AddressDto;
import net.javaguides.java_ems.entity.Address;

public class AddressMapper {


    public static AddressDto mapToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setCity(address.getCity());
        addressDto.setStreet(address.getStreet());
        addressDto.setZipCode(address.getZipCode());
        if (address.getEmployee() != null) {
            addressDto.setEmployeeId(address.getEmployee().getId());
        }
        return addressDto;
    }

    public static Address mapToAddress(AddressDto addressDto) {
        Address address = new Address();
        address.setCity(addressDto.getCity());
        address.setStreet(addressDto.getStreet());
        address.setZipCode(addressDto.getZipCode());
        return address;
    }
}
