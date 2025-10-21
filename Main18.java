import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

class employee {
    int id;
    String name;
    double salary;

    LocalDate dob;
    int age;

    employee(int id, String name, double salary, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dob = dob;

    }

    public void setage(int age) {
        this.age = age;

    }

    public String to_string() {
        return id + " " + name + " " + dob + " " + age;

    }
}

public class Main18 {
    public static void main(String[] args) {
        List<employee> employees = new ArrayList<>();
        employees.add(new employee(101, "Alice", 75000, LocalDate.of(1990, 5, 24)));
        employees.add(new employee(102, "Bob", 68000, LocalDate.of(1985, 12, 30)));
        employees.add(new employee(103, "Charlie", 82000, LocalDate.of(1992, 3, 15)));
        List<Integer> ages = new ArrayList<>();
        for (employee emp : employees) {
            int age = Period.between(emp.dob, today).getYears();
            emp.setage(age);

        }
        System.out.println("after adding the ages");
        for (employee emp : employees) {
            String val = emp.to_string();
            System.out.println(val);

        }

    }

}
