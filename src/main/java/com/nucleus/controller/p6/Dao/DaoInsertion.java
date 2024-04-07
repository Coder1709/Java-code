package com.nucleus.controller.p6.Dao;

import com.nucleus.controller.p6.model.LoanApplication;
import com.nucleus.controller.p6.utils.ConUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoInsertion implements DaoImplementations {

    public boolean insertLoanApplication(LoanApplication loanApplication) {
        boolean flag = false;
        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            connection = ConUtils.getConnection();
            if (connection == null) {
                System.out.println("coonection is null");
            }
            String query = "INSERT INTO LoanApplications_17254_NEW (applicantName, emailId, contactNumber, loanType, loanTenure, reasonForLoan, organizationName, designation, monthlySalary) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, loanApplication.getApplicantName());
            preparedStatement.setString(2, loanApplication.getEmailId());
            preparedStatement.setString(3, loanApplication.getContactNumber());
            preparedStatement.setString(4, loanApplication.getLoanType());
            preparedStatement.setInt(5, loanApplication.getLoanTenure());
            preparedStatement.setString(6, loanApplication.getReasonForLoan());
            preparedStatement.setString(7, loanApplication.getSalaryDetails().getOrganizationName());
            preparedStatement.setString(8, loanApplication.getSalaryDetails().getDesignation());
            preparedStatement.setDouble(9, loanApplication.getSalaryDetails().getMonthlySalary());

            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in finally block
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }
}
