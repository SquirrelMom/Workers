public class Employee implements Comparable{

    String name;
    String surname;
    EmployeeCondition employee_condition;
    int year_of_birth;
    double salary;

    public Employee(String n, String srn, EmployeeCondition emplc, int dob, double slry){
        this.name = n;
        this.surname = srn;
        this.year_of_birth = dob;
        this.employee_condition = emplc;
        this.salary = slry;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public EmployeeCondition getEmployee_condition() {
        return employee_condition;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " " + surname +" (" + employee_condition +")" + " " + salary + "zl, " ;
    }

    @Override
    public int compareTo(Employee o) {
        int surnameComparison = surname.compareTo(o.surname);

        if(surnameComparison == 0) {
            return name.compareTo(o.name);
        }
        else {
            return surnameComparison;
        }
    }

    public void printing(){
        System.out.println("FULL EMPLOYEE INFO:");
        System.out.println("Name: " + name);
        System.out.println("Surname " + surname);
        System.out.println("Employee condition: " + employee_condition);
        System.out.println("Year of birth: " + year_of_birth);
        System.out.println("Salary: " + salary);

    }


}
