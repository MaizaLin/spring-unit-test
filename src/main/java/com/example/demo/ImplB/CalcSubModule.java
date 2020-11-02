/*
 * Copyright 2020 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.example.demo.ImplB;

import com.example.demo.CalcModule;
import org.springframework.stereotype.Component;

/**
 * @author Linyunqi
 * @date 2020/11/215:06
 */

@Component("CalcSubModule")
public class CalcSubModule implements CalcModule {

    @Override
    public Double calc(Double num1, Double num2) {
        return num1 - num2;
    }
}