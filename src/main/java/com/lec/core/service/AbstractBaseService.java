package com.lec.core.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.lec.framework.base.BaseMapper;
import com.lec.framework.base.Page;
import org.springframework.transaction.annotation.*;

import com.lec.common.system.service.RetrieveService;
import com.lec.common.user.service.AuthorityFilterContext;
import com.lec.framework.log.Logging;
import com.lec.framework.util.StringUtils;

/**
 * 所有服务类实现的基类
 * @author zhouhaij
 * @2013-3-22 下午02:58:07
 * @param <S>
 */
public abstract class AbstractBaseService<T,S> implements BaseService<T, S> {
	
	protected Logging logger = new Logging(getClass());
	
	@Resource(name="authorityFilterContext")
	AuthorityFilterContext authorityFilterContext;
	
	@Resource
	RetrieveService retrieveService;
	
	@Transactional
	public int deleteByExample(S example) {
		return getBaseMapper().deleteByExample(example);
	}

	@Override
	@Transactional
	public int deleteById(String id) {
		return getBaseMapper().deleteByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id,T record){
		return getBaseMapper().deleteByPrimaryKey(id);
	}
	
	@Override
	public T getById(String id) {
		return getBaseMapper().selectByPrimaryKey(id);
	}

	@Override
	public int getTotalByExample(S example) {
		return getBaseMapper().countByExample(example);
	}

	@Override
	@Transactional
	public int save(T record) {
		return getBaseMapper().insertSelective(record);
	}

	@Override
	public List<T> selectByExample(S example) {
		return getBaseMapper().selectByExample(example);
	}

	@Override
	public Page selectByExample(S example, int pageNo, int pageSize) {
		List<T> dics = getBaseMapper().selectByExample(example, Page.getRowBounds(pageNo, pageSize));
		int totalCount = getBaseMapper().countByExample(example);
		return Page.getPage(totalCount, dics, pageNo, pageSize);
	}

	@Override
	@Transactional
	public int updateByExample(T record, S example) {
		return getBaseMapper().updateByExample(record, example);
	}

	@Override
	@Transactional
	public int updateByExampleSelective(T record, S example) {
		return getBaseMapper().updateByExampleSelective(record, example);
	}

	@Override
	@Transactional
	public int updateById(T record) {
		return getBaseMapper().updateByPrimaryKey(record);
	}

	@Override
	@Transactional
	public int updateByIdSelective(T record) {
		return getBaseMapper().updateByPrimaryKeySelective(record);
	}

	/**
	 * 子类实现
	 * @return the baseMapper
	 */
	protected abstract BaseMapper<T, S> getBaseMapper();

	/*
	 *  (non-Javadoc)
	 * @see com.lec.core.service.BaseService#getListByCondition(java.util.Map, int, int, java.lang.String)
	 */
	@Override
	public Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize,String sortType) {
		if(StringUtils.notEmpty(sortType)){
			map.put("sortColumn", sortType);
		}
		List<T> dics = getBaseMapper().getListByCondition(map,Page.getRowBounds(pageNo, pageSize));
		int totalCount = getBaseMapper().countList(map);
		return Page.getPage(totalCount, dics, pageNo, pageSize);
	}

	/* (non-Javadoc)
	 * @see com.lec.core.service.BaseService#getListByCondition(java.util.Map, int, int, java.lang.String, java.lang.String)
	 */
	@Override
	public Page getListByCondition(Map<String, Object> map, int pageNo, int pageSize,String sortType,String menuid) {
		Page page =  getListByCondition(authorityFilterContext.filter(map,menuid),pageNo,pageSize,sortType);
		map.remove(AuthorityFilterContext.DEPARTMENT_KEY);
		return page;
	}

	/* (non-Javadoc)
	 * @see com.lec.core.service.BaseService#countList(java.util.Map)
	 */
	@Override
	public int countList(Map<String, Object> map) {
		return  getBaseMapper().countList(map);
	}


    /* (non-Javadoc)
 * @see com.lec.core.service.BaseService#countList(java.util.Map)
 */
    @Override
    public int countList(Map<String, Object> map,String menuid) {
        return  getBaseMapper().countList(authorityFilterContext.filter(map,menuid));
    }
	
	
}
