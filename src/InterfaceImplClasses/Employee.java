package InterfaceImplClasses;
import java.util.HashMap;
import java.util.Objects;

public class Employee {
    private int empId;
    private String empName;
    private String empCompanyName;
    private String empPhoneNo;
    private HashMap<String,Salary> salaryMap;
    private Leave leave;
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

    public HashMap<String, Salary> getSalaryMap() {
        return salaryMap;
    }

    public void setSalaryMap(HashMap<String, Salary> salaryMap) {
        this.salaryMap = salaryMap;
    }

    public String getEmpPhoneNo() {
        return empPhoneNo;
    }

    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }

    public Employee() {
    }

    public Employee(Recruitment recruitment) {
        this.empId=recruitment.getEmpId();
        this.empName=recruitment.getEmpName();
        leave = new Leave();
        this.leave.setTotalLeave(recruitment.getLeave_can_take());
        this.setEmpCompanyName(recruitment.getEmpCompanyName());
        this.setEmpPhoneNo(recruitment.getEmpPhoneNo());
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
