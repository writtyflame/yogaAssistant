package com.flame.yogaassistant.service;

import com.flame.yogaassistant.Utils.TimeUtils;
import com.flame.yogaassistant.domain.TClass;
import com.flame.yogaassistant.mapper.TClassMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 16:36 2018/6/4
 * @Modified By:
 */
public class TClassServiceImpl implements TClassService {

    @Autowired
    private TClassMapper classMapper;

    @Override
    public TClass getClassByClassId(Integer classId) {
        return classMapper.queryClassById(classId);
    }

    @Override
    public List<TClass> getClassList() {
        return classMapper.queryClass();
    }

    @Override
    public boolean addClass(TClass clazz) {
        // 设置插入信息时间
        clazz.setCreateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
        clazz.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
        try {
            // 插入用户信息
            int effectedNum = classMapper.insertClass(clazz);

            if(effectedNum > 0){
                return true;
            }else {
                // @Transactional 默认只会回滚 RuntimeException 类型的异常
                throw new RuntimeException("插入班级信息失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("插入班级信息失败！" + e.getMessage());
        }
    }

    @Override
    public boolean updateClass(TClass clazz) {
        if(clazz.getClassId() != null && clazz.getClassId() > 0){
            // 修改最后一次修改时间
            clazz.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
        }else {
            throw new RuntimeException("修改班级信息失败！");
        }

        return false;
    }

    @Override
    public boolean deleteClass(Integer classId) {
        if(classId > 0){
            try {
                // 删除班级信息
                int effectedNum = classMapper.deleteClassById(classId);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除班级信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除班级信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除班级信息失败！");
        }
    }
}
