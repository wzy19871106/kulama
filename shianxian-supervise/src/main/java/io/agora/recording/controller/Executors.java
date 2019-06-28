package io.agora.recording.controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.*;

public class Executors {

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();


    public static Map<String, Long> nativeHandleMap = new ConcurrentHashMap<>();


    private static ExecutorService pool = new ThreadPoolExecutor(5, 200, 0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(1024),
            namedThreadFactory,
            new ThreadPoolExecutor.AbortPolicy());

    public static void execute(Runnable runnable) {
        pool.execute(runnable);
    }

}
