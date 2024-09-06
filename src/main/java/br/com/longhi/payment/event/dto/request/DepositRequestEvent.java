package br.com.longhi.payment.event.dto.request;

public class DepositRequestEvent extends RequestEvent {
    private String destination;
    private int amount;

    public DepositRequestEvent(String destination, int amount) {
        this.destination = destination;
        this.amount = amount;
    }

    public DepositRequestEvent() {

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
