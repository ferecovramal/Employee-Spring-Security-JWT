package net.javaguides.java_ems.service.impl;

import lombok.RequiredArgsConstructor;
import net.javaguides.java_ems.dto.EmployeeDto;
import net.javaguides.java_ems.entity.Employee;
import net.javaguides.java_ems.exception.*;
import net.javaguides.java_ems.mapper.EmployeeMapper;
import net.javaguides.java_ems.repository.EmployeeRepository;
import net.javaguides.java_ems.service.EmployeeService;
import net.javaguides.java_ems.service.LanguageService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final LanguageService languageService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        if (employeeDto.getSalary() < 750) {
            throw new SalaryException("750 den kicik ola bilmez");
        }
        if (employeeDto.getWork() == null || employeeDto.getWork().isEmpty()) {
            throw new WorkException("Is yeri bos ola bilmez");
        }
        if (employeeDto.getCountry() == null || employeeDto.getCountry().isEmpty()) {
            throw new WorkException("Olke yeri bos ola bilmez");
        }
        if ( employeeDto.getEmail().contains("!") || employeeDto.getEmail().contains("#")) {
            throw new EmailException("E-poçt ünvanında xüsusi simvollar ola bilməz");
        }
        if (employeeDto.getLastName().length() < 3) {
            throw new LastnameException("3 herfden az ola bilmez");
        }
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        if (employeeDto.getPassword() != null && !employeeDto.getPassword().isEmpty()) {
            employee.setPassword(passwordEncoder.encode(employeeDto.getPassword()));
        } else {
            throw new PasswordException("8 simvoldan az ola bilmez");
        }

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

   @Override
   public List<EmployeeDto> searchEmployeesByPhoneNumber(String phoneNumber) {
       List<Employee> employees = employeeRepository.findByPhoneNumberContainingIgnoreCase(phoneNumber);
       if (employees == null || employees.isEmpty()) {
           throw new ResourceNotFoundException("No employees found with phone number: " + phoneNumber);
       }
       return employees.stream()
               .map(EmployeeMapper::mapToEmployeeDto)
               .collect(Collectors.toList());
   }

    @Override
    public List<EmployeeDto> searchEmployeesByWork(String work) {
        List<Employee> employees = employeeRepository.findByWorkContainingIgnoreCase(work);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with work containing: " + work);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> searchEmployeesByLastName(String lastName){
        List<Employee> employees = employeeRepository.findByLastNameContainingIgnoreCase(lastName);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with lastName containing:" + lastName);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> searchEmployeesByCountry(String country){
        List<Employee> employees = employeeRepository.findByCountryContainingIgnoreCase(country);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with country containing:" + country);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> searchEmployeesBySalary(double minSalary , double maxSalary){
        List<Employee> employees = employeeRepository.findBySalaryBetween(minSalary, maxSalary);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with salary between:" + minSalary + " and " + maxSalary);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> searchEmployeesByFirstName(String firstName){
        List<Employee> employees = employeeRepository.findByFirstNameContainingIgnoreCase(firstName);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with firstName containing:" + firstName);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> searchEmployeesByEmail(String email){
        List<Employee> employees = employeeRepository.findByEmailContainingIgnoreCase(email);
        if (employees == null || employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found with email containing:" + email);
        }
        return employees.stream()
                .map(EmployeeMapper::mapToEmployeeDto)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id:" + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees= employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long EmployeeId, EmployeeDto updateEmployee) {
        Employee employee = employeeRepository.findById(EmployeeId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Employee is not exists with given id:" + EmployeeId)
                );
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        employee.setCountry(updateEmployee.getCountry());
        employee.setSalary(updateEmployee.getSalary());
        employee.setWork(updateEmployee.getWork());
        employee.setPhoneNumber(updateEmployee.getPhoneNumber());

        Employee updateEmployeeObj = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id:" + employeeId)
        );
        employeeRepository.deleteById(employeeId);
    }


    public void updateEmployeePassword(Long id, String newPassword) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));

        if (newPassword != null && !newPassword.isEmpty()) {
            employee.setPassword(passwordEncoder.encode(newPassword));
        } else {
            throw new PasswordException("Password cannot be empty");
        }

        employeeRepository.save(employee);
    }

}
