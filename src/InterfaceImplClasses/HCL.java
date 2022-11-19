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
        Salary calcSalary = new Salary();
       // LeaveImpl leave = new LeaveImpl();
        Service service = new Service(calcSalary);
        double salary = empMap.get(id).getSalary().getSalary();
        double gross_sal = service.calSalary(salary);
        System.out.println("----------------------------------------------------");
        System.out.println("Employee total salary is "+salary);
        System.out.println("Employee gross salary is "+gross_sal);
        System.out.println("DA = "+calcSalary.getDa());
        System.out.println("HRA = "+calcSalary.getHra());
        System.out.println("PF = "+calcSalary.getPf());
        System.out.println("----------------------------------------------------");
    }

    @Override
    public void empDetails(int id) {
        Employee employee1 = empMap.get(id);
        System.out.println("----------------------------------------------------");
        System.out.println("Employee id : "+employee1.getEmpId());
        System.out.println("Employee name : "+employee1.getEmpName());
        System.out.println("Employee phone no : "+employee1.getEmpPhoneNo());
        System.out.println("Employee company name : "+employee1.getEmpCompanyName());
        System.out.println("----------------------------------------------------");
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
        System.out.println("----------------------------------------------------");
        System.out.println("Applying for leave ...");
        System.out.println("Enter no of days : ");
        int noOfDays = new Scanner(System.in).nextInt();
        boolean result = service.applyLeave(employee,noOfDays);
        System.out.println("----------------------------------------------------");
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
