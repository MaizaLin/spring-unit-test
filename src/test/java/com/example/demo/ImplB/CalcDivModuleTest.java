/*
 * Copyright 2020 tuhu.cn All right reserved. This software is the
 * confidential and proprietary information of tuhu.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Tuhu.cn
 */
package com.example.demo.ImplB;


import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;
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
public class CalcDivModuleTest {

    @Autowired
    @Qualifier("CalcDivModule")
    CalcDivModule calcModule;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    @DisplayName("测试整数")
    public void TestInteger() {
        Assert.assertTrue(calcModule.calc(1D,2D).equals(0.5));
    }

    @Test
    @DisplayName("测试浮点")
    public void TestDouble() {
        Assert.assertTrue(calcModule.calc(1.1,2.2).equals(0.5));
    }

    @Test
    @DisplayName("测试正数")
    public void TestPositive() {
        Assert.assertTrue(calcModule.calc(1D,4D).equals(0.25));
    }

    @Test
    @DisplayName("测试负数")
    public void TestNegative() {
        Assert.assertTrue(calcModule.calc(-1D,-8D).equals(0.125D));
    }

    @Test
    @DisplayName("被除数为0测试")
    public void Test1() {

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("被除数不能为0");

        calcModule.calc(0D, 2D);
    }

}