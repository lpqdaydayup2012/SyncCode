package com.kernel;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

import com.core.HttpClientHelper;

public class WebSiteCallable implements Callable<WebSiteEntity> {

	private String url;

	private String name;

	private CountDownLatch latch;

	/*
	 * ���캯��
	 */
	public WebSiteCallable(String url, String name, CountDownLatch latch) {
		this.url = url;
		this.name = name;
		this.latch = latch;
	}

	@Override
	public WebSiteEntity call() throws Exception {
		// TODO Auto-generated method stub
		WebSiteEntity webSiteEntity = new WebSiteEntity();
		String str = HttpClientHelper.doGet(url, 5000, "utf-8");
		webSiteEntity.setName(name);
		webSiteEntity.setUrl(url);
		webSiteEntity.setContent(str);
		latch.countDown();
		return webSiteEntity;
	}
}
