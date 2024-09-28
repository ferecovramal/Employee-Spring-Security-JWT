package net.javaguides.java_ems.service;

import net.javaguides.java_ems.dto.EmployeeDto;
import net.javaguides.java_ems.entity.Employee;
import net.javaguides.java_ems.entity.Language;

import java.util.List;
import java.util.Set;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> searchEmployeesByWork(String work);
    List<EmployeeDto> searchEmployeesByLastName(String lastName);
    List<EmployeeDto> searchEmployeesByCountry(String country);
    List<EmployeeDto> searchEmployeesBySalary(double maxSalary, double minSalary);
    List<EmployeeDto> searchEmployeesByFirstName(String firstName);
    List<EmployeeDto> searchEmployeesByEmail(String email);
    List<EmployeeDto> searchEmployeesByPhoneNumber(String phoneNumber);
    EmployeeDto getEmployeeById(Long id);
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee(Long EmployeeId, EmployeeDto updateEmployee);
    void deleteEmployee(Long employeeId);
    void addLanguageToEmployee(Long employeeId, Long languageId);
    List<Employee> findEmployeesByLanguageId(Long languageId);
}
