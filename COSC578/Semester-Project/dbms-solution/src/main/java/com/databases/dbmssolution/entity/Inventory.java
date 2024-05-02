/**
 * INVENTORY ENTITY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Inventory entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Time (LocalDate)
 *    JavaX Persistence (Column, Entity, GeneratedValue, GenerationType, Id, JoinTable, ManyToOne, Table)
 *    JavaX Validation Constraints (Digits, NotBlank, NotNull)
 *    Spring Framework Format Annotation (DateTimeFormat)
 *    Lombok (Getter, NoArgsConstructor, NonNull, RequiredArgsConstructor, Setter)
 */


package com.databases.dbmssolution.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;
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
@Table(name = "inventory_log")
public class Inventory {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_number")
    private Long partNumber;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Date cannot be blank")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotBlank(message = "Job name cannot be blank")
    @NonNull
    @Column(name = "job_name", nullable = false)
    private String jobName;

    @NotNull(message = "Job ID cannot be blank")
    @Digits(integer = 6, fraction = 0, message = "Job ID must be an integer")
    @Column(name = "jobId", nullable = false)
    private Integer jobId;

    @NotBlank(message = "Part name cannot be blank")
    @NonNull
    @Column(name = "part_name", nullable = false)
    private String partName;

    @NotNull(message = "Quantity cannot be blank")
    @Digits(integer = 4, fraction = 0, message = "Quantity must be an integer")
    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @NotBlank(message = "Vendor cannot be blank")
    @NonNull
    @Column(name = "vendor", nullable = false)
    private String vendor;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
}
