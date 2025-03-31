package com.mycom.myapp.ticket;

import org.springframework.context.support.ClassPathXmlApplicationContext;

// 좌석별 티켓팅 시스템을 3가지 DI 전략을 사용해보자
public class TicketMain {

	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("xml/ticket-annotation.xml");
        TicketService service = context.getBean(TicketService.class);
        service.issueAllTickets();
        
	}

}
