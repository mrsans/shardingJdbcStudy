package com.sans.dao;

import com.sans.pojo.Course;
import com.sans.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ShardingDao {

    @Insert("insert into t_student1(n_id, c_name, c_place, n_sex, n_card)values (#{nId}, #{cName}, #{cPlace}, #{nSex}, #{nCard})")
    void insert(Student student);

    @Insert("insert into t_student(c_name, c_place, n_sex, n_card)values (#{cName}, #{cPlace}, #{nSex}, #{nCard})")
    void insertLevel(Student student);

    @Select("select * from t_student")
    List<Student> selectAllDatas();

    @Insert("insert into t_course(n_id, c_name) values (#{nId}, #{cName})")
    void insertCourse(Course course);
}
