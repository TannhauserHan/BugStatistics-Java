package com.example.demo.service.impl;

import com.example.demo.entity.ZtBug;
import com.example.demo.mapper.ZtBugMapper;
import com.example.demo.service.ZtBugService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author han
 * @since 2020-12-08
 */
@Service
public class ZtBugServiceImpl extends ServiceImpl<ZtBugMapper, ZtBug> implements ZtBugService {

    @Autowired
    ZtBugMapper ztBugMapper;

    @Override
    public ZtBug selectBug() {
        return ztBugMapper.selectBug();
    }

    @Override
    public List<Map<String, Object>> reOpenRate() {
        List<Map<String, Object>> Dev_list = new ArrayList<>();
        try {
            List<Map<String, Object>> resolvedBug = ztBugMapper.resolvedBugCount(3);
            List<Map<String, Object>> fixedGreaterOneBug = ztBugMapper.fixedGreaterOneBugCount(3);

            int index = 0;
            for (Map<String, Object> resolved:
                    resolvedBug){
                while (index<fixedGreaterOneBug.size()){
                    if (resolved.get("resolvedBy").equals(fixedGreaterOneBug.get(index).get("resolvedBy"))){
                        Map<String, Object> Dev = new HashMap<>();
                        long fixedGreaterOneCount= (long)fixedGreaterOneBug.get(index).get("fixedGreaterOneCount");
                        long resolvedBugCount = (long)resolved.get("resolvedBugCount");
                        double reOpenRate = (double) fixedGreaterOneCount/ resolvedBugCount;
                        Dev.put("name",resolved.get("realname"));
                        Dev.put("fixedGreaterOneCount",fixedGreaterOneBug.get(index).get("fixedGreaterOneCount"));
                        Dev.put("resolvedBugCount",resolved.get("resolvedBugCount"));
                        Dev.put("reOpenRate",reOpenRate);
                        index++;
                        Dev_list.add(Dev);
                        break;
                    }
                    else {
                        Map<String, Object> Dev = new HashMap<>();
                        double fixedGreaterOneCount= 0;
                        long resolvedBugCount = (long)resolved.get("resolvedBugCount");
                        double reOpenRate =  fixedGreaterOneCount/ resolvedBugCount;
                        Dev.put("name",resolved.get("realname"));
                        Dev.put("fixedGreaterOneCount",0);
                        Dev.put("resolvedBugCount",resolved.get("resolvedBugCount"));
                        Dev.put("reOpenRate",reOpenRate);
                        Dev_list.add(Dev);
                        break;
                    }
                };
            }
        } catch (Exception e) {
            log.error("查询失败");
        }
        return Dev_list;
    }

    @Override
    public List<Map<String, Object>> newBugEverDay() {
        return null;
    }
}
