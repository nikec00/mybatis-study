package com.dao;

import com.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nkc
 * @date 22/3/25
 */
public interface EmpDAO {

    /**
     * 查询全部
     * @return
     */
    List<Emp> findAll();

    /**
     * 批量新增员工
     * @param emps
     * @return
     */
    int saveBatchEmp(@Param("emps") List<Emp> emps);


    List<Emp> findLazyAll();
}
