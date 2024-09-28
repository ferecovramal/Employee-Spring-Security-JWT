package net.javaguides.java_ems.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.java_ems.dto.AddressDto;
import net.javaguides.java_ems.entity.Address;
import net.javaguides.java_ems.entity.Employee;
import net.javaguides.java_ems.exception.CityException;
import net.javaguides.java_ems.exception.ResourceNotFoundException;
import net.javaguides.java_ems.exception.StreetException;
import net.javaguides.java_ems.exception.ZipCodeException;
import net.javaguides.java_ems.mapper.AddressMapper;
import net.javaguides.java_ems.repository.AddressRepository;
import net.javaguides.java_ems.repository.EmployeeRepository;
import net.javaguides.java_ems.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public AddressDto createAddress(AddressDto addressDto) {
        Employee employee = employeeRepository.findById(addressDto.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + addressDto.getEmployeeId()));

        validateCity(addressDto.getCity());
        validateStreet(addressDto.getStreet());
        validateZipCode(addressDto.getZipCode());

        Address address = AddressMapper.mapToAddress(addressDto);
        address.setEmployee(employee);

        Address savedAddress = addressRepository.save(address);
        return AddressMapper.mapToAddressDto(savedAddress);
    }

    private void validateCity(String cityName){
        if (cityName.matches(".*[çÇğĞıöÖşŞüÜ].*")) {
            throw new CityException("Şehir ismi Türkçe karakter içeremez.");
        }
    }

    private void validateStreet(String streetName){
        if (streetName.matches(".*(Cadde|Sokak|Mahallesi).*")) {
            throw new StreetException("Sokak adı 'Cadde', 'Sokak' veya 'Mahallesi' ifadelerini içeremez.");
        }
    }

    private void validateZipCode(String zipCode) {
        if (zipCode == null || !zipCode.matches("\\d{4}")) {
            throw new ZipCodeException("Posta kodu 4 haneli olmalıdır.");
        }
    }

    @Override
    public AddressDto getAddressById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));
        return AddressMapper.mapToAddressDto(address);
    }

    @Override
    public List<AddressDto> getAllAddresses() {
        List<Address> addresses = addressRepository.findAll();
        return addresses.stream()
                .map(AddressMapper::mapToAddressDto)
                .collect(Collectors.toList());
    }

    @Override
    public AddressDto updateAddress(Long id, AddressDto updateAddress) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Address not found with id: " + id));

        address.setCity(updateAddress.getCity());
        address.setStreet(updateAddress.getStreet());
        address.setZipCode(updateAddress.getZipCode());
        Employee employee = employeeRepository.findById(updateAddress.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + updateAddress.getEmployeeId()));
        address.setEmployee(employee);

        Address updatedAddress = addressRepository.save(address);
        return AddressMapper.mapToAddressDto(updatedAddress);
    }

    @Override
    public void deleteAddress(Long id) {
        addressRepository.deleteById(id);
    }
}
