package com.lec.common.system.vo;

import java.io.Serializable;

public class SystemResourceHelp implements Serializable {

	private static final long serialVersionUID = -8814043907063242921L;

	public SystemResourceHelp() {}
	public SystemResourceHelp(String menuId, String helpContent) {
		this.menuId = menuId;
		this.helpContent = helpContent;
	}
	
	
	private String menuId;
	private String helpContent;
	public String getMenuId() {
		return menuId;
	}
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
}
