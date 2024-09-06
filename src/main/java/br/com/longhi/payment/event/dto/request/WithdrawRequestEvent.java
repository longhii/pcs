package br.com.longhi.payment.event.dto.request;

public class WithdrawRequestEvent extends RequestEvent {
    private String origin;
    private int amount;

    public WithdrawRequestEvent(String origin, int amount) {
        this.origin = origin;
        this.amount = amount;
    }

    public WithdrawRequestEvent() {

    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
