package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
    private  String compensationId;
    private Employee employee;
    private int salary;
    private Date effectiveDate;

    public String getCompensationId() {
        return compensationId;
    }

    public void setCompensationId(String compensationId) {
        this.compensationId = compensationId;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public int getSalary() {
        return salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }
}
