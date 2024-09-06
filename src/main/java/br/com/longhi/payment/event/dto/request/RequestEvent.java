package br.com.longhi.payment.event.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = DepositRequestEvent.class, name = "deposit"),
        @JsonSubTypes.Type(value = WithdrawRequestEvent.class, name = "withdraw"),
        @JsonSubTypes.Type(value = TransferRequestEvent.class, name = "transfer")
})
public abstract class RequestEvent {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
