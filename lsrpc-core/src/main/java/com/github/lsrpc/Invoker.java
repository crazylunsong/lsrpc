package com.github.lsrpc;


import com.github.lsrpc.protocol.message.Invocation;

import java.util.concurrent.CompletableFuture;

/**
 * 调用器
 *
 */
@FunctionalInterface
public interface Invoker {

    /**
     * 调用
     *
     * @param request 请求
     * @return
     */
    CompletableFuture<Result> invoke(RequestMessage<Invocation> request);

    /**
     * 初始化请求
     *
     * @param request 请求
     */
    default void setup(final RequestMessage<Invocation> request) {

    }

    /**
     * 关闭
     *
     * @return
     */
    default CompletableFuture<Void> close() {
        Parametric parametric = new MapParametric(GlobalContext.getContext());
        return close(parametric.getBoolean(Constants.GRACEFULLY_SHUTDOWN_OPTION));
    }

    /**
     * 关闭
     *
     * @param gracefully 是否优雅关闭
     * @return
     */
    default CompletableFuture<Void> close(boolean gracefully) {
        return CompletableFuture.completedFuture(null);
    }

    /**
     * 名称
     *
     * @return
     */
    default String getName() {
        return null;
    }

}
