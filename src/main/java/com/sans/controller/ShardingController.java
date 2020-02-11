package com.sans.controller;

import com.sans.pojo.Course;
import com.sans.pojo.Student;
import com.sans.service.ShardingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ShardingController {

    @Autowired
    private ShardingService shardingService;

    @RequestMapping("/insert")
    public void insert(Student student) {
        shardingService.insert(student);
    }


    @RequestMapping("/insertLevel")
    public void insertLevel(Student student) {
        shardingService.insertLevel(student);
    }

    @RequestMapping("/selectAllDatas")
    public Object selectAllDatas() {
        final List<Student> students = shardingService.selectAllDatas();
        log.warn("数据长度：" + students.size());
        return students;
    }

    @RequestMapping("/insertCourse")
    public void insertCourse(Course course) {
        this.shardingService.insertCourse(course);
    }
}
