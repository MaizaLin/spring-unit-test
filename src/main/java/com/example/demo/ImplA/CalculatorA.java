/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo.ImplA;


import com.example.demo.Calculator;
import com.example.demo.OperatorEnum;
import org.springframework.stereotype.Component;

/**
 * @author Linyunqi
 * @date 2020/11/214:13
 */

@Component("CalculatorA")
public class CalculatorA implements Calculator {

    @Override
    public Double execute(Double num1, Double num2, String operator) {

        OperatorEnum operatorEnum = OperatorEnum.getOperator(operator);

        if(operatorEnum == null) {
            throw new IllegalArgumentException("不支持的操作类型");
        }

        if(operatorEnum.equals(OperatorEnum.Add)) {
            return num1 + num2;
        } else if(operatorEnum.equals(OperatorEnum.Sub)) {
            return num1 - num2;
        } else if(operatorEnum.equals(OperatorEnum.Multi)) {
            return num1 * num2;
        } else if(operatorEnum.equals(OperatorEnum.Div)) {
            if(num1.equals(0D)) {
                throw new IllegalArgumentException("被除数不能为0");
            }
            return num1 / num2;
        }

        throw new IllegalArgumentException("不支持的操作类型");
    }
}