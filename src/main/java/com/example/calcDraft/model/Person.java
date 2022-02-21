package com.example.calcDraft.model;

import com.example.calcDraft.helper.NationalCode;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSON_TBL",uniqueConstraints = {@UniqueConstraint(name = "nationalCodeUK",columnNames = "nationalCode")})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    @NationalCode
    private String nationalCode;
    private Integer age;
}
