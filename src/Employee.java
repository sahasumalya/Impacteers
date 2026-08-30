public class Employee implements Comparable<Employee>{
    int age;
    String name;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
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
