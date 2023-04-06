//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.spring.demo.common.exception;

public enum BizExceptionCode implements IBizExceptionCode {
    AES_ENCRYPT_ERROR("100001", "AES加密失败"),
    AES_DECRYPT_ERROR("100002", "AES解密失败"),
    FEIGN_DECODE_ERROR("100004", "feign decode error"),
    ILLEGAL_ARGUMENT("100005", "参数异常"),
    SEND_MQ_ERROR("100006", "发送MQ消息异常"),
    CONSUMER_MQ_ERROR("100007", "消费MQ消息异常"),
    SAVE_MQ_ERROR("100008", "保存MQ消息异常"),
    REPOSITORY_INIT_COLUMN_ERROR("100009", "初始化REPOSITORY关联PO属性失败"),
    REPOSITORY_GET_FIELD_VALUE_ERROR("100010", "获取REPOSITORY关联PO属性值失败"),
    FEIGN_INVOKE_ERROR("100011", "feign invoke error"),
    MQ_TYPE_CONVERT_ERROR("100012", "消息类型转换异常"),
    CONSUMER_CUSTOMIZE_MQ_ERROR("1000013", "消费自定义MQ消息异常"),
    CONSUMER_NATIVE_MQ_ERROR("1000014", "消费自定义MQ消息异常"),
    QUERY_RESULT_TYPE_CONVERT_ERROR("1000015", "分页对象转换异常"),
    DATA_PARSE_ERROR("1000016", "数据转换异常"),
    SYSCODE_IS_NULL("900000", "syscode is null"),
    USER_AUTH_ERROR("900001", "user auth error"),
    VALID_TOKEN_ERROR("900002", "valid token error"),
    GET_TOKEN_ERROR("900003", "get token error"),
    SYSTEM_BLOCK_ERROR("999998", "system blocked"),
    SERVER_ERROR("999999", "server error");

    private String prefix = "";
    private String code;
    private String description;

    private BizExceptionCode(String code, String description) {
        this.code = this.prefix + code;
        this.description = description;
    }

    public static BizExceptionCode getByCode(String code) {
        BizExceptionCode[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            BizExceptionCode scenario = var1[var3];
            if (scenario.getCode().equals(code)) {
                return scenario;
            }
        }

        return null;
    }

    public String getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public String getMessage() {
        return this.getClass().getName() + '.' + this.name();
    }

    public String toString() {
        return "BizExceptionCode(prefix=" + this.prefix + ", code=" + this.getCode() + ", description=" + this.getDescription() + ")";
    }
}
