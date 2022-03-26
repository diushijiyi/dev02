package com.example.test;


import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class LazyTest {
    @Test
    public void testDepartment(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);
        Department department = departmentDao.findById(1);
        System.out.println(department);
        MyBatisUtil.commit();
    }
    @Test
    public void testEmployee(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.findById(1);
        System.out.println(employees);
        MyBatisUtil.commit();
    }
}
