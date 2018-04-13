package transferobjects;

import java.sql.Date;

/**
 * transfer object for Employee
 * 
 * @author Can Shi
 */
public class Department {
    private String dept_no;
    private String dept_name;
    
    public Department(){}
    
    public Department(String dept_no, String dept_name){
        this.dept_no = dept_no;
        this.dept_name = dept_name;
    }
    
    public void setDeptNo(String dept_no){
        this.dept_no = dept_no;
    }
    
    public void setDeptName( String dept_name){
        this.dept_name = dept_name;
    }
        
    public String getDeptNo(){
        return dept_no;
    }
    
    public String getDeptName(){
        return dept_name;
    }
    
    public static class Builder{
        private String dept_no;
        private String dept_name;
        
        public Builder(){}
        
        public Builder setDeptNo(String dept_no){
            this.dept_no = dept_no;
            return this;
        }
    
        public Builder setDeptName( String dept_name){
            this.dept_name = dept_name;
            return this;
        }
        
        public Department build(){
            return new Department(this.dept_no,this.dept_name);
        }
    }
}