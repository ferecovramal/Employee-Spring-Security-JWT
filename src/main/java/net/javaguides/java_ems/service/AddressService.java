package net.javaguides.java_ems.service;

import net.javaguides.java_ems.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto createAddress(AddressDto addressDto);

    AddressDto getAddressById(Long id);

    List<AddressDto> getAllAddresses();

    AddressDto updateAddress(Long id, AddressDto updateAddress);

    void deleteAddress(Long id);
}
