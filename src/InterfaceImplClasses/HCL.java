package InterfaceImplClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

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
        Service service = new Service(calcSalary);
        Optional<Double> first = employee1.getSalaryMap().values().stream().map(salary1 -> salary1.getSalary()).findFirst();
        Double aDouble = first.get();
        double gross_sal = service.calSalary(aDouble);
        System.out.println("----------------------------------------------------");
        System.out.println("Employee total salary is "+aDouble);
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
        HashMap<String, Salary> salaryMap = employee.getSalaryMap();
        System.out.println("--------------Month wise salary--------------");
        Map<String, Double> collect = salaryMap.entrySet().stream()
                .collect(Collectors.toMap(s -> s.getKey(), sal -> sal.getValue().getSalary()));
        collect.entrySet().stream().forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    @Override
    public void calcSalaryAfterLeave(int id) {
        Employee employee = empMap.get(id);
        Leave leave = employee.getLeave();
        Optional<Salary> first = employee.getSalaryMap().values().stream().findFirst();
        Salary salaryObj = first.get();
        Service service = new Service(salaryObj,leave);
        int deducted = service.salaryAfterLeave();
        Optional<Double> firstSalary = employee.getSalaryMap().values().stream().map(salary1 -> salary1.getSalary()).findFirst();
        Double salary = firstSalary.get();
        double gross = service.calSalary(salary);
        Optional<Double> first1 = employee.getSalaryMap().values().stream().map(salary1 -> salary1.getPf()).findFirst();
        Double pf = first1.get();
        System.out.println("----------------------------------------------------");
        System.out.println("salary after leave is "+(gross-deducted));
        System.out.println("----------------------------------------------------");
    }
}
