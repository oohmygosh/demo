package com.vipicu.demo.boot.advice;

/**

 * ----------------------------------------
 * REST API 错误码接口
 *
 * @author oohmygosh
 * @since 2021-10-28
 */
public interface IErrorCode {
    /**
     * 错误编码 -1、失败 0、成功
     */
    long getCode();

    /**
     * 错误描述
     */
    String getMsg();
}
