package com.example.demo.mapper;

import com.example.demo.entity.ZtBug;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author han
 * @since 2020-12-08
 */
@Repository()
public interface ZtBugMapper extends BaseMapper<ZtBug> {
    /**
     * 查询所有Bug
     * @return ZtBug实体
     */
    ZtBug selectBug();
    /**
     * 开发人员已解决的Bug数
     * @return List
     */
    List<Map<String,Object>> resolvedBugCount(Integer productId);
    /**
     * 开发人员未能一次解决Bug的个数
     * @return List
     */
    List<Map<String,Object>> fixedGreaterOneBugCount(Integer productId);

    /**
     *
     * @param productId
     * @return
     */
    List<Map<String,Object>> newBugEverDay(Integer productId);

}
