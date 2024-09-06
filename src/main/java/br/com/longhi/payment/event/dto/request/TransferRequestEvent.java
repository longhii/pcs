package br.com.longhi.payment.event.dto.request;

public class TransferRequestEvent extends RequestEvent {
    private String origin;
    private String destination;
    private int amount;

    public TransferRequestEvent(String origin, String destination, int amount) {
        this.origin = origin;
        this.destination = destination;
        this.amount = amount;
    }

    public TransferRequestEvent() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
