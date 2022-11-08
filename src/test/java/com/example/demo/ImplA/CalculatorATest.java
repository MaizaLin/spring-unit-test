/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo.ImplA;

import com.example.demo.Calculator;
import com.example.demo.ImplB.CalculatorB;
import com.example.demo.OperatorEnum;
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
 * @date 2020/11/214:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest()
public class CalculatorATest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    @Qualifier("CalculatorA")
    Calculator calculator;


    @Test
    @DisplayName("测试加法")
    public void TestAdd() {
        Assert.assertTrue(calculator.execute(1D,2D, OperatorEnum.Add.toString()).equals(3D));
        Assert.assertTrue(calculator.execute(-1D,2D, OperatorEnum.Add.toString()).equals(1D));
        Assert.assertTrue(calculator.execute(-1D,-1D, OperatorEnum.Add.toString()).equals(-2D));
        Assert.assertTrue(calculator.execute(0D,0D, OperatorEnum.Add.toString()).equals(0D));
    }

    @Test
    @DisplayName("测试减法")
    public void TestSub() {
        Assert.assertTrue(calculator.execute(1D,2D, OperatorEnum.Sub.toString()).equals(-1D));
        Assert.assertTrue(calculator.execute(5D,2D, OperatorEnum.Sub.toString()).equals(3D));
        Assert.assertTrue(calculator.execute(-1D,-1D, OperatorEnum.Sub.toString()).equals(0D));
        Assert.assertTrue(calculator.execute(0D,0D, OperatorEnum.Sub.toString()).equals(0D));
    }

    @Test
    @DisplayName("测试乘法")
    public void TestMuti() {
        Assert.assertTrue(calculator.execute(0D,2D, OperatorEnum.Multi.toString()).equals(0D));
        Assert.assertTrue(calculator.execute(-1D,2D, OperatorEnum.Multi.toString()).equals(-2D));
        Assert.assertTrue(calculator.execute(-1D,-1D, OperatorEnum.Multi.toString()).equals(1D));
        Assert.assertTrue(calculator.execute(0D,0D, OperatorEnum.Multi.toString()).equals(0D));
    }

    @Test
    @DisplayName("测试除法异常")
    public void TestDivException() {

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("不支持的操作类型");

        calculator.execute(2D, 2D, "not-exist");
    }

    @Test
    @DisplayName("测试除法")
    public void TestDiv() {
        Assert.assertTrue(calculator.execute(-1D,2D, OperatorEnum.Div.toString()).equals(-0.5));
        Assert.assertTrue(calculator.execute(-1D,-1D, OperatorEnum.Div.toString()).equals(1D));
        Assert.assertTrue(calculator.execute(100D,10D, OperatorEnum.Div.toString()).equals(10D));
    }

}