/**
 * FINANCIAL DATA ENTITY CLASS
 * 
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 * 
 * @description
 *    This class represents the Financial Data entity and it's attributes
 *    to be represented in the DBMS.
 * 
 * @packages
 *    Java Time (LocalDate)
 *    JavaX Persistence (Column, Entity, GeneratedValue, GenerationType, Id, Table, JoinColumn, ManyToOne)
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
@Table(name = "financial_data")
public class FinancialData {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "financial_id")
    private Long financialId;

    @NotBlank(message = "Description cannot be blank")
    @NonNull
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull(message = "Date cannot be blank.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date", nullable = false)
    private LocalDate date;

    @NotBlank(message = "Category cannot be blank")
    @NonNull
    @Column(name = "category", nullable = false)
    private String category;

    @NotNull(message = "Amount cannot be blank")
    @Digits(integer = 6, fraction = 2, message = "Amount must have two decimal places")
    @Column(name = "amount", nullable = false)
    private Double amount;

    @ManyToOne(optional = false)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    private Employee employee;
}
