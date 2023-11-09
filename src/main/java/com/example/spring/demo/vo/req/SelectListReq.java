package com.example.spring.demo.vo.req;

import com.example.spring.demo.common.bo.BaseReq;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author weizhao.dong
 * @Date 2023/4/6 22:27
 * @Version 1.0
 */
@Data
@NoArgsConstructor
public class SelectListReq extends BaseReq {
    private String username;
}
