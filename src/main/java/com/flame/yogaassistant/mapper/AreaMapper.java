package com.flame.yogaassistant.mapper;

import com.flame.yogaassistant.domain.Area;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author flame
 * @create 2018-05-26 10:13
 **/
@Repository
public interface AreaMapper {
    /**
     * 列出区域信息
     *
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据查询某一个区域信息
     *
     * @param id
     * @return
     */
    Area queryAreaById(Integer id);

    /**
     * 插入一个区域信息
     *
     * @param area 区域
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除某一个区域信息
     *
     * @param id
     * @return
     */
    int deleteAreaById(Integer id);
}
