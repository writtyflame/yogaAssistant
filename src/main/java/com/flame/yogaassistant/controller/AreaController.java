package com.flame.yogaassistant.controller;

import com.flame.yogaassistant.domain.Area;
import com.flame.yogaassistant.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author flame
 * @create 2018-05-26 15:39
 **/
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    
    @Autowired
    private AreaService areaService;
    
    @GetMapping(value = "/listarea")
    public Map<String, Object> listArea(){
        Map<String, Object> modelMap = new HashMap<>();
        List<Area> list = areaService.getAreaList();
        
        modelMap.put("areaList", list);
        
        return modelMap;
    }
    
    @GetMapping("/getarea")
    public Map<String, Object> getAreaByAreaId(Integer areaId){
        Map<String, Object> modelMap = new HashMap<>();
        Area area = areaService.getAreaByAreaId(areaId);
        
        modelMap.put("area", area);
        
        return modelMap;
    }
    
    @PostMapping("/addarea")
    public Map<String, Object> addArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();
        modelMap.put("success", areaService.addArea(area));
        
        return modelMap;
    }

    @PostMapping("/modifyarea")
    public Map<String, Object> modifyArea(@RequestBody Area area){
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", areaService.modifyArea(area));

        return modelMap;
    }
    
    @GetMapping("/delarea")
    public Map<String, Object> deleteArea(Integer areaId){
        System.out.println(areaId);
        Map<String, Object> modelMap = new HashMap<>();

        modelMap.put("success", areaService.deleteArea(areaId));

        return modelMap;
    } 
    
}
