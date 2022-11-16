import InterfaceImplClasses.Employee;
import InterfaceImplClasses.HCL;
import InterfaceImplClasses.Recruitment;
import InterfaceImplClasses.Samsung;

public class Main {
    public static void main(String[] args) {
        int empId = 101;
        String empName = "Ravi";
        double empSalary = 15000;
        String phoneNo = "5377155622";
        String bankName = "SBI";
        String account_no = "537715562622";
        String companyName = "samsung";
        int max_leave = 10;
        String pan = "1SGH2C";
        String pf_no = "25463";

        Recruitment recruitment = new Recruitment(empName, empId, bankName, empSalary, companyName, max_leave);
        recruitment.setPAN(pan);
        recruitment.setPF_NO(pf_no);
        recruitment.setAccountNo(account_no);
        if (companyName.equalsIgnoreCase("HCL"))
        {
           //Employee employee=new Employee(recruitment);
            HCL hcl = new HCL(recruitment);
            hcl.calculateSalary(recruitment.getEmpId());
            System.out.println(hcl.empDetails(recruitment.getEmpId()));
            System.out.println(hcl.about(recruitment));
            hcl.printPaySlip(recruitment);
            hcl.applyLeave(empId);
        }
        else if (companyName.equalsIgnoreCase("Samsung"))
        {
            //Employee employee=new Employee(recruitment);
            Samsung samsung = new Samsung(recruitment);
            samsung.calculateSalary(recruitment.getEmpId());
            System.out.println(samsung.empDetails(recruitment.getEmpId()));
            System.out.println(samsung.about(recruitment));
            samsung.applyLeave(empId);
        }
        else {
            System.out.println("Company name not valid..");
        }
    }
}