package com.common.observer;

public interface HeartBeatObserver {
    /**
     * 添加观察者
     */
    void registerObserver(BindObserver observer);
    /**
     * 删除观察者
     */
    void removeObserver(BindObserver observer);
    /**
     * 通知观察者
     */
    void notifyObserver();
}
