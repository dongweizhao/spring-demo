package com.example.spring.demo.vo.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author weizhao.dong
 * @Date 2023/6/25 17:14
 * @Version 1.0
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetTenantInfoResp {
    /**
     * 园区编码
     */
    private String name;
}
