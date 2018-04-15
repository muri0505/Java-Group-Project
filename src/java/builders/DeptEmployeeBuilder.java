/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package builders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.DeptEmployee;

/**
 *
 * @author Owner
 */
public class DeptEmployeeBuilder {
     private static String COL_EMP_NO = "emp_no";
    private static String COL_DEPT_NO = "dept_no";
    private static String COL_FROM_DATE = "from_date";
    private static String COL_TO_DATE = "to_date";
    
    private DeptEmployee deptEmployee;
    
    public DeptEmployeeBuilder(){
        deptEmployee = new DeptEmployee();
    }
    
     public void build(Map<String, String[]> map) {
        setEmpNo(map);
        setDeptNo(map);
        setFromDate(map);
        setToDate(map);
    }
     
     public void setEmpNo(Map<String, String[]> map){
         deptEmployee.setEmpNo(map.get(COL_EMP_NO)[0]);
     }
     
     public void setDeptNo(Map<String, String[]> map){
         deptEmployee.setDeptNo(map.get(COL_DEPT_NO)[0]);
     }
     
     public void setFromDate(Map<String, String[]> map){
         deptEmployee.setFromDate(map.get(COL_FROM_DATE)[0]);
     }
     
     public void setToDate(Map<String, String[]> map){
         deptEmployee.setToDate(map.get(COL_TO_DATE)[0]);
     }
     
     public void setEmpNo(ResultSet rs){
         try{
             deptEmployee.setEmpNo(rs.getString(COL_EMP_NO));
         }catch (SQLException ex) {
             Logger.getLogger(DeptEmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setDeptNo(ResultSet rs){
         try{
             deptEmployee.setDeptNo(rs.getString(COL_DEPT_NO));
         }catch (SQLException ex) {
             Logger.getLogger(DeptEmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setFromDate(ResultSet rs){
         try{
             deptEmployee.setFromDate(rs.getString(COL_FROM_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(DeptEmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setToDate(ResultSet rs){
         try{
             deptEmployee.setToDate(rs.getString(COL_TO_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(DeptEmployeeBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public DeptEmployee getDeptEmployee(){
         return deptEmployee;
     }
}
