package com.github.lsrpc;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * <p>date : 2021/3/11 14:19</p>
 * description: 泛化调用接口，由于没有目标类，复杂参数对象采用Map进行传输，泛型调用不会出现Callback
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
public interface GenericService {
    default Object invoke(String method, String[] parameterTypes, Object[] args) {
        try {
            async(method, parameterTypes, args).get(Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (ExecutionException e) {
            Throwable throwable = e.getCause() == null ? e : e.getCause();
            if (throwable instanceof) {

            }
        }
    }

    CompletedFuture<?> async(String method, String[] parameterTypes, Object[] args);
}
