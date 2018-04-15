/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import transferobjects.DeptManager;

/**
 *
 * @author Owner
 */
public interface DeptManagerDAO {
    List<DeptManager> getAllDeptManagers();

    void addDeptManager(DeptManager deptManager);
}
