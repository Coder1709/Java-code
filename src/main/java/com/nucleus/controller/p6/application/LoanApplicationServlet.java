package com.nucleus.controller.p6.application;

import com.nucleus.controller.p6.Dao.DaoImplementations;
import com.nucleus.controller.p6.Dao.DaoInsertion;
import com.nucleus.controller.p6.model.LoanApplication;
import com.nucleus.controller.p6.model.SalaryDetails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/LoanApplicationServlet")
public class LoanApplicationServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Inside LoanApplicationServlet" + " - service method");

        // Retrieve parameters from the form
        String applicantName = request.getParameter("applicantName");
        String emailId = request.getParameter("emailId");
        String contactNumber = request.getParameter("contactNumber");
        String loanType = request.getParameter("loanType");
        int loanTenure = Integer.parseInt(request.getParameter("loanTenure"));
        String reasonForLoan = request.getParameter("reasonForLoan");
        String organizationName = request.getParameter("organizationName");
        String designation = request.getParameter("designation");
        double monthlySalary = Double.parseDouble(request.getParameter("monthlySalary"));


        //creating a SalaryDetails object
        SalaryDetails salaryDetails = new SalaryDetails(organizationName, designation, monthlySalary);

        //creating a LoanApplication object
        LoanApplication loanApplication = new LoanApplication(applicantName, emailId, contactNumber, loanType, loanTenure, reasonForLoan, salaryDetails);

        //generating a random 16 digit unique LoanApplication Number
        String loanApplicationNumber = loanApplication.generateLoanApplicationNumber();

        //inserting the loan application into the database
        DaoImplementations daoImplementations = new DaoInsertion();
        if(daoImplementations.insertLoanApplication(loanApplication)){

            if(daoImplementations.insertLoanApplication(loanApplication)){
                // Set the loan application number as a session attribute
                request.getSession().setAttribute("loanApplicationNumber", loanApplicationNumber);
                resp.sendRedirect("success.html");
            }
            else {
                resp.sendRedirect("error.html");
            }
        }
        else {
            resp.sendRedirect("error.html");
        }




    }
}
