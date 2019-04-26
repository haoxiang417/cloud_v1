package com.lec.common.system.cache;

import com.lec.common.system.service.ResourceService;
import com.lec.common.system.vo.SystemResource;
import com.lec.framework.cache.BaseCache;
import com.lec.framework.cache.Cache;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2014/11/24.
 */
public class MenuCache implements BaseCache {

    public static final String MENU_CACHE_MAP = "menu_cache_map";

    @Resource
    ResourceService resourceService;

    @Resource
    Cache cache;

    /**
     * <p>方法说明：初始化</p>
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        List<SystemResource> systemResourceList = resourceService.findAll(false);
        Map<String,String> cacheMap = new HashMap<String,String>();
        for (int i = 0; i < systemResourceList.size(); i++) {
            SystemResource systemResource =  systemResourceList.get(i);
            cacheMap.put(systemResource.getId(),systemResource.getParentid());
        }
        cache.put(MENU_CACHE_MAP,cacheMap);
    }

    /**
     * 这是缓存的key值
     *
     * @return
     */
    @Override
    public String getCacheKey() {
        return MENU_CACHE;
    }
}
