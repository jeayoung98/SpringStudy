package org.example.core.order;

import org.example.core.discount.DisCountPolicy;
import org.example.core.discount.FixDiscountPolicy;
import org.example.core.member.Member;
import org.example.core.member.MemberRepository;
import org.example.core.member.MemoryMemberRepository;

public class OderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DisCountPolicy disCountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = disCountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
