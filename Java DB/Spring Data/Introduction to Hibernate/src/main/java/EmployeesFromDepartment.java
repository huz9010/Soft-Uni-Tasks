import entities.Employee;
public class EmployeesFromDepartment {
    public static void main(String[] args) {

        Setup.createEntityManager().createQuery("FROM Employee WHERE department.name =: depName ORDER BY salary, id", Employee.class)
                .setParameter("depName", "Research and Development")
                .getResultList().forEach(Employee::printEmployeeNameAndDep);
    }
}
