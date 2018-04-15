/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

/**
 *
 * @author Owner
 */
public class Salary {
    private String emp_no;
    private String salary;
    private String from_date;
    private String to_date;
    
    public Salary(){}
    public Salary(String e, String s, String from, String to){
        setEmpNo(e);
        setSalary(s);
        setFromDate(from);
        setToDate(to);
    }
    
    public void setEmpNo(String e){emp_no = e;}
    public void setSalary(String s){salary = s;}
    public void setFromDate(String from){from_date = from;}
    public void setToDate(String to){to_date = to;}
    
    public String getEmpNo(){return emp_no;}
    public String getSalary(){return salary;}
    public String getFromDate(){return from_date;}
    public String getToDate(){return to_date;}
}
