package org.example.core.discount;

import org.example.core.member.Grade;
import org.example.core.member.Member;

public class FixDiscountPolicy implements DisCountPolicy {

    private int discountFixAmount = 1000; // 1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        }
        return 0;
    }
}
