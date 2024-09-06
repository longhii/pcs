package br.com.longhi.payment.event.dto.response;

import br.com.longhi.payment.account.model.Account;

public class DepositResponseEvent implements ResponseEvent {
    private Account destination;

    public DepositResponseEvent(Account destination) {
        this.destination = destination;
    }

    public DepositResponseEvent() {
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }
}
