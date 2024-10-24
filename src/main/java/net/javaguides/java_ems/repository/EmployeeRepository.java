package net.javaguides.java_ems.repository;

import net.javaguides.java_ems.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByWork(String work);
    List<Employee> findByLastName(String lastName);
    List<Employee> findByCountry(String country);
    List<Employee> findBySalary(Double salary);
    List<Employee> findByFirstName(String firstName);
    List<Employee> findByPhoneNumber(String phoneNumber);
    List<Employee> findByWorkContainingIgnoreCase(String work);
    List<Employee> findByLastNameContainingIgnoreCase(String lastName);
    List<Employee> findByCountryContainingIgnoreCase(String country);
    List<Employee> findBySalaryBetween(double minSalary, double maxSalary);
    List<Employee> findByFirstNameContainingIgnoreCase(String firstName);
    List<Employee> findByEmailContainingIgnoreCase(String email);
    List<Employee> findByPhoneNumberContainingIgnoreCase(String phoneNumber);
    Optional<Employee> findByEmail(String email);



}
