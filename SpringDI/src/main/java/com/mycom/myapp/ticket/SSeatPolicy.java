package com.mycom.myapp.ticket;

import org.springframework.stereotype.Component;

@Component("s")
public class SSeatPolicy implements SeatPolicy {
    public int getPrice() { return 70000; }
    public String getBenefits() { return "후방 좌석"; }
}