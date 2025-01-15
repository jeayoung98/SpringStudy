package org.example.core.discount;

import org.example.core.member.Member;

public interface DisCountPolicy {

    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
