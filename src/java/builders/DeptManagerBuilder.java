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
import transferobjects.DeptManager;

/**
 *
 * @author Owner
 */
public class DeptManagerBuilder {
    private static String COL_EMP_NO = "emp_no";
    private static String COL_DEPT_NO = "dept_no";
    private static String COL_FROM_DATE = "from_date";
    private static String COL_TO_DATE = "to_date";
    
    private DeptManager deptManager;
    
    public DeptManagerBuilder(){
        deptManager = new DeptManager();
    }
    
     public void build(Map<String, String[]> map) {
        setEmpNo(map);
        setDeptNo(map);
        setFromDate(map);
        setToDate(map);
    }
     
     public void setEmpNo(Map<String, String[]> map){
         deptManager.setEmpNo(map.get(COL_EMP_NO)[0]);
     }
     
     public void setDeptNo(Map<String, String[]> map){
         deptManager.setDeptNo(map.get(COL_DEPT_NO)[0]);
     }
     
     public void setFromDate(Map<String, String[]> map){
         deptManager.setFromDate(map.get(COL_FROM_DATE)[0]);
     }
     
     public void setToDate(Map<String, String[]> map){
         deptManager.setToDate(map.get(COL_TO_DATE)[0]);
     }
     
     public void setEmpNo(ResultSet rs){
         try{
             deptManager.setEmpNo(rs.getString(COL_EMP_NO));
         }catch (SQLException ex) {
             deptManager.setEmpNo(null);
             Logger.getLogger(DeptManagerBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setDeptNo(ResultSet rs){
         try{
             deptManager.setDeptNo(rs.getString(COL_DEPT_NO));
         }catch (SQLException ex) {
             deptManager.setDeptNo(null);
             Logger.getLogger(DeptManagerBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setFromDate(ResultSet rs){
         try{
             deptManager.setFromDate(rs.getString(COL_FROM_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(DeptManagerBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setToDate(ResultSet rs){
         try{
             deptManager.setToDate(rs.getString(COL_TO_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(DeptManagerBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public DeptManager getDeptManager(){
         return deptManager;
     }
}
