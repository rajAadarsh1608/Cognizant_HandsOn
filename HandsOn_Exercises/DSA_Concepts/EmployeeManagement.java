class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println(
            employeeId + " " +
            name + " " +
            position + " " +
            salary
        );
    }
}

public class EmployeeManagement {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    public static void addEmployee(Employee employee) {
        if (count < employees.length) {
            employees[count] = employee;
            count++;
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee array is full.");
        }
    }

    public static Employee searchEmployee(int employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                return employees[i];
            }
        }
        return null;
    }

    public static void traverseEmployees() {
        if (count == 0) {
            System.out.println("No employees found.");
            return;
        }

        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void deleteEmployee(int employeeId) {
        int index = -1;

        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == employeeId) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Employee not found.");
            return;
        }

        for (int i = index; i < count - 1; i++) {
            employees[i] = employees[i + 1];
        }

        employees[count - 1] = null;
        count--;

        System.out.println("Employee deleted successfully.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Rahul", "Developer", 50000));
        addEmployee(new Employee(102, "Amit", "Manager", 70000));
        addEmployee(new Employee(103, "Priya", "Designer", 45000));
        addEmployee(new Employee(104, "Neha", "Tester", 40000));

        System.out.println("\nAll Employees:");
        traverseEmployees();

        System.out.println("\nSearching Employee with ID 102:");
        Employee result = searchEmployee(102);

        if (result != null) {
            result.display();
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID 103:");
        deleteEmployee(103);

        System.out.println("\nEmployees After Deletion:");
        traverseEmployees();
    }
}
