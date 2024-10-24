package net.javaguides.java_ems.controller;

import lombok.AllArgsConstructor;
import net.javaguides.java_ems.dto.EmployeeDto;
import net.javaguides.java_ems.service.EmployeeService;
import net.javaguides.java_ems.service.LanguageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")

public class EmployeeController {

    private final EmployeeService employeeService;

    private final LanguageService languageService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@ModelAttribute EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    @GetMapping("/employees/search")
    public ResponseEntity<List<EmployeeDto>> searchEmployeesByWork(@RequestParam String work){
      List<EmployeeDto> employees =  employeeService.searchEmployeesByWork(work);
      return ResponseEntity.ok(employees);
    }
    @GetMapping("/search-by-lastname")
    public List<EmployeeDto> searchEmployeesByLastName(@RequestParam String lastName) {
        return employeeService.searchEmployeesByLastName(lastName);
    }
    @GetMapping("/search-by-work")
    public List<EmployeeDto> searchByWork(@RequestParam String work) {
        return employeeService.searchEmployeesByWork(work);
    }
    @GetMapping("/search-by-last-name")
    public List<EmployeeDto> searchByLastName(@RequestParam String lastName){
        return employeeService.searchEmployeesByLastName(lastName);
    }
    @GetMapping("/search-by-country")
    public List<EmployeeDto> searchByCountry(@RequestParam String country) {
        return employeeService.searchEmployeesByCountry(country);
    }
    @GetMapping("/search-by-salary")
    public List<EmployeeDto> searchBySalary(@RequestParam double minSalary,double maxSalary){
        return employeeService.searchEmployeesBySalary(minSalary,maxSalary);
    }
    @GetMapping("/search-by-first-name")
    public List<EmployeeDto> searchByFirstName(@RequestParam String firstName){
        return employeeService.searchEmployeesByFirstName(firstName);
    }
    @GetMapping("/search-by-email")
    public  List<EmployeeDto> searchByEmail(@RequestParam String email){
        return employeeService.searchEmployeesByEmail(email);
    }
    @GetMapping("/search-by-phone-number")
    public List<EmployeeDto> searchByPhoneNumber(@RequestParam String phoneNumber){
        return employeeService.searchEmployeesByPhoneNumber(phoneNumber);
    }
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId,
                                                      @RequestParam EmployeeDto updateEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }
    @PutMapping("/employees/{id}/password")
    public ResponseEntity<String> updateEmployeePassword(@PathVariable Long id,
                                                         @RequestParam Map<String , String> request){
        String newPassword = request.get("password");
        employeeService.updateEmployeePassword(id,newPassword);
        return ResponseEntity.ok("Password updated successfully!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted succesfully.!");
    }

}














