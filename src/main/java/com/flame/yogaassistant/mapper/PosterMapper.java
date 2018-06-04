package com.flame.yogaassistant.mapper;

import com.flame.yogaassistant.domain.Poster;
import com.flame.yogaassistant.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 15:26 2018/6/4
 * @Modified By:
 */
@Repository
public interface PosterMapper {

    Poster queryPosterById(Integer posterId);

    List<Poster> queryPosterList();

    int insertPoster(Poster poster);

    int updatePoster(Poster poster);

    int deletePosterId(Integer posterId);

}
