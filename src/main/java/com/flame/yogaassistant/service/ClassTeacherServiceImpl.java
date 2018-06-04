package com.flame.yogaassistant.service;

import com.flame.yogaassistant.Utils.TimeUtils;
import com.flame.yogaassistant.domain.ClassTeacher;
import com.flame.yogaassistant.mapper.ClassTeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 17:44 2018/6/4
 * @Modified By:flame
 */
public class ClassTeacherServiceImpl implements ClassTeacherService {

    @Autowired
    ClassTeacherMapper classTeacherMapper;

    @Override
    public ClassTeacher getClassTeacherByClassTeacherId(Integer classTeacherId) {
        return classTeacherMapper.queryClassTeacherById(classTeacherId);
    }

    @Override
    public List<ClassTeacher> getClassTeacherList() {
        return classTeacherMapper.queryClassTeacher();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addClassTeacher(ClassTeacher classTeacher) {
        if(classTeacher.getClassId()>0 && classTeacher.getUserId()>0){

        // 设置插入信息时间
        classTeacher.setCreateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
        classTeacher.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));

            try {
                // 插入班级教师信息
                int effectedNum = classTeacherMapper.insertClassTeacher(classTeacher);

                if(effectedNum > 0){
                    return true;
                }else {
                    // @Transactional 默认只会回滚 RuntimeException 类型的异常
                    throw new RuntimeException("插入班级教师信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入班级教师信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("插入用户信息失败！");
        }


    }

    @Override
    public boolean updateClassTeacher(ClassTeacher classTeacher) {
        if(classTeacher.getClassId()!=null && classTeacher.getClassId()>0){
            // 修改最后一次修改时间
            classTeacher.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));

            try {
                // 更新班级教师信息
                int effectedNum = classTeacherMapper.updateClassTeacher(classTeacher);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("修改班级教师信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改班级教师信息失败！" + e.getMessage());
            }
        }else{
            throw new RuntimeException("修改班级教师信息失败！");
        }
    }

    @Override
    public boolean deleteClassTeacher(Integer classTeacherId) {
        if(classTeacherId > 0){
            try {
                // 删除班级教师信息
                int effectedNum = classTeacherMapper.deleteClassTeacherById(classTeacherId);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除班级教师信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除班级教师信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除班级教师信息失败！");
        }
    }
}
