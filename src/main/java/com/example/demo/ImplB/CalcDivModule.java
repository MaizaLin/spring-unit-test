/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo.ImplB;

import com.example.demo.CalcModule;
import org.springframework.stereotype.Component;

/**
 * @author Linyunqi
 * @date 2020/11/215:24
 */

@Component("CalcDivModule")
public class CalcDivModule implements CalcModule {

    @Override
    public Double calc(Double num1, Double num2) {
        if(num1.equals(0D)) {
            throw new IllegalArgumentException("被除数不能为0");
        }
        return num1 / num2;
    }
}