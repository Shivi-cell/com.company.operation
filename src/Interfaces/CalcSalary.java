package Interfaces;

import InterfaceImplClasses.Employee;

public interface CalcSalary {
    double calSalary(double salary);
    double salaryAfterLeave();
    void salaryByMonth();
    void printPaySlip();
}
