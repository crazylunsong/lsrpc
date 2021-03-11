package com.github.lsrpc;

/**
 * <p>date : 2021/3/11 14:15</p>
 * description: 回调监听器
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
public interface CallbackListener {
    /**
     * 连接断开的时候调用重新注册
     */
    default void reCallback() {
    }

    /**
     * 设置回调ID
     */
    default void setCallbackId(final String callbackId) {

    }
}
