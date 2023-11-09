package com.example.spring.demo.common.bo;

import com.example.spring.demo.common.exception.IBizExceptionCode;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * 响应对象
 *
 * @param { "success":true,
 *          "errorCode":null,
 *          "errorMsg":null,
 *          "pagination":{
 *          "current":1,
 *          "pageSize":10,
 *          "pages": xx //总页数(total/pageSize)
 *          "total":xxxx //总条数
 *          },
 *          "result":[],
 *          "traceId":"",//链路ID,为了排查问题是用
 *          "timestamp":xxx
 *          }
 */
@Data
@Slf4j
public class RespData<T> implements Serializable {

    private static final int SUCCESS_RESP_CODE = 0;
    private static final int FAIL_RESP_CODE = 1;
    private static final String SUCCESS_MSG = "success";

    /**
     * 状态码
     */
    private int status;

    private String code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;
    /**
     * 分页组件
     */
    private PageResult pagination;


    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 链路追踪id
     */
    private String traceId;
    /**
     * 时间戳
     */
    private long timestamp;

    public RespData() {
    }

    private RespData(int status, String msg) {
        this.status = status;
        this.msg = msg;
        this.timestamp = System.currentTimeMillis();
    }

    private RespData(int status, String code, String msg) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        this.timestamp = System.currentTimeMillis();
    }


    private RespData(int status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        convertData(data, this);
        this.timestamp = System.currentTimeMillis();
    }


    private RespData(int status, String code, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.code = code;
        convertData(data, this);
        this.timestamp = System.currentTimeMillis();
    }

    public static RespData of(IBizExceptionCode code) {
        return new RespData(FAIL_RESP_CODE, code.getCode(), code.getDescription());
    }


    public static RespData of(IBizExceptionCode code, Object data) {
        return new RespData(FAIL_RESP_CODE, code.getCode(), code.getDescription(), data);
    }

    public static RespData of(IBizExceptionCode code, String extMsg, Object data) {
        return new RespData(FAIL_RESP_CODE, code.getCode(), buildMsg(code, extMsg), data);
    }

    public static RespData of(String code, String msg, String extMsg) {
        return new RespData(FAIL_RESP_CODE, code, buildMsg(msg, extMsg), null);
    }

    public static RespData of(String code, String msg) {
        return new RespData(FAIL_RESP_CODE, code, msg, null);
    }


    public static RespData of(int status, String msg, Object data) {
        return new RespData(status, msg, data);
    }

    public static RespData success(Object data) {
        RespData resp = new RespData(SUCCESS_RESP_CODE, SUCCESS_MSG);
        resp.convertData(data, resp);
        return resp;
    }

    private void convertData(Object data, RespData resp) {
        resp.setData(data);
    }

    public static RespData success() {
        RespData resp = new RespData(SUCCESS_RESP_CODE, SUCCESS_MSG);
        return resp;
    }

    private static String buildMsg(IBizExceptionCode code, String extMsg) {
        return code.getMessage() + ". " + StringUtils.defaultString(extMsg);
    }

    private static String buildMsg(String msg, String extMsg) {
        return msg + ". " + StringUtils.defaultString(extMsg);
    }

    public boolean isSuccess() {
        log.info("respCode={} traceId={}", this.status, traceId);
        return SUCCESS_RESP_CODE == this.status;
    }


    public int getCode() {
        return this.status;
    }

    public String getMsg() {
        return this.msg;
    }

    public Object getData() {
        return this.data;
    }


    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class PageResult {
        private static final long serialVersionUID = 676226419039421871L;
        //总条数
        private long total;
        //页大小
        private long pageSize;
        //当前第几页
        private long page;
        // 总页数
        private long pages;

        public static PageResult convert(QueryResult q) {
            PageResult pageResult = new PageResult();
            BeanUtils.copyProperties(q, pageResult);
            return pageResult;
        }
    }
}