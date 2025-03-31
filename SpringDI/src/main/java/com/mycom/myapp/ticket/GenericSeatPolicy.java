package com.mycom.myapp.ticket;

import org.springframework.stereotype.Component;

@Component("vip")
public class GenericSeatPolicy implements SeatPolicy {
	private final int price = 150000;
	private final String benefits = "최전방 좌석 + 싸인회 참여";

	public int getPrice() {
		return price;
	}

	public String getBenefits() {
		return benefits;
	}

}
