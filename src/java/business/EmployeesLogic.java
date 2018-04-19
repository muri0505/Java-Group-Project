package business;

import dataaccess.EmployeeDAOImpl;
import java.util.List;
import transferobjects.Employee;
import dataaccess.EmployeeDAO;

/**
 *
 * @author Can Shi
 */
public class EmployeesLogic {

    private static final int EMPLOYEE_GENDER_MAX_LENGTH = 1;
    private static final int EMPLOYEE_FIRST_NAME_MAX_LENGTH = 14;
    private static final int EMPLOYEE_LAST_NAME_MAX_LENGTH = 16;
    private static final int EMPLOYEE_DATE_MAX_LENGTH = 10;

    private EmployeeDAO employeeDAO = null;

    public EmployeesLogic() {
        employeeDAO = new EmployeeDAOImpl();
    }

    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    /**
     * validates then call DAO method
     *
     * @param employee
     */
    public void addEmployee(Employee employee) {
        cleanEmployee(employee);
        validateEmployee(employee);
        employeeDAO.addEmployee(employee);
    }

    public Employee getEmployeeByEmployeeNo(Integer EmployeeNo) {
        return employeeDAO.getEmployeeByEmployeeNo(EmployeeNo);
    }

    private void cleanEmployee(Employee employee) {
        if (employee.getEmpNo() != null) {
            employee.setEmpNo(employee.getEmpNo().trim());
        }

        if (employee.getBirthDate() != null) {
            employee.setBirthDate(employee.getBirthDate().trim());
        }

        if (employee.getFirstName() != null) {
            employee.setFirstName(employee.getFirstName().trim());
        }

        if (employee.getLastName() != null) {
            employee.setLastName(employee.getLastName().trim());
        }

        if (employee.getGender() != null) {
            employee.setGender(employee.getGender().trim());
        }

        if (employee.getHireDate() != null) {
            employee.setHireDate(employee.getHireDate().trim());
        }
    }

    /**
     * validates for proper input
     *
     * @param employee
     */
    private void validateEmployee(Employee employee) {
        //validateString(employee.getEmpNo(), "Employee Number", EMPLOYEE_NO_MAX_LENGTH, false);
        validateString(employee.getBirthDate(), "Birth Date", EMPLOYEE_DATE_MAX_LENGTH, false);
        validateString(employee.getFirstName(), "First Name", EMPLOYEE_FIRST_NAME_MAX_LENGTH, false);
        validateString(employee.getLastName(), "Last Name", EMPLOYEE_LAST_NAME_MAX_LENGTH, false);
        validateString(employee.getGender(), "Gender", EMPLOYEE_GENDER_MAX_LENGTH, false);
        validateString(employee.getHireDate(), "Hire Date", EMPLOYEE_DATE_MAX_LENGTH, false);
    }

    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {
            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        } else if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
