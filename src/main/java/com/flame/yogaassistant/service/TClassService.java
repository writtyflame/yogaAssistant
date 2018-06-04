package com.flame.yogaassistant.service;

import com.flame.yogaassistant.domain.TClass;
import com.flame.yogaassistant.domain.User;

import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 16:28 2018/6/4
 * @Modified By:
 */
public interface TClassService {

    TClass getClassByClassId(Integer classId);

    List<TClass> getClassList();

    boolean addClass(TClass clazz);

    boolean updateClass(TClass clazz);

    boolean deleteClass(Integer classId);
}
