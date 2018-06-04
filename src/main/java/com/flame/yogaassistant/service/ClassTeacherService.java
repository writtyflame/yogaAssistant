package com.flame.yogaassistant.service;

import com.flame.yogaassistant.domain.ClassTeacher;
import com.flame.yogaassistant.domain.Poster;

import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 17:41 2018/6/4
 * @Modified By:
 */
public interface ClassTeacherService {
    ClassTeacher getClassTeacherByClassTeacherId(Integer classTeacherId);

    List<ClassTeacher> getClassTeacherList();

    boolean addClassTeacher(ClassTeacher classTeacher);

    boolean updateClassTeacher(ClassTeacher classTeacher);

    boolean deleteClassTeacher(Integer classTeacherId);
}
