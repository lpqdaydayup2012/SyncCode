package com.kernel;

import java.lang.reflect.Method;

public interface ILogger {

	public void doMethodBefore(Method method);

	public void doMethodAfter(Method method);
}
