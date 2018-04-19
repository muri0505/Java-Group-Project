package transferobjects;

import java.sql.Date;
import java.util.Objects;

/**
 * transfer object for Employee
 *
 * @author Can Shi
 */
public class Employee {

    private String emp_no;
    private String birth_date;
    private String first_name;
    private String last_name;
    private String gender;
    private String hire_date;

    public Employee() {
    }

    /**
     * sets values
     *
     * @param emp_no
     * @param birth_date
     * @param first_name
     * @param last_name
     * @param gender
     * @param hire_date
     */
    public Employee(String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date) {
        setBirthDate(birth_date);
        setFirstName(first_name);
        setLastName(last_name);
        setGender(gender);
        setHireDate(hire_date);
        setEmpNo(emp_no);
    }

    public void setEmpNo(String emp_no) {
        this.emp_no = emp_no;
    }

    public String getEmpNo() {
        return emp_no;
    }

    public void setBirthDate(String birth_date) {
        this.birth_date = birth_date;
    }

    public String getBirthDate() {
        return birth_date;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getFirstName() {
        return first_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setHireDate(String hire_date) {
        this.hire_date = hire_date;
    }

    public String getHireDate() {
        return hire_date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.emp_no);
        hash = 89 * hash + Objects.hashCode(this.birth_date);
        hash = 89 * hash + Objects.hashCode(this.first_name);
        hash = 89 * hash + Objects.hashCode(this.last_name);
        hash = 89 * hash + Objects.hashCode(this.gender);
        hash = 89 * hash + Objects.hashCode(this.hire_date);
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
        final Employee other = (Employee) obj;
        if (!Objects.equals(this.emp_no, other.emp_no)) {
            return false;
        }
        if (!Objects.equals(this.birth_date, other.birth_date)) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.gender, other.gender)) {
            return false;
        }
        if (!Objects.equals(this.hire_date, other.hire_date)) {
            return false;
        }
        return true;
    }

}
