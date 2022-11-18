package Interfaces;

import InterfaceImplClasses.Employee;

public interface CalcSalary {
    double calSalary(double salary);
    int salaryAfterLeave();
    void salaryByMonth();
    void printPaySlip();
}
