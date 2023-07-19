package io.github.rique25.springbootcurso.utils;

import io.github.rique25.springbootcurso.enuns.FilterType;

import java.util.Date;
import java.util.logging.Filter;

public class FilterQueryImpl {

    private String field;
    private FilterType type;
    private String stringValue;
    private Long longValue;
    private Boolean booleanValue;
    private Date dateValue;

    public FilterQueryImpl(String field, FilterType type, String stringValue, Long longValue, Boolean booleanValue, Date dateValue) {
        this.field = field;
        this.type = type;
        this.stringValue = stringValue;
        this.longValue = longValue;
        this.booleanValue = booleanValue;
        this.dateValue = dateValue;
    }

    public FilterQueryImpl() {}

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FilterType getType() {
        return type;
    }

    public void setType(FilterType type) {
        this.type = type;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Long getLongValue() {
        return longValue;
    }

    public void setLongValue(Long longValue) {
        this.longValue = longValue;
    }

    public Boolean getBooleanValue() {
        return booleanValue;
    }

    public void setBooleanValue(Boolean booleanValue) {
        this.booleanValue = booleanValue;
    }

    public Date getDateValue() {
        return dateValue;
    }

    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
    }
}
