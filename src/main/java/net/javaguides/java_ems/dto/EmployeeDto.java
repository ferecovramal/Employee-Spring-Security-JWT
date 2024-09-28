package net.javaguides.java_ems.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.javaguides.java_ems.entity.Language;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String work;
    private String country;
    private Double salary;
    private String phoneNumber;
    private String password;
    private Long languageId;
}
