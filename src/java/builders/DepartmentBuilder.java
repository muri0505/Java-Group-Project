package builders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Department;

/**
 *
 * @author shican
 */
public class DepartmentBuilder {

    private static String COL_DEPT_NO = "dept_no";
    private static String COL_DEPT_NAME = "dept_name";
    private Department department;

    public DepartmentBuilder(){
        department = new Department();
    }
    
    public void build(Map<String, String[]> map) {
        setDeptNo(map);
        setDeptName(map);
    }

    public void setDeptName(ResultSet rs) {
        try {
            department.setDeptName(rs.getString(COL_DEPT_NAME));
        } catch (SQLException ex) {
            Logger.getLogger(DepartmentBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDeptName(Map<String, String[]> map) {
        department.setDeptName(map.get("dept_name")[1]);
    }

    public void setDeptNo(ResultSet rs) {
        try {
            department.setDeptNo(rs.getString(COL_DEPT_NO));
        } catch (SQLException ex) {
            department.setDeptNo(null);
            Logger.getLogger(DepartmentBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setDeptNo(Map<String, String[]> map) {
        department.setDeptNo(map.get("dept_no")[0]);
    }

    public Department getDept() {
        return department;
    }
}
