package com.flame.yogaassistant.service;

import com.flame.yogaassistant.domain.Poster;
import com.flame.yogaassistant.domain.User;

import java.util.List;

/**
 * @Author: flame
 * @Description:
 * @Date: Created in 15:04 2018/6/4
 * @Modified By:
 */
public interface PosterService {

    Poster getPosterByPosterId(Integer posterId);

    List<Poster> getPosterList();

    boolean addPoster(Poster poster);

    boolean updatePoster(Poster poster);

    boolean deletePoster(Integer posterId);

}
