package InterfaceImplClasses;

public class Employee {
    private int empId ;
    private String empName;
    private String empCompanyName;
    Leave leave;
    CalcSalary calcSalary;

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

    public CalcSalary getCalcSalary() {
        return calcSalary;
    }

    public void setCalcSalary(CalcSalary calcSalary) {
        this.calcSalary = calcSalary;
    }

    public Employee() {
    }

    public Employee(Recruitment recruitment) {
        this.empId=recruitment.getEmpId();
        this.empName=recruitment.getEmpName();
        calcSalary = new CalcSalary();
        this.calcSalary.setSalary(recruitment.getEmpSalary());
        leave = new Leave();
        this.leave.setTotalLeave(recruitment.getLeave_can_take());
        this.setEmpCompanyName(recruitment.getEmpCompanyName());
    }

    @Override
    public String toString() {
        return "Employee{empId=" + empId +
                ", empName='" + empName + "}";
    }
}
