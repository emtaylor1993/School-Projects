/**
 * EMPLOYEE ENTITY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Employee entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    JavaX Persistence (Column, Entity, GeneratedValue, GenerationType, Id, Table)
 *    JavaX Validation Constraints (Digits, Email, NotBlank, NotNull, Pattern)
 *    Lombok (Getter, NoArgsConstructor, NonNull, RequiredArgsConstructor, Setter)
 */

package com.databases.dbmssolution.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employeeId;

    @NotBlank(message = "First name cannot be blank")
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotBlank(message = "Role cannot be blank")
    @NonNull
    @Column(name = "role", nullable = false)
    private String role;

    @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE, message = "Please enter a valid email")
    @NotBlank(message = "Email address cannot be blank")
    @NonNull
    @Column(name = "email_address", nullable = false)
    private String email;

    @NotNull(message = "Salary cannot be blank")
    @Digits(integer = 6, fraction = 0, message = "Salary must be a whole number")
    @Column(name = "salary", nullable = false)
    private Integer salary;

    @NotBlank(message = "Username cannot be blank")
    @NonNull
    @Column(name = "username", nullable = false)
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @NonNull
    @Column(name = "password", nullable = false)
    private String password;
}
