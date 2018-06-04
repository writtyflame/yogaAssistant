package com.flame.yogaassistant.service;

import com.flame.yogaassistant.Utils.TimeUtils;
import com.flame.yogaassistant.domain.Poster;
import com.flame.yogaassistant.mapper.PosterMapper;
import com.flame.yogaassistant.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 15:04 2018/6/4
 * @Modified By:
 */
public class PosterServiceImpl implements PosterService {

    @Autowired
    private PosterMapper posterMapper;

    @Override
    public Poster getPosterByPosterId(Integer posterId) {
        return posterMapper.queryPosterById(posterId);
    }

    @Override
    public List<Poster> getPosterList() {
        return posterMapper.queryPosterList();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean addPoster(Poster poster) {

        // 设置插入信息时间
        poster.setCreateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));
        poster.setUpdateTime(TimeUtils.dateToString(new Date(),TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));

        try {
            // 插入海报信息
            int effectedNum = posterMapper.insertPoster(poster);

            if(effectedNum > 0){
                return true;
            }else {
                // @Transactional 默认只会回滚 RuntimeException 类型的异常
                throw new RuntimeException("插入海报信息失败！");
            }
        }catch (Exception e){
            throw new RuntimeException("插入海报信息失败！" + e.getMessage());
        }
    }

    @Override
    public boolean updatePoster(Poster poster) {
        if(poster.getPosterId() != null && poster.getPosterId() > 0) {
            // 修改最后一次修改时间
            poster.setUpdateTime(TimeUtils.dateToString(new Date(), TimeUtils.TIME_FORMAT_YYYY_MM_DD_HH_MM_SS));

            try {
                // 更新海报信息
                int effectedNum = posterMapper.updatePoster(poster);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("修改海报信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("修改海报信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("修改海报信息失败！");
        }
    }

    @Override
    public boolean deletePoster(Integer posterId) {
        if(posterId > 0){
            try {
                // 删除海报信息
                int effectedNum = posterMapper.deletePosterId(posterId);

                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("删除海报信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除海报信息失败！" + e.getMessage());
            }
        }else {
            throw new RuntimeException("删除海报信息失败！");
        }
    }
}
