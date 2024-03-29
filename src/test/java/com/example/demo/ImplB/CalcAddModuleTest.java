/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo.ImplB;

import com.example.demo.CalcModule;
import com.example.demo.OperatorEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Linyunqi
 * @date 2020/11/216:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class CalcAddModuleTest {

    @Autowired
    @Qualifier("CalcAddModule")
    CalcModule calcModule;


    @Test
    @DisplayName("测试整数")
    public void TestInteger() {
        Assert.assertTrue(calcModule.calc(1D,2D).equals(3D));
    }

    @Test
    @DisplayName("测试浮点")
    public void TestDouble() {
        Assert.assertTrue(calcModule.calc(1.1,2.3).equals(3.4));
    }

    @Test
    @DisplayName("测试正数")
    public void TestPositive() {
        Assert.assertTrue(calcModule.calc(1D,2D).equals(3D));
    }

    @Test
    @DisplayName("测试负数")
    public void TestNegative() {
        Assert.assertTrue(calcModule.calc(-1D,-2D).equals(-3D));
    }



}