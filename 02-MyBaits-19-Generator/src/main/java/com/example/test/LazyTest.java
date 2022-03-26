package com.example.test;


import com.example.dao.StudentMapper;
import com.example.entity.Student;
import com.example.entity.StudentExample;
import com.example.util .MyBatisUtil;
import org.junit.Test;

import java.util.List;

public class LazyTest {
    @Test
    public void test(){
        StudentMapper mapper = MyBatisUtil.getMapper(StudentMapper.class);
        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        criteria.andAgeNotEqualTo(20);
        List<Student> students = mapper.selectByExample(example);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
