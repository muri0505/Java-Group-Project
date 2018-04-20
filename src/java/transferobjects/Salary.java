/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.util.Objects;

/**
 *
 * @author Owner
 */
public class Salary {

    private String emp_no;
    private String salary;
    private String from_date;
    private String to_date;

    public Salary() {
    }

    /**
     * sets values
     *
     * @param e
     * @param s
     * @param from
     * @param to
     */
    public Salary(String e, String s, String from, String to) {
        setEmpNo(e);
        setSalary(s);
        setFromDate(from);
        setToDate(to);
    }

    public void setEmpNo(String e) {
        emp_no = e;
    }

    public void setSalary(String s) {
        salary = s;
    }

    public void setFromDate(String from) {
        from_date = from;
    }

    public void setToDate(String to) {
        to_date = to;
    }

    public String getEmpNo() {
        return emp_no;
    }

    public String getSalary() {
        return salary;
    }

    public String getFromDate() {
        return from_date;
    }

    public String getToDate() {
        return to_date;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.emp_no);
        hash = 23 * hash + Objects.hashCode(this.salary);
        hash = 23 * hash + Objects.hashCode(this.from_date);
        hash = 23 * hash + Objects.hashCode(this.to_date);
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
        final Salary other = (Salary) obj;
        if (!Objects.equals(this.emp_no, other.emp_no)) {
            return false;
        }
        if (!Objects.equals(this.salary, other.salary)) {
            return false;
        }
        if (!Objects.equals(this.from_date, other.from_date)) {
            return false;
        }
        if (!Objects.equals(this.to_date, other.to_date)) {
            return false;
        }
        return true;
    }
}
