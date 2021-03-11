package com.github.lsrpc.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>date : 2021/3/11 14:42</p>
 * description: 系统时钟，替换{@link System#currentTimeMillis()}, 防止CPU频繁切换
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
public class SystemClock {
    private static final SystemClock instance = new SystemClock();

    /**
     * 精度（毫秒）
     */
    private long precision;

    private volatile long now;

    private ScheduledExecutorService scheduler;

    public static SystemClock getInstance() {
        return instance;
    }

    public SystemClock() {
        this(1);
    }

    public SystemClock(long precision) {
        this.precision = precision;
        now = System.currentTimeMillis();
        scheduler = Executors.newSingleThreadScheduledExecutor(runable -> {
            Thread thread = new Thread(runable, "SystemClock");
            thread.setDaemon(true);
            return thread;
        });
        scheduler.scheduleAtFixedRate(() -> {
            now = System.currentTimeMillis();
        }, precision, precision, TimeUnit.MILLISECONDS);
    }

    public long getTime() {
        return now;
    }

    public long precision() {
        return precision;
    }

    /**
     * 获取当前时钟
     *
     * @return 当前时钟
     */
    public static long now() {
        return instance.getTime();
    }


    /**
     * 获取当前时钟，微妙
     *
     * @return 微妙
     */
    public static long microTime() {
        long microTime = now() * 1000;
        long nanoTime = System.nanoTime(); // 纳秒
        return microTime + (nanoTime % 1000000) / 1000;
    }
}
