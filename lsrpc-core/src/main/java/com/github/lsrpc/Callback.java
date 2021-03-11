package com.github.lsrpc;

/**
 * <p>date : 2021/3/11 14:14</p>
 * description: 回调函数，保持兼容
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
@FunctionalInterface
public interface Callback<Q, S> extends CallbackListener {

    /**
     * 回调通知
     *
     * @param result 通知对象
     * @return 返回值对象
     */
    S notify(Q result);
}
