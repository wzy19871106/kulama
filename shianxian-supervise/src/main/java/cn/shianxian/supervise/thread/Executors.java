package cn.shianxian.supervise.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

public class Executors {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("record-pool-%d").build();

    public static ExecutorService pool = new ThreadPoolExecutor(
            5,
            200,
            300,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(200),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

}