package com.unipi.e16095_assignment.enums;

public enum TicketTypeEnum {

    SOFTWARE(0),
    HARDWARE(1),
    SYSTEM_ACCESS(2),
    NET_ACCESS(3);

    private int ticketSeverity;

    TicketTypeEnum(int ticketSeverity) {
        this.ticketSeverity = ticketSeverity;
    }

    public int getTicketSeverity() {
        return ticketSeverity;
    }

    public void setTicketSeverity(int ticketSeverity) {
        this.ticketSeverity = ticketSeverity;
    }
}
