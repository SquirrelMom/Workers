import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;

public class ClassEmployee {

    String name_of_employee_group;
    List<Employee> employeeList = new ArrayList<Employee>();
    int max_employees; //max number of employees

    public ClassEmployee(String name_of_emplg, int max_empls) {
        this.name_of_employee_group = name_of_emplg;
        this.employeeList = employeeList;
        this.max_employees = max_empls;
    }

    public String getName_of_employee_group() {
        return name_of_employee_group;
    }

    public void addEmployee(Employee employee){
        boolean existing = exist(employee, employeeList);
        if (existing == true){
            System.out.print("This employee is already in the database!");
        } else {
            if( employeeList.size() < max_employees){
                employeeList.add(employee);
            } else {
                System.out.print("The MAX of employees in the database!");
            }
        }
    }

    public double addSalary(Employee employee, double salary){
        employee.salary += salary;
        return salary;
    }

    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
    }

    public void changeCondition(Employee employee, EmployeeCondition condition){
        employee.employee_condition = condition;
    }

    public Employee search(String keyWord){
        for (Employee emp: employeeList) {
            if(emp.getSurname().equals(keyWord)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> searchPartial(String keyWord){
        List <Employee> foundEmployees = new ArrayList<Employee>();
        for (Employee emp: employeeList){
            if(emp.getSurname().contains(keyWord) || emp.getName().contains(keyWord)){
                foundEmployees.add(emp);
            }
        }
        return foundEmployees;
    }

    public int countByCondition(EmployeeCondition condition){
    int sum = 0;
        for (Employee emp: employeeList) {
            if(emp.getEmployee_condition().equals(condition)){
                sum++;
            }
        }
        return sum;
    }

    public void summary(){
        for (Employee empl: employeeList) {
            System.out.println(empl);
        }
    }

    public List<Employee> sortByName(){
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee empl1, Employee empl2) {
                return empl1.getName().compareTo(empl2.getName());
            }
        });
        return employeeList;
    }

    public List<Employee> sortBySalary(){
        employeeList.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee empl1, Employee empl2) {
                return Double.compare(empl1.getSalary(), empl2.getSalary());
            }
        });
        return employeeList;
    }

    public Employee max(){
        Employee maxSalary = Collections.max(employeeList, new Comparator<Employee>() {
            @Override
            public int compare(Employee empl1, Employee empl2) {
                return Double.compare(empl1.getSalary(), empl2.getSalary());
            }
        });
        return  maxSalary;
    }

    public boolean exist(Employee newEmployee, List<Employee> employeeList){
        boolean is = false;
        for (int i =0; i < employeeList.toArray().length; i++){
            Employee pom = employeeList.get(i);
            if (newEmployee.getName().equals(pom.getName()) && newEmployee.getSurname().equals(pom.getSurname())){
                is = true;
            } else {
                continue;
            }
        }
        return is;
    }

    public double groupPercentage () {
        return ((double) employeeList.size() / max_employees) * 100;
    }
    public boolean isEmptyEmployees (){
        return employeeList.isEmpty();
    }

    @Override
    public String toString() {
        return " max number of employees: " + max_employees;
    }

}
