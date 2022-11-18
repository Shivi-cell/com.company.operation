package InterfaceImplClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Samsung extends Operations{
    private Employee employee;
    private Map<Integer,Employee> empMap = new HashMap<>();
    public Samsung(Recruitment recruitment) {
        this.employee = new Employee(recruitment);
        empMap.put(recruitment.getEmpId(),employee);
       // System.out.println(empMap.get("Ravi"));
    }

    @Override
    public void calculateSalary(int id) {
        Employee employee1 = empMap.get(id);
        System.out.println(employee1);
        Salary calcSalary = new Salary();
        Service service = new Service(calcSalary);
        double salary = empMap.get(id).getSalary().getSalary();
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
        System.out.println("Applying for leave ...");
        System.out.println("Enter no of days : ");
        int noOfDays = new Scanner(System.in).nextInt();
        boolean result = service.applyLeave(employee,noOfDays);
        return result;
    }

    @Override
    public void getMonthWiseSalary(int id) {
        Employee employee = empMap.get(id);
        HashMap<String, Double> salaryMap = employee.getSalaryMap();
        System.out.println("--------------Month wise salary--------------");
        salaryMap.entrySet().stream().forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    @Override
    public void calcSalaryAfterLeave(int id) {
        Employee employee = empMap.get(id);
        Leave leave = employee.getLeave();
        Salary salaryObj = employee.getSalary();
        Service service = new Service(salaryObj,leave);
        int deducted = service.salaryAfterLeave();
        double salary = empMap.get(id).getSalary().getSalary();
        double gross = service.calSalary(salary);
        double pf = empMap.get(id).getSalary().getPf();
        System.out.println("----------------------------------------------------");
        System.out.println("salary after leave is "+(gross-deducted-pf));
        System.out.println("----------------------------------------------------");
    }
}
