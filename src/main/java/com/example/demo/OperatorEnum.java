/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo;

import lombok.Data;
import lombok.Getter;

/**
 * @author Linyunqi
 * @date 2020/11/214:17
 */

@Getter
public enum  OperatorEnum {

    Add("CalcAddModule"),
    Sub("CalcSubModule"),
    Multi("CalcMultiModule"),
    Div("CalcDivModule");

    private String beanName;

    OperatorEnum(String beanName) {
        this.beanName = beanName;
    }

    public static OperatorEnum getOperator( String name) {
        for( OperatorEnum item : OperatorEnum.values()) {
            if(item.name().equals(name)) {
                return item;
            }
        }

        return null;
    }
}