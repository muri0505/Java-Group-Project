package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * transfer object for Employee
 *
 * @author Can Shi
 */
public class Department {

    private String dept_no;
    private String dept_name;

    public Department() {
    }

    /**
     * sets values
     *
     * @param dept_no
     * @param dept_name
     */
    public Department(String dept_no, String dept_name) {
        setDeptNo(dept_no);
        setDeptName(dept_name);
    }

    public void setDeptNo(String dept_no) {
        this.dept_no = dept_no;
    }

    public String getDeptNo() {
        return dept_no;
    }

    public void setDeptName(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getDeptName() {
        return dept_name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.dept_no);
        hash = 83 * hash + Objects.hashCode(this.dept_name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        if (!Objects.equals(this.dept_no, other.dept_no)) {
            return false;
        }
        if (!Objects.equals(this.dept_name, other.dept_name)) {
            return false;
        }
        return true;
    }

}
