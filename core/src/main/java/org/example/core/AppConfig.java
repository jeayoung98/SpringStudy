package org.example.core;

import org.example.core.discount.DisCountPolicy;
import org.example.core.discount.FixDiscountPolicy;
import org.example.core.discount.RateDiscountPolicy;
import org.example.core.member.MemberService;
import org.example.core.member.MemberServiceImpl;
import org.example.core.member.MemoryMemberRepository;
import org.example.core.order.OrderService;
import org.example.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(),disCountPolicy());
    }

    @Bean
    public DisCountPolicy disCountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

}
