package com.dao;

import com.entity.Dept;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nkc
 * @date 22/3/25
 */
public interface DeptDAO {

    /**
     * 批量新增部门
     * @param depts
     * @return
     */
    int saveBatchDept(@Param("depts") List<Dept> depts);

    /**
     * 根据部门id查询
     * @param did
     * @return
     */
    Dept getDeptById(@Param("did")Integer did);
}
