package com.vipicu.demo.boot.entity;

import com.vipicu.demo.boot.advice.ApiErrorCode;
import com.vipicu.demo.boot.advice.IErrorCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Optional;

/**
 * api结果
 *
 * @author oohmygosh
 * @since 2023/03/13
 */
@Getter
@Setter
@Accessors(chain = true)
public class ApiResult<T> implements Serializable {
    /**
     * serialVersionUID
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * 业务错误码
     */
    private long code;
    /**
     * 结果集
     */
    private T data;
    /**
     * 描述
     */
    private String message;

    public ApiResult() {
        // to do nothing
    }

    public ApiResult(IErrorCode errorCode) {
        errorCode = Optional.ofNullable(errorCode).orElse(ApiErrorCode.FAILED);
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public static <T> ApiResult<T> ok(T data) {
        ApiErrorCode aec = ApiErrorCode.SUCCESS;
        if (data instanceof Boolean && Boolean.FALSE.equals(data)) {
            aec = ApiErrorCode.FAILED;
        }
        return result(data, aec.getCode(), aec.getMsg());
    }

    public static <T> ApiResult<T> failed(String msg) {
        return result(null, ApiErrorCode.FAILED.getCode(), msg);
    }

    public static <T> ApiResult<T> failed(IErrorCode errorCode) {
        return result(null, errorCode);
    }

    public static <T> ApiResult<T> result(T data, IErrorCode errorCode) {
        return result(data, errorCode.getCode(), errorCode.getMsg());
    }

    private static <T> ApiResult<T> result(T data, long code, String message) {
        ApiResult<T> apiResult = new ApiResult<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMessage(message);
        return apiResult;
    }
}
