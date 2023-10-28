package com.one.one.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "policy")
@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id", nullable = false)
    private Integer policyId;

    @Column(name = "policy_no")
    @Length(max = 45)
    private String policyNo;

    @Column(name = "status_idstatus")
    private Integer idStatus;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "created_by")
    @Length(max = 45)
    private String createdBy;

    @Column(name = "vendor_idvendor")
    private Integer venderId;

    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "customer_idcustomer")
    private Integer idCustomer;

    @Column(name = "is_draft_schedule")
    private Boolean isDraftSchedule;

    @Column(name = "uw_comments")
    private String uwComments;

    @Column(name = "has_credit_facility")
    private Boolean hasCreditFacility;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "credit_facility_idcredit_facility")
//    private CreditFacility creditFacility;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "authrized_method_idauthorized_method", referencedColumnName = "idauthorized_method")
//    private AuthorizedMethod authorizedMethod;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "policy_period_idpolicy_period")
//    private PolicyPeriod policyPeriod;

    @Column(name = "policy_agent_idagent_info")
    private Integer policyAgentId;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "payment_method_idpayment_method")
//    private PaymentMethod paymentMethod;

    @Column(name = "mapped_to_idpolicy")
    private Integer mappedToIdPolicy;

    @Column(name = "active")
    private Boolean active;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "policy_acs_domain_codes_idpolicy_acs_domain_codes", referencedColumnName = "idpolicy_acs_domain_codes")
//    private PolicyAcsDomainCodes policyAcsDomainCodes;

    @Column(name = "cover_plan_idcover_plan")
    private Integer coverPlanId;

    @Column(name = "is_cover_plan_customized")
    private Boolean isCoverPlanCustomized;

    @Column(name = "product_idproduct")
    private Integer productId;

    @Column(name = "tax_idtax")
    private Integer taxId;

    @Column(name = "quotation_idquotation")
    private Integer quotationId;

    @Column(name = "quotation_no")
    private String quotationNo;

    @Column(name = "currency_idcurrency")
    private Integer currencyId;

    @Column(name = "authorized_by")
    @Length(max = 45)
    private String authorizedBy;

    @Column(name = "authorized_date")
    private LocalDateTime authorizedDate;

    @Column(name = "modified_by")
    @Length(max = 45)
    private String modifiedBy;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @Column(name = "idbranch")
    private Integer idBranch;

    @Column(name = "amendment_fee_text")
    private String amendmentFeeText;

    @Column(name = "amendment_commence_date")
    private Timestamp amendmentCommenceDate;

    @Column(name = "mapped_idlocation_information")
    private Integer mappedLocationInformationId;

    @Column(name = "s_code")
    @Length(max = 45)
    private String sCode;

    @Column(name = "l_code")
    @Length(max = 45)
    private String lCode;

    @Column(name = "mapped_idcommunication_information")
    private Integer mappedCommunicationInformationId;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependent> dependents;

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<PolicyHasCover> policyCoverList;

}
