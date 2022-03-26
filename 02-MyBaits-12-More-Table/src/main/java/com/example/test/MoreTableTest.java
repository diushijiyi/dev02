package com.example.test;

import com.example.dao.DepartmentDao;
import com.example.dao.EmployeeDao;
import com.example.dao.StudentDao;
import com.example.dao.SubjectDao;
import com.example.entity.Department;
import com.example.entity.Employee;
import com.example.entity.Student;
import com.example.entity.Subject;
import com.example.util.MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class MoreTableTest {
    @Test
    public void testSubject(){
        SubjectDao subjectDao = MyBatisUtil.getMapper(SubjectDao.class);
        List<Subject> subjects = subjectDao.findAll();
        for (Subject subject : subjects) {
            System.out.println(subject);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testStudent(){
        StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
        List<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println(student);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void testDepartment(){
        DepartmentDao departmentDao = MyBatisUtil.getMapper(DepartmentDao.class);
        List<Department> departments = departmentDao.findAll();
        for (Department department : departments) {
            System.out.println(department);
        }
        MyBatisUtil.commit();
    }
    @Test
    public void test(){
        EmployeeDao employeeDao = MyBatisUtil.getMapper(EmployeeDao.class);
        List<Employee> employees = employeeDao.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        MyBatisUtil.commit();
    }
}
