package com.company.jmixpm.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum OrganisationType implements EnumClass<String> {

    SALESMAN("salesman"),
    BUYER("buyer"),
    MANUFACTURER("manufacturer");

    private final String id;

    OrganisationType(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static OrganisationType fromId(String id) {
        for (OrganisationType at : OrganisationType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}