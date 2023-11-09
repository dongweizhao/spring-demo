package com.example.spring.demo.common.bo;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseReq implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer pageSize = 10;
    private Integer current = 1;
}
