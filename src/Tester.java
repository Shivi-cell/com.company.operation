import DataSet.DataBase;
import InterfaceImplClasses.Recruitment;

import java.util.List;
import java.util.stream.Collectors;

public class Tester {
    public static void main(String[] args) {
        List<Recruitment> recruitmentList = DataBase.getAllData();

        final int id = 200;
        List<Recruitment> collect = recruitmentList.stream().filter(em -> em.getEmpId() == id).collect(Collectors.toList());
        if (!collect.isEmpty())
        {
            System.out.println("employee already exists");
        }
        else {
            System.out.println("add new");
        }
    }
}
