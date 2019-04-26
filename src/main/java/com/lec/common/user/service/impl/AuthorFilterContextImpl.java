package com.lec.common.user.service.impl;

import com.lec.common.user.service.AuthorityFilterContext;
import com.lec.common.user.service.BlackAuthorityFilter;
import com.lec.common.user.service.DepartmentAuthorityFilter;
import com.lec.common.user.service.GpsAuthorityFilter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>部门权限过滤器实现类</p>
 *
 * @author zhouhaij
 * @since 1.0
 */
@Service(value = "authorityFilterContext")
public class AuthorFilterContextImpl implements AuthorityFilterContext {

    @Resource
    DepartmentAuthorityFilter departmentAuthorityFilter;

    @Resource
    GpsAuthorityFilter gpsAuthorityFilter;

    @Resource
    BlackAuthorityFilter blackAuthorityFilter;


    /* (non-Javadoc)
     * @see com.lec.common.user.service.AuthorityFilterContext#filter(java.util.Map, java.lang.String)
     */
    @Override
    public Map<String, Object> filter(Map<String, Object> map, String menuid) {
        return map;
    }

    /**
     * 权限处理返回sql字符串
     */
    @Override
    public String filterSql(String menuid) {
        return departmentAuthorityFilter.filterSql(menuid);
    }


}
