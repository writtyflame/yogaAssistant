package com.flame.yogaassistant.mapper;

import com.flame.yogaassistant.domain.TClass;
import com.flame.yogaassistant.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TClassMapper {

    List<TClass> queryClass();

    TClass queryClassById(Integer id);

    int insertClass(TClass clazz);

    int updateClass(TClass clazz);

    int deleteClassById(Integer id);
}
