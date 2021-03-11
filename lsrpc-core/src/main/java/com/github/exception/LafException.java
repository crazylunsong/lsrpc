package com.github.exception;

/**
 * <p>date : 2021/3/11 14:25</p>
 * description: 异常基类
 *
 * @author : crazy_lunsong
 * @version : 1.0
 */
public class LafException extends RuntimeException {

    /**
     * 错误码
     */
    protected String errorCode;

    /**
     * 是否进行重试
     */
    protected Boolean retry = Boolean.FALSE;

    public LafException() {
    }

    public LafException(boolean retry) {
        this.retry = retry;
    }

    public LafException(String message) {
        super(message);
    }

    public LafException(String message, boolean retry) {
        super(message);
        this.retry = retry;
    }

    public LafException(String message, String errorCode, boolean retry) {
        super(message);
        this.errorCode = errorCode;
        this.retry = retry;
    }

    public LafException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public LafException(String message, Throwable cause) {
        super(message, cause);
    }

    public LafException(String message, Throwable cause, boolean retry) {
        super(message, cause);
        this.retry = retry;
    }

    public LafException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public LafException(String message, Throwable cause, String errorCode, boolean retry) {
        super(message, cause);
        this.errorCode = errorCode;
        this.retry = retry;
    }

    public LafException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode, boolean retry) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorCode = errorCode;
        this.retry = retry;
    }

    public LafException(Throwable cause) {
        super(cause);
    }

    public LafException(Throwable cause, boolean retry) {
        super(cause);
        this.retry = retry;
    }

    public LafException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public LafException(Throwable cause, String errorCode, boolean retry) {
        super(cause);
        this.errorCode = errorCode;
        this.retry = retry;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    /**
     * 是否可重试
     *
     * @return 是否可重试
     */
    public boolean isRetry() {
        return retry != null && retry;
    }
}

