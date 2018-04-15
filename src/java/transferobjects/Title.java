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
public class Title {
    private String emp_no;
    private String title;
    private String from_date;
    private String to_date;
    
    public Title(){}
    public Title(String e, String t, String from, String to){
        setEmpNo(e);
        setTitle(t);
        setFromDate(from);
        setToDate(to);
    }
    
    public void setEmpNo(String e){emp_no = e;}
    public void setTitle(String t){title = t;}
    public void setFromDate(String from){from_date = from;}
    public void setToDate(String to){to_date = to;}
    
    public String getEmpNo(){return emp_no;}
    public String getTitle(){return title;}
    public String getFromDate(){return from_date;}
    public String getToDate(){return to_date;}
}
