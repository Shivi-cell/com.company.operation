package Interfaces;

import InterfaceImplClasses.Employee;

public interface Leave {
    boolean applyLeave(Employee employee,int noOfDays);
    void getLeaveDetails();
    //boolean grantLeave();
}
