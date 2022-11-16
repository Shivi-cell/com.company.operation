package InterfaceImplClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HCL extends Operations{
    private Map<Integer,Employee> empMap = new HashMap<>();
    public HCL(Recruitment recruitment) {
        Employee employee = new Employee(recruitment);
        empMap.put(recruitment.getEmpId(),employee);
    }

    @Override
    public void calculateSalary(int id) {
        Employee employee1 = empMap.get(id);
        System.out.println(employee1);
        CalcSalary calcSalary = new CalcSalary();
       // LeaveImpl leave = new LeaveImpl();
        Service service = new Service(calcSalary);
        double salary = empMap.get(id).calcSalary.getSalary();
        double gross_sal = service.calSalary(salary);
        System.out.println("Employee total salary is "+salary);
        System.out.println("Employee gross salary is "+gross_sal);
        System.out.println("DA = "+calcSalary.getDa());
        System.out.println("HRA = "+calcSalary.getHra());
    }

    @Override
    public Employee empDetails(int id) {
        Employee employee1 = empMap.get(id);
        return employee1;
    }

    @Override
    public Recruitment about(Recruitment recruitment) {
        return recruitment;
    }

    @Override
    public boolean applyLeave(int id) {
        Employee employee = empMap.get(id);
        Leave leave = employee.getLeave();
        leave.setRemainingLeave(employee.getLeave().getTotalLeave());
        Service service = new Service(leave);
        System.out.println("Enter no of days : ");
        int noOfDays = new Scanner(System.in).nextInt();
        boolean result = service.applyLeave(employee,noOfDays);
        return result;
    }
}
