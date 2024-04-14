import java.util.*;
public class ClassContainer {

    public Map<String, ClassEmployee> employeeMap ;

    public ClassContainer(){
        this.employeeMap = new HashMap<>();
    }

    public void addClass(String employeeGroup, int sizeofGroup){
        ClassEmployee emp = new ClassEmployee(employeeGroup, sizeofGroup);
        employeeMap.put(employeeGroup,emp);
    }

    public void addGroupToContainer (ClassEmployee employeeGroup) {
        employeeMap.put(employeeGroup.getName_of_employee_group(), employeeGroup);
    }

    public void removeClass (String groupDeleted){
        employeeMap.remove(groupDeleted);
    }

    public List<ClassEmployee> findEmpty(){
        List<ClassEmployee> emptyEmployeeGroup = new ArrayList<>();
        Collection<ClassEmployee> classEmployeesList = employeeMap.values();
        for (ClassEmployee eachGroup:classEmployeesList) {
            if(eachGroup.isEmptyEmployees()){
                emptyEmployeeGroup.add(eachGroup);
                System.out.print("Group " + eachGroup.getName_of_employee_group() + " is empty!");
            }
        }
        return emptyEmployeeGroup;
    }

    public void summaryPercentage() {
        Set<Map.Entry<String, ClassEmployee>> mapset =  employeeMap.entrySet();

        for (Map.Entry<String, ClassEmployee> eachGroup: mapset) {
            System.out.println(eachGroup.getKey() + " " + eachGroup.getValue().groupPercentage() + "%");
        }
    }

    public void summary(){
        Set<Map.Entry<String, ClassEmployee>> mapset =  employeeMap.entrySet();
        for (Map.Entry<String, ClassEmployee> eachGroup: mapset) {
            System.out.println(eachGroup.getKey() + " - " + eachGroup.getValue());
        }
    }

}

