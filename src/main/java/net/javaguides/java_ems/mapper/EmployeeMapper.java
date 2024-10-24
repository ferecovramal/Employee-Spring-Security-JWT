package net.javaguides.java_ems.mapper;

import net.javaguides.java_ems.dto.EmployeeDto;
import net.javaguides.java_ems.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getWork(),
                employee.getCountry(),
                employee.getSalary(),
                employee.getPhoneNumber(),
                employee.getPassword(),
                employee.getRefreshToken()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        employee.setWork(employeeDto.getWork());
        employee.setCountry(employeeDto.getCountry());
        employee.setSalary(employeeDto.getSalary());
        employee.setPhoneNumber(employeeDto.getPhoneNumber());
        employee.setPassword(employeeDto.getPassword());
        return employee;
    }
}
