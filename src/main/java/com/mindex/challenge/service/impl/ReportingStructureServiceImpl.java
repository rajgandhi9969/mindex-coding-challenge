package com.mindex.challenge.service.impl;

import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import com.mindex.challenge.service.ReportingStructureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportingStructureServiceImpl implements ReportingStructureService {

    private static final Logger LOG = LoggerFactory.getLogger(ReportingStructureServiceImpl.class);

    @Autowired
    EmployeeService employeeService;

    @Override
    public ReportingStructure getReportingStructure(String id) {
        LOG.debug("get reporting structure for employee id [{}]", id);
        Employee employee = employeeService.read(id);
        return new ReportingStructure(employee,getNumberOfReports(employee));
    }


    private int getNumberOfReports(Employee employee){
        int reportCount = 0;
        List<Employee> reportList = employee.getDirectReports();
        if(reportList!= null && reportList.size() != 0){
            for(Employee emp:reportList){
                Employee employeeDetails = employeeService.read(emp.getEmployeeId());
                emp.setDepartment(employeeDetails.getDepartment());
                emp.setFirstName(employeeDetails.getFirstName());
                emp.setLastName(employeeDetails.getLastName());
                emp.setPosition(employeeDetails.getPosition());
                emp.setDirectReports(employeeDetails.getDirectReports());
                // recursive function to retrieve all the direct and indirect reports
                reportCount=reportCount+getNumberOfReports(employeeDetails)+1;
            }
        }
        return reportCount;
    }
}
