package com.flame.yogaassistant.mapper;

import com.flame.yogaassistant.domain.ClassTeacher;
import com.flame.yogaassistant.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassTeacherMapper {

    List<ClassTeacher> queryClassTeacher();

    ClassTeacher queryClassTeacherById(Integer id);

    int insertClassTeacher(ClassTeacher user);

    int updateClassTeacher(ClassTeacher user);

    int deleteClassTeacherById(Integer id);
}
