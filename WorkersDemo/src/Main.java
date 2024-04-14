import java.util.List;

public class Main {
    public static void main(String[] args) {

        Employee employee1, employee2, employee3, employee4, employee5, employee6, employee7;
        employee1 = new Employee("John", "Snow", EmployeeCondition.ABSENT, 1444, 23000);
        employee2 = new Employee("Andrzej", "Borowik", EmployeeCondition.SICK, 1960, 7000);
        employee3 = new Employee("Slawek", "Slowianin", EmployeeCondition.DELEGATION, 1990, 10000);
        employee4 = new Employee("Asia", "Borowik", EmployeeCondition.PRESENT, 1996, 9000);
        employee5 = new Employee("Tomek", "Kotek", EmployeeCondition.PRESENT, 1993, 7000);
        employee6 = new Employee("Anna", "Jaglana", EmployeeCondition.PRESENT, 1981, 5000);
        employee7 = new Employee("Henryk", "Jagoda", EmployeeCondition.PRESENT, 1987, 6000);

        System.out.println("Employees' info:");
        employee1.printing();
        employee2.printing();
        employee3.printing();
        employee4.printing();
        employee5.printing();
        employee6.printing();
        employee7.printing();
        System.out.println();

        ClassEmployee klasa1;
        klasa1 = new ClassEmployee("Group1", 7);
        System.out.println("\nAdding employees: ");
        klasa1.addEmployee(employee1);
        klasa1.addEmployee(employee2);
        klasa1.addEmployee(employee3);
        klasa1.addEmployee(employee4);
        klasa1.addEmployee(employee5);
        klasa1.addEmployee(employee6);
        klasa1.addEmployee(employee7);

        klasa1.addEmployee(employee1);  //recurs
        Employee employee8;
        employee8 = new Employee("Not", "Wanted", EmployeeCondition.PRESENT, 1900, 0);
        klasa1.addEmployee(employee8);  //he's not gonna fit
        System.out.println();
        klasa1.summary();
        System.out.println();

        System.out.println("\nAdding 600 to Anna Jaglana's salary: ");
        klasa1.addSalary(employee6, 600);
        klasa1.summary();
        System.out.println();

        System.out.println("\nDeleting employee Henryk Jagoda:");
        klasa1.removeEmployee(employee7);
        klasa1.summary();
        System.out.println();

        System.out.println("\nChanging the condition of Asia Borowik:");
        klasa1.changeCondition(employee4, EmployeeCondition.SICK);
        klasa1.summary();
        System.out.println();

        System.out.println("\nSearching for the employee by the surname");
        System.out.println("\nFor the surname Kotek:");
        Employee employeeFound = klasa1.search("Kotek");
        System.out.println(employeeFound);
        System.out.println();

        System.out.println("\nSearching partly:");
        List<Employee> employeeList = klasa1.searchPartial("nin");
        System.out.println("List of employees: "+ employeeList);
        System.out.println();

        System.out.println("\nNumber of the employees that have the same condition - SICK:");
        int employeeCounter = klasa1.countByCondition(EmployeeCondition.SICK);
        System.out.println(employeeCounter);
        System.out.println();

        System.out.println("\nList of current employees:");
        klasa1.summary();
        System.out.println();

        System.out.println("\nSorting the employees by their names:");
        List<Employee> sortedEmployees = klasa1.sortByName();
        for (Employee sortSurn: sortedEmployees) {
            System.out.println(sortSurn);
        }
        System.out.println();

        System.out.println("\nSorting the employees by their salary:");
        List<Employee> sortedSalary = klasa1.sortBySalary();
        for (Employee sortSal: sortedSalary) {
            System.out.println(sortSal);
        }
        System.out.println();

        System.out.println("\nThe employee who earns the most:");
        Employee employeeMax = klasa1.max();
        System.out.println(employeeMax);
        System.out.println();

        ClassContainer container = new ClassContainer();
        System.out.println("\nAdding empty employee group:");
        container.addClass("Group2" , 20);
        container.addClass("Group3" , 10);
        container.summary();
        System.out.println();

        System.out.println("\nAdding the full group");
        container.addGroupToContainer(klasa1);
        container.summary();
        System.out.println();


        System.out.println("\nDeletion of the employee group");
        container.removeClass("Group2");
        container.summary();
        System.out.println();

        System.out.println("\nDisplaying the empty groups: ");
        List<ClassEmployee> foundEmpty = container.findEmpty();
        for (ClassEmployee printEmpty: foundEmpty) {
            System.out.println(printEmpty);
        }
        System.out.println();

        System.out.println("\nDisplaying the groups with group usage in %");
        container.summaryPercentage();
        System.out.println();

        System.out.println("\nDisplaying groups");
        container.summary();
        System.out.println();

    }
}