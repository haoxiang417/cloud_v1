package com.lec.core.security;

import com.lec.common.user.service.UserService;
import com.lec.common.user.vo.User;
import com.lec.core.security.OperatorDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Set;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 * @author zhouhaijian
 * @version 1.0
**/
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Resource
	UserService userService;
	
	/**
	 * 获取用户Detail信息的回调函数.
	 */
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException, DataAccessException {

		User user = userService.findUserByLoginName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("用户" + userName + " 不存在");
		}
		
		Set<GrantedAuthority> grantedAuths = userService.getRoleListByUser(user.getId());
		
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		OperatorDetails userDetails = new OperatorDetails(user.getName(), user.getPwd(), enabled,accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);
		//加入登录时间信息和用户角色
		userDetails.setLoginTime(new Date());
		userDetails.setId(user.getId());
		userDetails.setAccount(user.getAccount());
		userDetails.setRealName(user.getName());
		userDetails.setMobileNo(user.getMobile());
		userDetails.setDeptId(user.getDeptid());
		userDetails.setSkin(user.getSkin());
		return userDetails;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	

}
