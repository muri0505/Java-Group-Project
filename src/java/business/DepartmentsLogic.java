package business;

import dataaccess.DepartmentDAOImpl;
import java.util.List;
import transferobjects.Department;
import dataaccess.DepartmentDAO;

/**
 *
 * @course Shahriar Emami
 * @author Can Shi
 */
public class DepartmentsLogic {

    private static final int DEPARTMENT_NO_MAX_LENGTH = 45;
    private static final int DEPARTMENT_NAME_MAX_LENGTH = 45;

    private DepartmentDAO departmentDAO = null;

    public DepartmentsLogic() {
        departmentDAO = new DepartmentDAOImpl();
    }

    public List<Department> getAllDepartments() {
        return departmentDAO.getAllDepartments();
    }

    public void addDepartment(Department department) {
        cleanDepartment(department);
        validateDepartment(department);
        departmentDAO.addDepartment(department);
    }
    
    public Department getDepartmentByDepartmentNo(String DepartmentNo){
        return departmentDAO.getDepartmentByDepartmentNo(DepartmentNo);
    }

    private void cleanDepartment(Department department) {
        if (department.getDeptNo() != null) {
            department.setDeptNo(department.getDeptNo().trim());
        }

        if (department.getDeptName() != null) {
            department.setDeptName(department.getDeptName().trim());
        }

    }

    private void validateDepartment(Department department) {
        validateString(department.getDeptNo(), "Department Number", DEPARTMENT_NO_MAX_LENGTH, false);
        validateString(department.getDeptName(), "Department Name", DEPARTMENT_NAME_MAX_LENGTH, false);
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
