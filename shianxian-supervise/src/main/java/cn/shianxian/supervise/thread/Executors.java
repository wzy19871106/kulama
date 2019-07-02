package cn.shianxian.supervise.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Executors {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("record-pool-%d").build();

    public static ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());


}