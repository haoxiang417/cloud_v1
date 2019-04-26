package com.lec.common.user.service.impl;


/**
 * <p>卡口模块验证器</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public class VioValidator extends AbstractModuleValidator {

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.impl.AbstractModuleValidator#getType()
	 */
	@Override
	public String getType() {
		return "vio";
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.impl.AbstractModuleValidator#enable()
	 */
	@Override
	protected boolean enable() {
		return vioEnable();
	}
	
}
