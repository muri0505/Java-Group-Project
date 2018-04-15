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
public class DeptManager {
    private String emp_no;
    private String dept_no;
    private String from_date;
    private String to_date;
    
    public DeptManager(){}
    public DeptManager(String e, String d, String from, String to){
        setEmpNo(e);
        setDeptNo(d);
        setFromDate(from);
        setToDate(to);
    }
    
    public void setEmpNo(String e){emp_no = e;}
    public void setDeptNo(String d){dept_no = d;}
    public void setFromDate(String from){from_date = from;}
    public void setToDate(String to){to_date = to;}
    
    public String getEmpNo(){return emp_no;}
    public String getDeptNo(){return dept_no;}
    public String getFromDate(){return from_date;}
    public String getToDate(){return to_date;}
}