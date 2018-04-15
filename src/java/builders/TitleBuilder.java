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
import transferobjects.Title;
/**
 *
 * @author Owner
 */
public class TitleBuilder {
    private static String COL_EMP_NO = "emp_no";
    private static String COL_TITLE = "title";
    private static String COL_FROM_DATE = "from_date";
    private static String COL_TO_DATE = "to_date";
    
    private Title title;
    
    public TitleBuilder(){
        title = new Title();
    }
    
     public void build(Map<String, String[]> map) {
        setEmpNo(map);
        setTitle(map);
        setFromDate(map);
        setToDate(map);
    }
     
     public void setEmpNo(Map<String, String[]> map){
         title.setEmpNo(map.get(COL_EMP_NO)[0]);
     }
     
     public void setTitle(Map<String, String[]> map){
         title.setTitle(map.get(COL_TITLE)[0]);
     }
     
     public void setFromDate(Map<String, String[]> map){
         title.setFromDate(map.get(COL_FROM_DATE)[0]);
     }
     
     public void setToDate(Map<String, String[]> map){
         title.setToDate(map.get(COL_TO_DATE)[0]);
     }
     
     public void setEmpNo(ResultSet rs){
         try{
             title.setEmpNo(rs.getString(COL_EMP_NO));
         }catch (SQLException ex) {
             Logger.getLogger(TitleBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setTitle(ResultSet rs){
         try{
             title.setTitle(rs.getString(COL_TITLE));
         }catch (SQLException ex) {
             Logger.getLogger(TitleBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setFromDate(ResultSet rs){
         try{
             title.setFromDate(rs.getString(COL_FROM_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(TitleBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public void setToDate(ResultSet rs){
         try{
             title.setToDate(rs.getString(COL_TO_DATE));
         }catch (SQLException ex) {
             Logger.getLogger(TitleBuilder.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
     
     public Title getTitle(){
         return title;
     }
}
