package com.nucleus.controller.p6.model;

public class LoanApplication {
    private String applicantName;
    private String emailId;
    private String contactNumber;
    private String loanType;
    private int loanTenure;
    private String reasonForLoan;
    private SalaryDetails salaryDetails;


    public LoanApplication(String applicantName, String emailId, String contactNumber, String loanType, int loanTenure, String reasonForLoan, SalaryDetails salaryDetails) {
        this.applicantName = applicantName;
        this.emailId = emailId;
        this.contactNumber = contactNumber;
        this.loanType = loanType;
        this.loanTenure = loanTenure;
        this.reasonForLoan = reasonForLoan;
        this.salaryDetails = salaryDetails;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public String getReasonForLoan() {
        return reasonForLoan;
    }

    public void setReasonForLoan(String reasonForLoan) {
        this.reasonForLoan = reasonForLoan;
    }

    public SalaryDetails getSalaryDetails() {
        return salaryDetails;
    }

    public void setSalaryDetails(SalaryDetails salaryDetails) {
        this.salaryDetails = salaryDetails;
    }


    //gfenerate a 16digit loanapplicayion number
    public String generateLoanApplicationNumber() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            stringBuilder.append((int) (Math.random() * 10));
        }
        System.out.println("Loan Application Number: " + stringBuilder.toString());
        return stringBuilder.toString();
    }
}
