package cn.shianxian.supervise.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Executors {

    private volatile static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("record-pool-%d").build();

    public volatile static ThreadPoolExecutor pool = new ThreadPoolExecutor(
            8,
            10,
            300,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(50),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

}