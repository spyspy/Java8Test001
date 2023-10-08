package java8test;

import java.util.*;

public class Java8Test006Optional {
    public static void main(String[] args) throws Exception {
        //Optional<String> optional1 = Optional.of(null); // Throw NullpointException if Null
        Optional<String> optional1 = Optional.of("TestOptionalString"); // Throw NullpointException if Null
        //Optional<String> optional2 = Optional.ofNullable(null); // Do Nothing if Null
        Optional<String> optional3 = Optional.empty(); // Do Nothing if Null

        //OLD Way to detect null
        String test001 ="String Test001";
        if(null == test001){
            //Do Something
        }

        //Optional way to detect null
        //Not recommended way to do it
        if(optional1.isPresent()){
            System.out.println("01....:" + optional1.get());
        }else{
            throw new Exception("WOW");
        }

        //Recommended way to do it (Replace previous way)
        //ifPresent()
        optional1.ifPresent(item -> System.out.println("02....:" + item));

        //orElse();
        //if empty return String parameter. or Return original content.
        System.out.println("03(orElse):"+optional3.orElse("Empty???")); //return String
        System.out.println("03(orElse):"+optional1.orElse("Empty???"));
        System.out.println("03(orElse):"+optional3.orElseGet(()->"WOW")); //return String
        System.out.println("03(orElse):"+optional1.orElseGet(()->"WOW"));

        //=======================================================

        Employee employee1 = new Employee();
        employee1.setName("Superman");
        Employee employee2 = new Employee();
        employee2.setName("BatMan");

        Company company = new Company();
        company.setName("MyCompany");
        List<Employee> listEmployee = Arrays.asList(employee1,employee2);
        company.setEmployees(listEmployee);
        System.out.println("*******************");

        //Traditional way
        List<Employee> list = company.getEmployees();
        if(null != list){
            System.out.println("a");
            System.out.println(list);
        }else{
            System.out.println("b");
            System.out.println(new ArrayList<Employee>());
        }
        System.out.println("*******************");

        //new way with optional
        Optional<Company> optionalCompany = Optional.ofNullable(company);
        System.out.println(optionalCompany.map((myCom)->myCom.getEmployees()).orElse(Collections.emptyList()));
        //*******************
        System.out.println("*******************");
        //new way with optional
        Optional<Company> optionalCompany2 = Optional.ofNullable(null);
        System.out.println(optionalCompany2.map((myCom)->myCom.getEmployees()).orElse(Collections.emptyList()));

        //*******************
        System.out.println("*******************");
        Optional<String> optionalString = Optional.of("TestBobo");
        System.out.println(optionalString.map(s-> s.toUpperCase()));
        System.out.println(optionalString.map(s-> s.toUpperCase()).orElse("EmptyWOW"));
        System.out.println("*******************");
        Optional<String> optionalString2 = Optional.ofNullable(null);
        System.out.println(optionalString2.map(s-> s.toUpperCase()));
        System.out.println(optionalString2.map(s-> s.toUpperCase()).orElse("EmptyWOW"));
        System.out.println("*******************");





    }

}


class Company{
    private String name;
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}

class Employee{
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}