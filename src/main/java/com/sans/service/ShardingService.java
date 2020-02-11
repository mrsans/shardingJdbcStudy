package com.sans.service;

import com.sans.dao.ShardingDao;
import com.sans.pojo.Course;
import com.sans.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShardingService {

    @Autowired
    private ShardingDao shardingDao;

    public void insert(Student student) {
        shardingDao.insert(student);
    }

    public void insertLevel(Student student) {
        shardingDao.insertLevel(student);
    }

    public List<Student> selectAllDatas() {
        return shardingDao.selectAllDatas();
    }

    public void insertCourse(Course course) {
        shardingDao.insertCourse(course);
    }
}
