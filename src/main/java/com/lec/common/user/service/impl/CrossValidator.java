package com.lec.common.user.service.impl;



/**
 * <p>卡口模块验证器</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
public class CrossValidator extends AbstractModuleValidator {

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.impl.AbstractModuleValidator#getType()
	 */
	@Override
	public String getType() {
		return "cross";
	}

	/* (non-Javadoc)
	 * @see com.lec.common.user.service.ModuleValidator#isEnable()
	 */
	@Override
	public boolean enable() {
		return crossEnable();
	}

	
}
