package InterfaceImplClasses;

public class Recruitment {
    private String empName;
    private int empId;
    private String empPhoneNo;
    private double empSalary;
    private String empCompanyName;
    private int leave_can_take;
    private String empBankName;

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getPAN() {
        return PAN;
    }

    public void setPAN(String PAN) {
        this.PAN = PAN;
    }

    public String getPF_NO() {
        return PF_NO;
    }

    public void setPF_NO(String PF_NO) {
        this.PF_NO = PF_NO;
    }

    private String accountNo;
    private String PAN;
    private String PF_NO;

    public String getEmpBankName() {
        return empBankName;
    }

    public void setEmpBankName(String empBankName) {
        this.empBankName = empBankName;
    }

    public Recruitment() {

    }

    public Recruitment(String empName, int empId, String bankName, double empSalary, String empCompanyName, int leave_can_take) {
        this.empName = empName;
        this.empId = empId;
        this.empBankName = bankName;
        this.empSalary = empSalary;
        this.empCompanyName = empCompanyName;
        this.leave_can_take = leave_can_take;
    }

    public int getLeave_can_take() {
        return leave_can_take;
    }

    public void setLeave_can_take(int leave_can_take) {
        this.leave_can_take = leave_can_take;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpPhoneNo() {
        return empPhoneNo;
    }

    public void setEmpPhoneNo(String empPhoneNo) {
        this.empPhoneNo = empPhoneNo;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }

    public String getEmpCompanyName() {
        return empCompanyName;
    }

    public void setEmpCompanyName(String empCompanyName) {
        this.empCompanyName = empCompanyName;
    }

    @Override
    public String toString() {
        return "Recruitment{" +
                "empName='" + empName + '\'' +
                ", empId=" + empId +
                ", empPhoneNo='" + empPhoneNo + '\'' +
                ", empSalary=" + empSalary +
                ", empCompanyName='" + empCompanyName + '\'' +
                ", leave_can_take=" + leave_can_take +
                '}';
    }
}
