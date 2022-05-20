package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "REQUEST_TO_ORGANISATION", indexes = {
        @Index(name = "IDX_REQUESTTOORGANISATION", columnList = "ORGANISATION_ID")
})
@Entity
public class RequestToOrganisation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "REQUEST_NUMBER", nullable = false, unique = true)
    @NotNull
    private Integer requestNumber;

    @JoinColumn(name = "ORGANISATION_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organisation organisation;

    @JoinTable(name = "REQUEST_TO_ORG_USER",
            joinColumns = @JoinColumn(name = "REQUEST_TO_ORGANISATION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<User> mailingList;

    @Column(name = "REQUEST_TEXT")
    @Lob
    private String requestText;

    public Organisation getOrganisation() {
        return organisation;
    }

    public void setOrganisation(Organisation organisation) {
        this.organisation = organisation;
    }

    public List<User> getMailingList() {
        return mailingList;
    }

    public void setMailingList(List<User> mailingList) {
        this.mailingList = mailingList;
    }

    public String getRequestText() {
        return requestText;
    }

    public void setRequestText(String requestText) {
        this.requestText = requestText;
    }

    public Integer getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(Integer requestNumber) {
        this.requestNumber = requestNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}