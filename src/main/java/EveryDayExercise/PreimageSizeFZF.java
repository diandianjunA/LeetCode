package EveryDayExercise;

import java.math.BigDecimal;
import java.math.BigInteger;

//f(x)是x!末尾是 0 的数量。回想一下x! = 1 * 2 * 3 * ... * x，且 0! = 1。
//
//例如，f(3) = 0，因为 3! = 6 的末尾没有 0 ；而 f(11) = 2，因为 11!= 39916800 末端有 2 个 0 。
//给定k，找出返回能满足 f(x) = k的非负整数 x的数量。
public class PreimageSizeFZF {
//    //我的解法(未完成)
//    class Solution {
//        public int preimageSizeFZF(int k) {
//
//        }
//        public BigInteger factorial(int x){
//            BigInteger result= BigInteger.valueOf(1);
//            for (int i = 1; i <= x; i++) {
//                result=result.multiply(BigInteger.valueOf(i));
//            }
//            return result;
//        }
//        public int f(BigInteger x){
//            int j=0;
//            while(x.mod(BigInteger.valueOf(5)).equals(0)){
//                x.divide(BigInteger.valueOf(5));
//                j++;
//            }
//            return j;
//        }
//    }

    //大佬解法
    /**
 *     思路：
 *     10进制中只有2和5相乘才会得到10，也就是每有一对2和5，就多一个末尾的0
 *
 *     而阶乘又是从1开始乘到x，所以2的个数总是比5多，那么问题转化为求x！中有多少个5作为因子
 *
 *     公式为 k = x/5 + x/5^2 + x/5^3 + ......
 *     根据上面的公式，x/5 + x/5^2 + x/5^3 + ...... = k
 *
 *     => x/5 < k <=10^9
 *
 *     => x < 5 * 10^9 容易想到在[0, 5*k]内二分求解x
 *     显然，x每+5，阶乘就会至少多乘一个5，末尾就会至少多一个0，所以如果上面的x有解，那就是5个，如果无解就是0
     */
    class SolutionPro {
        /**
         * 高阶解法
         *
         * 按照数据规律求解
         * 阶乘
         * 1个5      5   1
         * 2个5 =    25  6   实际相当于 5个1个5，然后再加25自身是两个5，所以得到的是 5+1 = 6
         * 3个5 =    125 31  相当于5个25，然后加自身125又多了一个5 所以的（5+1）*5+1=31
         * 按照这个规律，则后续公式可以f(2)=f(1)*5+1 f(1)=1 则 f(x+1) = f(x)*5+1  x是5的次幂数
         *
         * @param K
         * @return
         */
        public int preimageSizeFZF(int K) {
            //确定阶梯值范围 最终的到的K < start
            int start = 1;
            while (start < K){
                start = start*5+1;
            }

            //确定范围后，执行精确查找
            while (start > 1){
                //只有5以下阶乘才会出现start-1成立，其它情况不会存在，因为任何一个阶段分界值都会包含一个以上的5
                if(start-1 == K){
                    //不存在的返回0
                    return 0;
                }

                //逆推下一个阶梯值 从f(x+1) 推导出f(x)
                start=(start-1)/5;

                //获取剩余值，进行下一阶梯运算
                K%=start;
            }

            //只要存在，必然是5个
            return 5;
        }
    }
}
