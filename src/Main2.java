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
    public static void main(String[] args) throws MyException {
        int empId, max_leave ;
        double empSalary;
        String empName, phoneNo, bankName, account_no, companyName, pan, pf_no;

        Scanner sc = new Scanner(System.in);
        List<Recruitment> recruitmentList = DataBase.getAllData();

        boolean loop = true;
        while (loop)
        {
            int no;
            System.out.println("Enter 1 to add new Employee. ");
            System.out.println("Enter 2 to access all employees. ");
            System.out.println("Enter 3 to exit. ");
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
                            hcl1.calculateSalary(recruitment.getEmpId()); sc.nextLine();
                            System.out.println(hcl1.empDetails(recruitment.getEmpId())); sc.nextLine();
                            System.out.println(hcl1.about(recruitment)); sc.nextLine();
                            hcl1.printPaySlip(recruitment); sc.nextLine();
                            hcl1.applyLeave(emp);
                            hcl1.calcSalaryAfterLeave(emp);
                            hcl1.getMonthWiseSalary(emp);
                        }
                    }
                    else if (samsung) {
                        Optional<Recruitment> first = collect.stream().findFirst();
                        boolean present = first.isPresent();
                        if (present) {
                            Recruitment recruitment = first.get();
                            Samsung samsung1 = new Samsung(recruitment);
                            samsung1.calculateSalary(recruitment.getEmpId()); sc.nextLine();
                            System.out.println(samsung1.empDetails(recruitment.getEmpId())); sc.nextLine();
                            System.out.println(samsung1.about(recruitment)); sc.nextLine();
                            samsung1.printPaySlip(recruitment); sc.nextLine();
                            samsung1.applyLeave(emp);
                            samsung1.getMonthWiseSalary(emp);
                        }
                    }
                }
                else {
                    System.out.println("employee record not found");
                        giveException();
                }
            }
            else if (no==3) {
                System.out.println("ThankYou for using the application..");
                System.out.println("Exiting.....");
                break;
            }
            else {
                loop = false;
                System.out.println("Entered wrong input closing the application...");
                giveException();
                break;
            }
        }

    }
}
