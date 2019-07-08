package cn.shianxian.supervise.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool {

    private ThreadPool(){
    }

    private static final ThreadPool THREAD_POOL = new ThreadPool();

    private static final int CORE_POOL_SIZE = 8;
    private static final int MAXIMUM_POOL_SIZE = 10;
    private static final int KEEP_ALIVE_TIME = 3000;

    private final ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("record-pool-%d").build();

    private final ThreadPoolExecutor pool = new ThreadPoolExecutor(
            CORE_POOL_SIZE,
            MAXIMUM_POOL_SIZE,
            KEEP_ALIVE_TIME,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(50),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());


    public static ThreadPool getInstance() {
        return THREAD_POOL;
    }


    public void addExecuteTask(Runnable task) {
        if (task != null) {
            pool.execute(task);
        }
    }


    public int getPoolSize(){
        return pool.getPoolSize();
    }


    public int getQueueSize() {
        return pool.getQueue().size();
    }


}