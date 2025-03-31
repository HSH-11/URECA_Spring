package com.mycom.myapp.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TicketService {
	@Autowired
	@Qualifier("r")
	private SeatPolicy fieldPolicy;
	
	private SeatPolicy constructorPolicy;
	
	private SeatPolicy setterPolicy;

	@Autowired
	public TicketService(@Qualifier("vip") SeatPolicy constructorPolicy) {
		this.constructorPolicy = constructorPolicy;
	}

	@Autowired
	public void setSetterPolicy(@Qualifier("s") SeatPolicy setterPolicy) {
		this.setterPolicy = setterPolicy;
	}

	public void issueAllTickets() {
		System.out.println("[필드 DI 티켓]");
		if (fieldPolicy != null)
			printTicket(fieldPolicy);

		System.out.println("[생성자 DI 티켓]");
		if (constructorPolicy != null)
			printTicket(constructorPolicy);

		System.out.println("[세터 DI 티켓]");
		if (setterPolicy != null)
			printTicket(setterPolicy);
	}

	private void printTicket(SeatPolicy policy) {
		System.out.println("가격: " + policy.getPrice() + "원");
		System.out.println("혜택: " + policy.getBenefits());
	}
}
