package com.company.jmixpm.entity;

import io.jmix.core.metamodel.datatype.impl.EnumClass;

import javax.annotation.Nullable;


public enum Contractor implements EnumClass<String> {

    RESIDENT("resident"),
    NON_RESIDENT("non-resident");

    private String id;

    Contractor(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static Contractor fromId(String id) {
        for (Contractor at : Contractor.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}