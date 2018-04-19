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
public class Title {

    private String emp_no;
    private String title;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.emp_no);
        hash = 97 * hash + Objects.hashCode(this.title);
        hash = 97 * hash + Objects.hashCode(this.from_date);
        hash = 97 * hash + Objects.hashCode(this.to_date);
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
        final Title other = (Title) obj;
        if (!Objects.equals(this.emp_no, other.emp_no)) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
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
    private String from_date;
    private String to_date;

    public Title() {
    }
/**
 * sets values
 * @param e
 * @param t
 * @param from
 * @param to 
 */
    public Title(String e, String t, String from, String to) {
        setEmpNo(e);
        setTitle(t);
        setFromDate(from);
        setToDate(to);
    }

    public void setEmpNo(String e) {
        emp_no = e;
    }

    public void setTitle(String t) {
        title = t;
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

    public String getTitle() {
        return title;
    }

    public String getFromDate() {
        return from_date;
    }

    public String getToDate() {
        return to_date;
    }
}
