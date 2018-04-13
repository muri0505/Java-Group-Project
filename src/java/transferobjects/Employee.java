package transferobjects;

import java.sql.Date;

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
    
    public Employee(){}
    
    public Employee( String emp_no, String birth_date, String first_name, String last_name, String gender, String hire_date){
        setEmpNo(emp_no);
        setBirthDate(birth_date);
        setFirstName(first_name);
        setLastName(last_name);
        setGender(gender);
        setHireDate(hire_date);
    }
   
    public void setEmpNo(String emp_no){
        this.emp_no = emp_no;
    }
    
    public String getEmpNo(){
        return emp_no;
    }
    
    public void setBirthDate(String birth_date){
        this.birth_date = birth_date;
    }
    
    public String getBirthDate(){
        return birth_date;
    }
   
    public void setFirstName( String first_name){
        this.first_name = first_name;
    }
        
    public String getFirstName(){
        return first_name;
    }
    
    public void setLastName( String last_name){
        this.last_name = last_name;
    }
    
    public String getLastName(){
        return last_name;
    }
    
    public void setGender( String gender){
        this.gender = gender;
    }
    
    public String getGender(){
        return gender;
    }
    
    public void setHireDate(String hire_date){
        this.hire_date = hire_date;
    }
    
    public String getHireDate(){
        return hire_date;
    }
    
    public static class Builder{
        private String emp_no;
        private String birth_date;
        private String first_name;
        private String last_name;
        private String gender;
        private String hire_date;
        
        public Builder(){}
        
        public Builder setEmpNo(String emp_no){
            this.emp_no = emp_no;
            return this;
        }
        
        public Builder setBirthDate(String birth_date){
            this.birth_date = birth_date;
            return this;
        }
        
        public Builder setFirstName( String first_name){
            this.first_name = first_name;
            return this;
        }
        
        public Builder setLastName( String last_name){
            this.last_name = last_name;
            return this;
        }
   
        public Builder setGender( String gender){
            this.gender = gender;
            return this;
        }
        
        public Builder setHireDate(String hire_date){
            this.hire_date = hire_date;
            return this;
        }

        public Employee build(){
            return new Employee(this.emp_no, this.birth_date, this.first_name, this.last_name, this.gender, this.hire_date);
        }
    }
}