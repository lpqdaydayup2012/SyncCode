package com.kernel;

import java.lang.reflect.Method;

public class Logger implements ILogger {

	@Override
	public void doMethodBefore(Method method) {
		// TODO Auto-generated method stub
		System.out.println("��������ǰ��¼��־:" + method.getName());
	}

	@Override
	public void doMethodAfter(Method method) {
		// TODO Auto-generated method stub
		System.out.println("�������ú��¼��־:" + method.getName());
	}
}
