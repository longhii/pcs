package br.com.longhi.payment.event.dto.response;

import br.com.longhi.payment.account.model.Account;

public class WithdrawResponseEvent implements ResponseEvent{
    private Account origin;

    public WithdrawResponseEvent(Account origin) {
        this.origin = origin;
    }

    public WithdrawResponseEvent() {

    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }
}
