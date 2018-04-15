/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.DeptEmployee;

/**
 *
 * @author Owner
 */
public interface DeptEmployeeDAO {
    List<DeptEmployee> getAllDeptEmployees();

    void addDeptEmployee(DeptEmployee deptEmployee);
    DeptEmployee getDeptEmployeeByEmpNo(Integer empNo);
    List<DeptEmployee> getDeptEmployeeByDeptNo(String deptNo);
}
