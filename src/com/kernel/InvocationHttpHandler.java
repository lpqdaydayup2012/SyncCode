package com.kernel;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHttpHandler implements InvocationHandler {

	private Object executor;

	private Object logger;

	public Object bindMethod(Object executor, Object logger) {
		// TODO Auto-generated method stub
		this.executor = executor;
		this.logger = logger;
		return Proxy.newProxyInstance(this.executor.getClass().getClassLoader(),
				this.executor.getClass().getInterfaces(),
				this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		Object result = null;
		Method methodBefore = this.logger.getClass().getMethod("doMethodBefore", new Class[] { Method.class });
		methodBefore.invoke(this.logger, new Object[] { method });
		result = method.invoke(this.executor, args);
		Method methodAfter = this.logger.getClass().getMethod("doMethodAfter", new Class[] { Method.class });
		methodAfter.invoke(this.logger, new Object[] { method });
		return result;
	}
}
