package com.dhrs.base.algorithm;

import com.alibaba.fastjson.JSON;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test {


    public static void main(String[] args) {
        System.out.println(String.format("%03d", 44));

        BigDecimal amount = new BigDecimal("678");
        int abc = 678; // 假设abc为123
        int bc = abc % 100; // 获取bc，使用&运算符和0xFF掩码
        int a = 6;
        int b = 6;
        int c = bc % 10; // 获取c，使用%运算符取余数

        System.out.println(bc);
        System.out.println(c);
        // 所有数字
        List<BigDecimal> list = new ArrayList<>();
        // 100以下
        List<BigDecimal> precisionList = new ArrayList<>();
        // 100及以上
        List<BigDecimal> blurList = new ArrayList<>();
        list.add(new BigDecimal(188));
        list.add(new BigDecimal(78));
        list.add(new BigDecimal(99));
        list.add(new BigDecimal(278));
        list.add(new BigDecimal(578));
        list.add(new BigDecimal(568));
        list.add(new BigDecimal(678));
        // 过滤3位数以下的数据
        precisionList = list.stream().filter(e -> e.compareTo(new BigDecimal(100)) < 0).collect(Collectors.toList());
        blurList = list.stream().filter(e -> e.compareTo(new BigDecimal(100)) >= 0).collect(Collectors.toList());
        // 精准匹配
        for (BigDecimal val : precisionList) {

        }

        // 模糊匹配3位数的
        List<String> blurNewList = new ArrayList<>();
        for (BigDecimal val : blurList) {
            if (val.compareTo(BigDecimal.valueOf(abc)) == 0) {
                blurNewList.add("数字：" + val + "中大奖了");
            } else {
                if (val.intValue() % 100 == abc % 100) {
                    blurNewList.add("数字：" + val + "中bc奖了");
                } else if ((val.intValue() % 100) % 10 == (abc % 100) % 10) {
                    blurNewList.add("数字：" + val + "中c奖了");
                }
            }

        }

        System.out.println("买abc三位数的中将集合："+JSON.toJSONString(blurNewList));
    }
}
