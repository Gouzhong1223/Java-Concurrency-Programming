package com.gouzhong1223.thread.threadgroup;

import java.util.concurrent.TimeUnit;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 线程组复制线程
 * @Date : create by QingSong in 2020-07-31 3:46 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.thread.threadgroup
 * @ProjectName : java concurrent programming
 * @Version : 1.0.0
 */
public class ThreadGroupEnumerateThreads {
    public static void main(String[] args) throws InterruptedException {

        ThreadGroup myGroup = new ThreadGroup("MyGroup");

        Thread myThread = new Thread(myGroup, () -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "MyThread");
        myThread.start();

        TimeUnit.MILLISECONDS.sleep(2);
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread[] threads = new Thread[threadGroup.activeCount()];
        int enumerate = threadGroup.enumerate(threads);
        System.out.println("enumerate = " + enumerate);

        int enumerate1 = threadGroup.enumerate(threads, false);
        System.out.println("enumerate1 = " + enumerate1);
    }
}
