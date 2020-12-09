package com.example.demo.service;

import com.example.demo.entity.ZtBug;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.mapper.ZtBugMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author han
 * @since 2020-12-08
 */
public interface ZtBugService extends IService<ZtBug> {
    ZtBug selectBug();
    List<Map<String,Object>> reOpenRate();
    List<Map<String,Object>> newBugEverDay();
}
