package com.usman.ems.entity;
import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "departments")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "department-name")
    private String departmentName;
    @Column(name = "department-description")
    private String departmentDescription;
}
