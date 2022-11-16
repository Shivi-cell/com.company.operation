package InterfaceImplClasses;

public abstract class Operations {
    public abstract void calculateSalary(int empId);
    public abstract Employee empDetails(int empId);
    public abstract Recruitment about(Recruitment recruitment);

    public abstract boolean applyLeave(int id);
    public void printPaySlip(Recruitment recruitment)
    {
        CalcSalary calcSalary = new CalcSalary();
        Leave leave = new Leave();
        Service service = new Service(calcSalary);
        double salary = service.calSalary(recruitment.getEmpSalary());
        System.out.println("-------------------------------------------------------------");
        System.out.println("\t\t"+recruitment.getEmpCompanyName().toUpperCase());
        //System.out.println("\t\t"+employee.getEmpCompanyName().toUpperCase());
        System.out.println("-------------------------------------------------------------");
        System.out.print("Employee id : "+recruitment.getEmpId());
        System.out.println("\tEmployee Name : "+recruitment.getEmpName());
        System.out.print("Bank Name : "+recruitment.getEmpBankName());
        System.out.println("\t\tA/C No : "+recruitment.getAccountNo());
        System.out.print("PAN : "+recruitment.getPAN());
        System.out.println("\t\tPF No : "+recruitment.getPF_NO());
        System.out.println("-------------------------------------------------------------");
        System.out.print("Earnings");System.out.println("\t\t\tAmount");
        System.out.println("-------------------------------------------------------------");
        System.out.print("Basic Salary");System.out.println("\t\t"+recruitment.getEmpSalary());
        System.out.print("HRA ");System.out.println("\t\t\t\t"+calcSalary.getHra());
        System.out.print("DA ");System.out.println("\t\t\t\t\t"+calcSalary.getDa());
        System.out.print("Total ");System.out.println("\t\t\t\t"+salary);
        System.out.println("-------------------------------------------------------------");
        System.out.print("Deductions");System.out.println("\t\t\tAmount");
        System.out.println("-------------------------------------------------------------");
        System.out.print("PF ");System.out.println("\t\t\t\t\t"+calcSalary.getPf());
        System.out.println("-------------------------------------------------------------");
        System.out.print("Payable Amount ");System.out.println("\t\t"+(salary-calcSalary.getPf()));
        System.out.println("-------------------------------------------------------------");
    }
}
