import CustomException.MyException;
import DataSet.DataBase;
import InterfaceImplClasses.HCL;
import InterfaceImplClasses.Recruitment;
import InterfaceImplClasses.Samsung;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main2 {
    static void giveException() throws MyException
    {
        throw new MyException("Invalid input..");
    }
    public static void main(String[] args)  {
        int empId, max_leave ;
        double empSalary;
        String empName, phoneNo, bankName, account_no, companyName, pan, pf_no;

        Scanner sc = new Scanner(System.in);
        List<Recruitment> recruitmentList = DataBase.getAllData();

        boolean loop = true;
        while (loop)
        {
            int no;
            System.out.println("----------------------------------------------------");
            System.out.println("Enter 1 to add new Employee. ");
            System.out.println("Enter 2 to access all employees. ");
            System.out.println("Enter 3 to exit. ");
            System.out.println("----------------------------------------------------");
            no = sc.nextInt();
            if (no == 1) {
                System.out.println("----------------------------------------------------");
                System.out.println("Enter employee id ");
                empId = sc.nextInt();
                final int id = empId;
                List<Recruitment> collect = recruitmentList.stream().filter(em -> em.getEmpId() == id).collect(Collectors.toList());
                if (!collect.isEmpty())
                {
                    System.out.println("employee id already exists");
                    recruitmentList.stream().forEach(s-> System.out.print(s.getEmpId()+", "));
                }
                else {
                    System.out.println("Enter employee name ");
                    empName = sc.next();
                    System.out.println("Enter employee salary ");
                    empSalary = sc.nextDouble();
                    System.out.println("Enter employee company name ");
                    companyName = sc.next();
                    System.out.println("Enter employee phoneNumber ");
                    phoneNo = sc.next();
                    System.out.println("Enter employee max_leave ");
                    max_leave = sc.nextInt();
                    Recruitment r = new Recruitment(empName,empId,companyName);
                    r.setEmpSalary(empSalary);
                    r.setEmpPhoneNo(phoneNo);
                    r.setLeave_can_take(max_leave);

                    // adding new recruitment data to the list
                    recruitmentList.add(r);
                    System.out.println("Successfully added 1 employee...");
                    System.out.println("----------------------------------------------------");
                }
            }
            else if (no == 2) {
                System.out.println("----------------------------------------------------");
                final int emp;
                System.out.println("Enter employee id :");
                emp = sc.nextInt();
                if (recruitmentList.stream().anyMatch(s -> s.getEmpId() == emp))
                {
                    List<Recruitment> collect = recruitmentList.stream().filter(em -> em.getEmpId() == emp).collect(Collectors.toList());
                    boolean hcl = collect.stream().anyMatch(s -> s.getEmpCompanyName().equalsIgnoreCase("HCL"));
                    boolean samsung = collect.stream().anyMatch(s -> s.getEmpCompanyName().equalsIgnoreCase("SAMSUNG"));
                    if (hcl)
                    {
                        Optional<Recruitment> first = collect.stream().findFirst();
                        boolean present = first.isPresent();
                        if (present) {
                            Recruitment recruitment = first.get();
                            HCL hcl1 = new HCL(recruitment);
                            boolean loop2 = true;
                            int ch1;
                            while (loop2)
                            {
                                System.out.println("----------------------------------------------------");
                                System.out.println("Enter 1 to view the employee details.");
                                System.out.println("Enter 2 to calculate salary.");
                                System.out.println("Enter 3 to to apply leave.");
                                System.out.println("Enter 4 to print pay slip.");
                                System.out.println("Enter 5 to calculate salary after leave.");
                                System.out.println("Enter 6 to know month wise salary.");
                                System.out.println("Enter 7 to go back.");
                                System.out.println("----------------------------------------------------");
                                ch1 = sc.nextInt();
                                switch (ch1)
                                {
                                    case 1:
                                        hcl1.empDetails(recruitment.getEmpId());
                                        break;
                                    case 2:
                                        hcl1.calculateSalary(recruitment.getEmpId());
                                        break;
                                    case 3:
                                        hcl1.applyLeave(emp);
                                        break;
                                    case 4:
                                        hcl1.printPaySlip(recruitment);
                                        break;
                                    case 5:
                                        hcl1.calcSalaryAfterLeave(emp);
                                        break;
                                    case 6:
                                        hcl1.getMonthWiseSalary(emp);
                                        break;
                                    case 7:
                                        System.out.println("Redirecting to previous options..");
                                        loop2 = false;
                                        break;
                                    default:{
                                        System.out.println("wrong input..");
                                        loop2 = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    else if (samsung) {
                        Optional<Recruitment> first = collect.stream().findFirst();
                        boolean present = first.isPresent();
                        if (present) {
                            Recruitment recruitment = first.get();
                            Samsung samsung1 = new Samsung(recruitment);
                            boolean loop2 = true;
                            int ch1;
                            while (loop2)
                            {
                                System.out.println("----------------------------------------------------");
                                System.out.println("Enter 1 to view the employee details.");
                                System.out.println("Enter 2 to calculate salary.");
                                System.out.println("Enter 3 to to apply leave.");
                                System.out.println("Enter 4 to print pay slip.");
                                System.out.println("Enter 5 to calculate salary after leave.");
                                System.out.println("Enter 6 to know month wise salary.");
                                System.out.println("Enter 7 to go back.");
                                System.out.println("----------------------------------------------------");
                                ch1 = sc.nextInt();
                                switch (ch1)
                                {
                                    case 1:
                                        samsung1.empDetails(recruitment.getEmpId());
                                        break;
                                    case 2:
                                        samsung1.calculateSalary(recruitment.getEmpId());
                                        break;
                                    case 3:
                                        samsung1.applyLeave(emp);
                                        break;
                                    case 4:
                                        samsung1.printPaySlip(recruitment);
                                        break;
                                    case 5:
                                        samsung1.calcSalaryAfterLeave(emp);
                                        break;
                                    case 6:
                                            samsung1.getMonthWiseSalary(emp);
                                            break;
                                    case 7:
                                        System.out.println("Redirecting to previous options..");
                                        loop2 = false;
                                        break;
                                    default:{
                                        System.out.println("wrong input..");
                                        loop2 = false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
                else {
                    System.out.println("Employee record not found.");
                    try {
                        giveException();
                    } catch (MyException e) {
                        System.out.println("Redirecting to the main menu..");
                    }
                }
            }
            else if (no==3) {
                System.out.println("ThankYou for using the application..");
                System.out.println("Exiting.....");
                break;
            }
            else {
                System.out.println("Entered wrong input.");
                try {
                    giveException();
                } catch (MyException e) {
                    System.out.println("Redirecting to the main menu..");
                }
            }
        }

    }
}
