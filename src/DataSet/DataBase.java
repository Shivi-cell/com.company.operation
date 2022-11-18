package DataSet;

import InterfaceImplClasses.Recruitment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class DataBase {
    public static List<Recruitment> getAllData()
    {
        Recruitment r1 = new Recruitment("Shivam",10,"HCL");
        Recruitment r2 = new Recruitment("Rahul",11,"HCL");
        Recruitment r3 = new Recruitment("Sumit",12,"HCL");
        Recruitment r4 = new Recruitment("Arvind",13,"HCL");
        Recruitment r5 = new Recruitment("Jitendra",14,"HCL");
        Recruitment r6 = new Recruitment("Satyam",15,"SAMSUNG");
        Recruitment r7 = new Recruitment("Anoop",16,"SAMSUNG");
        Recruitment r8 = new Recruitment("Anurag",17,"SAMSUNG");
        Recruitment r9 = new Recruitment("Ashutosh",18,"SAMSUNG");
        Recruitment r10 = new Recruitment("Vishal",19,"SAMSUNG");


        r1.setEmpPhoneNo("9965477574");
        r1.setEmpSalary(25000);
        r1.setLeave_can_take(10);
        r1.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Jan",r1.getEmpSalary());
            put("2022_Feb",r1.getEmpSalary());
            put("2022_Mar",r1.getEmpSalary());
        }});

        r2.setEmpPhoneNo("9965477574");
        r2.setEmpSalary(35000);
        r2.setLeave_can_take(10);
        r2.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Feb",r2.getEmpSalary());
            put("2022_Mar",r2.getEmpSalary());
        }});

        r3.setEmpPhoneNo("9965477574");
        r3.setEmpSalary(20000);
        r3.setLeave_can_take(10);
        r3.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Jan",r3.getEmpSalary());
            put("2022_Feb",r3.getEmpSalary());
            put("2022_Mar",r3.getEmpSalary());
        }});

        r4.setEmpPhoneNo("9965477574");
        r4.setEmpSalary(28000);
        r4.setLeave_can_take(10);
        r4.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Mar",r4.getEmpSalary());
            put("2022_Apr",r4.getEmpSalary());
            put("2022_May",r4.getEmpSalary());
        }});

        r5.setEmpPhoneNo("9965477574");
        r5.setEmpSalary(30000);
        r5.setLeave_can_take(10);
        r5.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Jun",r5.getEmpSalary());
            put("2022_Jul",r5.getEmpSalary());
            put("2022_Aug",r5.getEmpSalary());
        }});

        r6.setEmpPhoneNo("9965477574");
        r6.setEmpSalary(35000);
        r6.setLeave_can_take(15);
        r6.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Aug",r6.getEmpSalary());
            put("2022_Sep",r6.getEmpSalary());
            put("2022_Oct",r6.getEmpSalary());
        }});

        r7.setEmpPhoneNo("9965477574");
        r7.setEmpSalary(42000);
        r7.setLeave_can_take(15);
        r7.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Nov",r7.getEmpSalary());
            put("2022_Dec",r7.getEmpSalary());
        }});

        r8.setEmpPhoneNo("9965477574");
        r8.setEmpSalary(45000);
        r8.setLeave_can_take(15);
        r8.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Jan",r8.getEmpSalary());
            put("2022_Feb",r8.getEmpSalary());
            put("2022_Mar",r8.getEmpSalary());
            put("2022_Apr",r8.getEmpSalary());
        }});

        r9.setEmpPhoneNo("9965477574");
        r9.setEmpSalary(50000);
        r9.setLeave_can_take(15);
        r9.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_Feb",r9.getEmpSalary());
            put("2022_Mar",r9.getEmpSalary());
        }});

        r10.setEmpPhoneNo("9965477574");
        r10.setEmpSalary(55000);
        r10.setLeave_can_take(15);
        r10.setSalaryMap(new LinkedHashMap<>(){{
            put("2022_May",r10.getEmpSalary());
            put("2022_Jun",r10.getEmpSalary());
            put("2022_Jul",r10.getEmpSalary());
        }});

        List<Recruitment> recruitmentList = new ArrayList<>();
        recruitmentList.add(r1);recruitmentList.add(r2);recruitmentList.add(r3);recruitmentList.add(r4);recruitmentList.add(r5);
        recruitmentList.add(r6);recruitmentList.add(r7);recruitmentList.add(r8);recruitmentList.add(r9);recruitmentList.add(r10);
        return recruitmentList;
    }
}
