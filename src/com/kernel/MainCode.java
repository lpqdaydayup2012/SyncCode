package com.kernel;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MainCode {
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		final CountDownLatch latch = new CountDownLatch(1);
		ExecutorService service = Executors.newCachedThreadPool();
		WebSiteCallable task = new WebSiteCallable("http://www.baidu.com", "°Ù¶È", latch);
		FutureTask<WebSiteEntity> futureTask = new FutureTask<>(task);
		service.submit(futureTask);
		service.shutdown();
		latch.await();
		System.out.println(futureTask.get());
	}
}
