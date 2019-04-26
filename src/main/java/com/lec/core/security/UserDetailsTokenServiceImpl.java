package com.lec.core.security;

import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.springframework.security.cas.authentication.CasAssertionAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 实现SpringSecurity的UserDetailsService接口,实现获取用户Detail信息的回调函数.
 *
 * @author zhouhaijian
 * @version 1.0
 **/
@Service
public class UserDetailsTokenServiceImpl implements AuthenticationUserDetailsService<CasAssertionAuthenticationToken> {

	/**
	 * @param token
	 *            The pre-authenticated authentication token
	 * @return UserDetails for the given authentication token, never null.
	 * @throws UsernameNotFoundException
	 *             if no user details can be found for the given authentication token
	 */
	@Override
	public UserDetails loadUserDetails(CasAssertionAuthenticationToken token) throws UsernameNotFoundException {

		Assertion assertion = token.getAssertion();
		AttributePrincipal principal = assertion.getPrincipal();
		Map<String, Object> attributes = principal.getAttributes();
		String username = principal.getName();

		String id = attributes.get("id").toString();
		String password = attributes.get("passwd").toString();
		String mobile = attributes.get("mobile").toString();
		String deptid = attributes.get("orgid").toString();
		String name = attributes.get("name").toString();
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		if (attributes.get("roles") != null) {
			String roles = attributes.get("roles").toString();
			if (StringUtils.isNotBlank(roles)) {
				for (String role : roles.split(",")) {
					GrantedAuthority authorityInfo = new SimpleGrantedAuthority(role);
					authorities.add(authorityInfo);
				}
			}
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		OperatorDetails userDetails = new OperatorDetails(name, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		// 加入登录时间信息和用户角色
		userDetails.setLoginTime(new Date());
		userDetails.setId(id);
		userDetails.setAccount(username);
		userDetails.setRealName(name);
		userDetails.setMobileNo(mobile);
		userDetails.setDeptId(deptid);
		userDetails.setSkin("no-skin");
		return userDetails;
	}
}
