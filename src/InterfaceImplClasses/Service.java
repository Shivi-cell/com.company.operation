package InterfaceImplClasses;

public class Service implements Interfaces.CalcSalary, Interfaces.Leave {

    private CalcSalary calcSalary;
    private Leave leave;

    public Service(CalcSalary calcSalary) {
        this.calcSalary = calcSalary;
    }

    public Service(Leave leave) {
        this.leave = leave;
    }


    @Override
    public double calSalary(double salary) {
        double da, hra, pf, grossSalary;
        da = (salary*10)/100;
        hra = ((da+salary)*12)/100;
        pf = (salary*12)/100;
        grossSalary = (salary+(da+hra));
        calcSalary.setDa(da);
        calcSalary.setHra(hra);
        calcSalary.setPf(pf);
        calcSalary.setGrossSalary(grossSalary);
        return grossSalary;
    }

    @Override
    public double salaryAfterLeave() {
        double amountDeducted, grossSalary;
        amountDeducted= calcSalary.getSalary()-(leave.getLeaveApplied()*(calcSalary.getSalary()/30));
        grossSalary = calcSalary.getSalary()-amountDeducted;
        calcSalary.setGrossSalary(grossSalary);
        return grossSalary;
    }

    @Override
    public void salaryByMonth() {

    }

    @Override
    public void printPaySlip() {

    }

    @Override
    public boolean applyLeave(Employee employee,int noOfDays) {
        if (employee.getEmpCompanyName().equalsIgnoreCase("hcl"))
        {
            if (noOfDays <=3 && noOfDays>0)
            {
                if (leave.getLeaveApplied() != 10)
                {
                    leave.setRemainingLeave(leave.getRemainingLeave()-noOfDays);
                    leave.setLeaveApplied(leave.getLeaveApplied()+noOfDays);

                    System.out.println("Leave applied : "+leave.getLeaveApplied());
                    System.out.println("Remaining leaves: "+leave.getRemainingLeave());
                    System.out.println("Total leaves : "+employee.leave.getTotalLeave());
                    return true;
                }
                else
                {
                    System.out.println("Leaves can't be applied..");
                    System.out.println("Remaining leaves: "+leave.getRemainingLeave());
                    return false;
                }
            }
            else
            {
                System.out.println("Leaves can't be applied..");
                System.out.println("Limit to apply leave is 3");
                return false;
            }
        }
        else if (employee.getEmpCompanyName().equalsIgnoreCase("samsung")) {
            if (noOfDays <=5 && noOfDays>0)
            {
                if (leave.getLeaveApplied() != 15)
                {
                    leave.setRemainingLeave(leave.getRemainingLeave()-noOfDays);
                    leave.setLeaveApplied(leave.getLeaveApplied()+noOfDays);

                    System.out.println("Leave applied : "+leave.getLeaveApplied());
                    System.out.println("Remaining leaves: "+leave.getRemainingLeave());
                    System.out.println("Total leaves : "+employee.leave.getTotalLeave());
                    return true;
                }
                else
                {
                    System.out.println("Leaves can't be applied..");
                    System.out.println("Remaining leaves: "+leave.getRemainingLeave());
                    return false;
                }
            }
            else
            {
                System.out.println("Leaves can't be applied..");
                System.out.println("Limit to apply leave is 5");
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public void getLeaveDetails() {

    }
}
