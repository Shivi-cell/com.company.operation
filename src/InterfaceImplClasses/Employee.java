package InterfaceImplClasses;
import java.util.HashMap;
import java.util.Objects;

public class Employee {
    private int empId;
    private String empName;
    private String empCompanyName;

    private HashMap<String,Double> salaryMap;
    private Leave leave;
    private Salary salary;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpCompanyName() {
        return empCompanyName;
    }

    public void setEmpCompanyName(String empCompanyName) {
        this.empCompanyName = empCompanyName;
    }

    public Leave getLeave() {
        return leave;
    }

    public void setLeave(Leave leave) {
        this.leave = leave;
    }

    public Salary getCalcSalary() {
        return salary;
    }

    public void setCalcSalary(Salary calcSalary) {
        this.salary = calcSalary;
    }

    public HashMap<String, Double> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(HashMap<String, Double> salaryMap) {
        this.salaryMap = salaryMap;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(Recruitment recruitment) {
        this.empId=recruitment.getEmpId();
        this.empName=recruitment.getEmpName();
        salary = new Salary();
        this.salary.setSalary(recruitment.getEmpSalary());
        leave = new Leave();
        this.leave.setTotalLeave(recruitment.getLeave_can_take());
        this.setEmpCompanyName(recruitment.getEmpCompanyName());
        /*this.setSalaryMap(new HashMap<>(){{
            Month month = LocalDate.now().getMonth();
            put("2022_Jan",salary.getSalary());
        }});*/
        this.setSalaryMap(recruitment.getSalaryMap());
    }

    @Override
    public String toString() {
        return "Employee{empId=" + empId +
                ", empName='" + empName + "}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId,empName);
    }

    @Override
    public boolean equals(Object obj) {
        return this.empId == ((Employee) obj).empId;
    }
}
