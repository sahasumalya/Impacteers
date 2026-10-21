public class Employee implements Comparable<Employee>{
    int age;
    String name;
    int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }


    @Override
    public int compareTo(Employee employee2) {
        if(this.age == employee2.age){
            return this.name.compareTo(employee2.name);
        }

        if(this.age > employee2.age){
            return -1;
        }

        return 1;
    }
}
