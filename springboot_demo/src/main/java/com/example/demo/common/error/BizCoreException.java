package com.example.demo.common.error;

import com.example.demo.common.core.biz.ErrorCode;

/**
 * @author SanKai
 * @since 2019-11-06
 */
public class BizCoreException extends RuntimeException {
    private ErrorCode code = ErrorCode.SYSTEM_EXCEPTION;


    /**
     * 构造方法
     */
    public BizCoreException(String message) {
        super(message);
    }

    /**
     * 构造方法
     */
    public BizCoreException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }


    /**
     * 构造方法
     */
    public BizCoreException(ErrorCode code) {
        super(code.getDescription());
        this.code = code;
    }

    /**
     * 构造方法
     */
    public BizCoreException(ErrorCode code,String message) {
        super(message);
        this.code = code;
    }
    /**
     * 构造方法
     */
    public BizCoreException(String message, Throwable e) {
        super(message, e);
    }

    /**
     * 构造方法
     */
    public BizCoreException(String message, ErrorCode code, Throwable e) {
        super(message, e);
        this.code = code;
    }

    /**
     * 构造方法
     */
    public BizCoreException(Throwable e) {
        super(e);
    }

    /**
     * 构造方法
     */
    public BizCoreException(ErrorCode code, Throwable e) {
        super(e);
        this.code = code;
    }

    public ErrorCode getCode() {
        return code;
    }

    public void setCode(ErrorCode code) {
        this.code = code;
    }
}
