package br.com.longhi.payment.event.dto.response;

import br.com.longhi.payment.account.model.Account;

public class TransferResponseEvent implements ResponseEvent {
    private Account origin;
    private Account destination;

    public TransferResponseEvent(Account origin, Account destination) {
        this.origin = origin;
        this.destination = destination;
    }

    public TransferResponseEvent() {

    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }
}
