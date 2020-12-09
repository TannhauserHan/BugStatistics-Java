package com.example.demo;

import com.example.demo.mapper.ZtBugMapper;
import com.example.demo.service.ZtBugService;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ZtBugMapper ztBugMapper;

	@Autowired
	private ZtBugService ztBugService;

	@Test
	void newBugEverDayMapper(){
		List<Map<String, Object>> Dev_list = ztBugMapper.newBugEverDay(3);
		for (Map<String, Object> res :
				Dev_list) {
			System.out.println(res);
		}
	}

	@Test
	void reOpenRateService(){
		List<Map<String, Object>> Dev_list = ztBugService.reOpenRate();
		for (Map<String, Object> res :
				Dev_list) {
			System.out.println(res);
		}
	}
	@Test
	void reOpenRateMapper() {
		List<Map<String, Object>> resolvedBug = ztBugMapper.resolvedBugCount(3);
		List<Map<String, Object>> fixedGreaterOneBug = ztBugMapper.fixedGreaterOneBugCount(3);
		List<Map<String, Object>> Dev_list = new ArrayList<>();
		int index = 0;
		for (Map<String, Object> resolved:
		resolvedBug){
			while (index<fixedGreaterOneBug.size()){
				if (resolved.get("resolvedBy").equals(fixedGreaterOneBug.get(index).get("resolvedBy"))){
					Map<String, Object> Dev = new HashMap<>();
					long fixedGreaterOneCount= (long)fixedGreaterOneBug.get(index).get("fixedGreaterOneCount");
					long resolvedBugCount = (long)resolved.get("resolvedBugCount");
					double reOpenRate = (double) fixedGreaterOneCount/ resolvedBugCount;
					Dev.put("name",resolved.get("resolvedBy"));
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
					Dev.put("name",resolved.get("resolvedBy"));
					Dev.put("fixedGreaterOneCount",0);
					Dev.put("resolvedBugCount",resolved.get("resolvedBugCount"));
					Dev.put("reOpenRate",reOpenRate);
					Dev_list.add(Dev);
					break;
				}
			};
		}
		for (Map<String, Object> res :
				Dev_list) {
			System.out.println(res);
		}
	}
}
