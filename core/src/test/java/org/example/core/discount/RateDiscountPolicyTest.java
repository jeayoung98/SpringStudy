package org.example.core.discount;

import org.assertj.core.api.Assertions;
import org.example.core.member.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RateDiscountPolicyTest {

    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        // given
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        memberService.join(member);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x() {
        // given
        Member member = new Member(2L, "memberBASIC", Grade.BASIC);
        memberService.join(member);

        // when
        int discount = rateDiscountPolicy.discount(member, 10000);

        // then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}