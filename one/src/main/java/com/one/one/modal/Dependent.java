package com.one.one.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "dependent")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Dependent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddependent", nullable = false)
    private Integer dependentId;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    @Length(max = 45)
    private String createdBy;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "dependent_type_id")
//    private DependentType dependentType;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idpolicy" , referencedColumnName = "idpolicy")
    private Policy policy;

    @Column(name = "idcustomer")
    private Integer idcustomer;

    @Column(name = "customer_pin")
    @Length(max = 45)
    private String customerPin;

}
