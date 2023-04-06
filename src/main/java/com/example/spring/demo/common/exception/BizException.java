
package com.example.spring.demo.common.exception;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class BizException extends RuntimeException {
    protected IBizExceptionCode code;
    private boolean haveExtraMsg = false;
    private String[] args;
    private String errCode;
    private String errMsg;

    public static BizException of(IBizExceptionCode code) {
        BizException bizException = new BizException(code, new String[0]);
        return bizException;
    }

    public BizException(BizException e) {
        super(e);
        this.code = e.getCode();
    }

    public BizException(String errCode, String errMsg) {
        super(errMsg);
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public BizException(int errCode, String errMsg) {
        super(errMsg);
        this.errCode = String.valueOf(errCode);
        this.errMsg = errMsg;
    }

    public BizException(IBizExceptionCode code, String... args) {
        super(code.getDescription());
        this.args = args;
        this.code = code;
    }

    public BizException(IBizExceptionCode code, String errorMessage) {
        super(errorMessage);
        this.haveExtraMsg = true;
        this.code = code;
        this.errMsg = StringUtils.isNotBlank(errorMessage) ? errorMessage : code.getDescription();
    }

    public BizException(IBizExceptionCode code, Throwable cause) {
        super(code.getDescription(), cause);
        this.haveExtraMsg = true;
        this.code = code;
    }

    public BizException(IBizExceptionCode code, String errorMessage, Throwable cause) {
        super(errorMessage, cause);
        this.haveExtraMsg = true;
        this.code = code;
    }

    public final String toString() {
        String s = this.getClass().getName();
        String message = this.getLocalizedMessage();
        return s + ": " + (Objects.nonNull(this.code) ? this.code.getCode() : this.errCode) + "[" + message + "]。";
    }

    public final String getMessage() {
        if (this.haveExtraMsg) {
            return super.getMessage();
        } else {
            return Objects.nonNull(this.errMsg) && Objects.isNull(this.code) ? this.errMsg : this.code.getDescription();
        }
    }

    public IBizExceptionCode getCode() {
        return this.code;
    }

    public void setCode(IBizExceptionCode code) {
        this.code = code;
    }

    public boolean isHaveExtraMsg() {
        return this.haveExtraMsg;
    }

    public String[] getArgs() {
        return this.args;
    }

    public String getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }
}
