package com.kernel;

import java.lang.reflect.Method;

public class Logger implements ILogger {

	@Override
	public void doMethodBefore(Method method) {
		// TODO Auto-generated method stub
		System.out.println("方法调用前记录日志:" + method.getName());
	}

	@Override
	public void doMethodAfter(Method method) {
		// TODO Auto-generated method stub
		System.out.println("方法调用后记录日志:" + method.getName());
	}
}
