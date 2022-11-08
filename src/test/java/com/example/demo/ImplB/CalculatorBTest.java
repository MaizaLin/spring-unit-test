/*
 * Copyright 2020 aaa.cn All right reserved. This software is the
 * confidential and proprietary information of aaa.cn ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with aaa.cn
 */
package com.example.demo.ImplB;

import com.example.demo.Calculator;
import com.example.demo.OperatorEnum;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

/**
 * @author Linyunqi
 * @date 2020/11/220:46
 */

@RunWith(SpringRunner.class)
@SpringBootTest()
public class CalculatorBTest {

    @Autowired
    @Qualifier("CalculatorB")
    Calculator calculator;

    @MockBean
    CalcAddModule calcAddModule;

    @MockBean
    CalcSubModule calcSubModule;

    @MockBean
    CalcMultiModule calcMultiModule;

    @MockBean
    CalcDivModule calcDivModule;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Before
    public void Init() {

        when(this.calcAddModule.calc(1D,1D)).thenReturn(2D);
        when(this.calcSubModule.calc(1D,1D)).thenReturn(0D);
        when(this.calcMultiModule.calc(2D,2D)).thenReturn(4D);
        when(this.calcDivModule.calc(1D,1D)).thenReturn(1D);
    }

    @Test
    public void Test() {

        Assert.assertTrue(calculator.execute(1D, 1D, OperatorEnum.Add.toString()).equals(2D));
        Assert.assertTrue(calculator.execute(1D, 1D, OperatorEnum.Sub.toString()).equals(0D));
        Assert.assertTrue(calculator.execute(2D, 2D, OperatorEnum.Multi.toString() ).equals(4D));
        Assert.assertTrue(calculator.execute(1D, 1D, OperatorEnum.Div.toString() ).equals(1D));
    }

    @Test
    public void Test1() {

        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("不支持的操作类型");

        calculator.execute(2D, 2D, "not-exist");
    }


}