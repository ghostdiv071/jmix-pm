package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@JmixEntity
@Table(name = "ORGANISATION", indexes = {
        @Index(name = "IDX_ORGANISATION", columnList = "REQUEST_TO_ORGANISATION_ID")
})
@Entity
public class Organisation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull
    private String name;

    @Column(name = "SHORT_NAME", nullable = false)
    @NotNull
    private String shortName;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "PHONE_NUMBER", length = 50)
    private String phoneNumber;

    @Column(name = "CONTRACTOR")
    private String contractor;
    @JoinColumn(name = "REQUEST_TO_ORGANISATION_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RequestToOrganisation requestToOrganisation;

    public RequestToOrganisation getRequestToOrganisation() {
        return requestToOrganisation;
    }

    public void setRequestToOrganisation(RequestToOrganisation requestToOrganisation) {
        this.requestToOrganisation = requestToOrganisation;
    }

    public void setContractor(Contractor contractor) {
        this.contractor = contractor == null ? null : contractor.getId();
    }

    public Contractor getContractor() {
        return contractor == null ? null : Contractor.fromId(contractor);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}