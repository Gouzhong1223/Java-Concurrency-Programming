package com.gouzhong1223.thread.threadgroup;

import java.util.concurrent.TimeUnit;

/**
 * @Author : Gouzhong
 * @Blog : www.gouzhong1223.com
 * @Description : 线程组复制线程组
 * @Date : create by QingSong in 2020-07-31 4:05 下午
 * @Email : gouzhong1223@gmail.com
 * @Since : JDK 1.8
 * @PackageName : com.gouzhong1223.thread.threadgroup
 * @ProjectName : java concurrent programming
 * @Version : 1.0.0
 */
public class ThreadGroupEnumerateThreadGroups {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group1 = new ThreadGroup("group1");
        ThreadGroup group2 = new ThreadGroup(group1, "group2");
        TimeUnit.SECONDS.sleep(2);
        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();

        ThreadGroup[] activeThreadGroups = new ThreadGroup[mainGroup.activeGroupCount()];

        int enumerate = mainGroup.enumerate(activeThreadGroups);
        System.out.println("enumerate = " + enumerate);

        int enumerate1 = mainGroup.enumerate(activeThreadGroups, false);

        System.out.println("enumerate1 = " + enumerate1);
    }
}
