package com.nucleus.controller.p6.model;

public class SalaryDetails {
    private String organizationName;
    private String designation;
    private double monthlySalary;


    public SalaryDetails(String organizationName, String designation, double monthlySalary) {
        this.organizationName = organizationName;
        this.designation = designation;
        this.monthlySalary = monthlySalary;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }
}
