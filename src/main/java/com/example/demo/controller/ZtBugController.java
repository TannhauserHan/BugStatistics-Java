package com.example.demo.controller;

import com.example.demo.entity.ZtBug;
import com.example.demo.service.ZtBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author han
 * @since 2020-12-08
 */
@RestController
@RequestMapping("/zt-bug")
public class ZtBugController {

    @Autowired
    private ZtBugService ztBugService;

    @GetMapping("/test")
    public ZtBug selectBug(){
        return ztBugService.selectBug();
    }

    @GetMapping("/reOpenRate")
    public List<Map<String, Object>> reOpenRate(){
        return ztBugService.reOpenRate();
    }
}

