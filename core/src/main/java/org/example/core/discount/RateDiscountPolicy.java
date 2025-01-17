package org.example.core.discount;

import org.example.core.member.Grade;
import org.example.core.member.Member;

public class RateDiscountPolicy implements DisCountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
