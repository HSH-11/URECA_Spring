package com.mycom.myapp.ticket;

import org.springframework.stereotype.Component;

@Component("r")
public class RSeatPolicy implements SeatPolicy {
    public int getPrice() { return 100000; }
    public String getBenefits() { return "중앙 좌석"; }
}