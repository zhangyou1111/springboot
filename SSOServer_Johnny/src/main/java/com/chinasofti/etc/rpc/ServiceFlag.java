/**
 *  Copyright 2018 ChinaSoft International Ltd. All rights reserved.
 */
package com.chinasofti.etc.rpc;

/**
 * <p>
 * Title: ServiceFlag
 * </p>
 * <p>
 * Description: 通讯指令标记集合
 * </p>
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * <p>
 * Company: ChinaSoft International Ltd.
 * </p>
 * 
 * @author ETC
 * @version 1.0
 */
public interface ServiceFlag {
	/**
	 * 客户端试图问询业务接口名的问询指令
	 * */
	int SERVICE_GETINTERFACE = 1;
	/**
	 * 客户端试图问询业务方法动态执行结果的问询指令
	 * */
	int SERVICE_GETINVOKERETURN = 2;
}
