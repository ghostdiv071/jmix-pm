package com.company.jmixpm.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "REQUEST_TO_ORGANISATION")
@Entity
public class RequestToOrganisation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @Column(name = "REQUEST_NUMBER", nullable = false, unique = true)
    @NotNull
    private Integer requestNumber;

    @OneToMany(mappedBy = "requestToOrganisation")
    private List<Organisation> organisation;

    @JoinTable(name = "REQUEST_TO_ORG_USER",
            joinColumns = @JoinColumn(name = "REQUEST_TO_ORGANISATION_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
    @ManyToMany
    private List<User> mailingList;

    @Column(name = "REQUEST_TEXT")
    @Lob
    private String requestText;

    public void setOrganisation(List<Organisation> organisation) {
        this.organisation = organisation;
    }

    public List<Organisation> getOrganisation() {
        return organisation;
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