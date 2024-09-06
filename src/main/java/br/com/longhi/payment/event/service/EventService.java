package br.com.longhi.payment.event.service;

import br.com.longhi.payment.account.model.Account;
import br.com.longhi.payment.account.repository.AccountRepository;
import br.com.longhi.payment.event.dto.request.DepositRequestEvent;
import br.com.longhi.payment.event.dto.request.RequestEvent;
import br.com.longhi.payment.event.dto.request.TransferRequestEvent;
import br.com.longhi.payment.event.dto.request.WithdrawRequestEvent;
import br.com.longhi.payment.event.dto.response.DepositResponseEvent;
import br.com.longhi.payment.event.dto.response.ResponseEvent;
import br.com.longhi.payment.event.dto.response.TransferResponseEvent;
import br.com.longhi.payment.event.dto.response.WithdrawResponseEvent;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.NoSuchElementException;

@ApplicationScoped
public class EventService {

    private final AccountRepository accountRepository;

    public EventService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public ResponseEvent createEvent(RequestEvent requestEvent) throws Exception {
        if (requestEvent instanceof DepositRequestEvent e) {
            return handleDeposit(e);
        } else if (requestEvent instanceof TransferRequestEvent e) {
            return handleTransfer(e);
        } else if (requestEvent instanceof WithdrawRequestEvent e) {
            return handleWithdraw(e);
        } else {
            throw new Exception("Invalid request body for type: " + requestEvent.getType());
        }
    }

    private ResponseEvent handleDeposit(DepositRequestEvent event) {
        var account = findAccountById(event.getDestination());
        account.setBalance(account.getBalance() + event.getAmount());
        return new DepositResponseEvent(account);
    }

    private ResponseEvent handleTransfer(TransferRequestEvent event) {
        var origin = findAccountById(event.getOrigin());
        var destination = findAccountById(event.getDestination());

        origin.setBalance(origin.getBalance() - event.getAmount());
        destination.setBalance(destination.getBalance() + event.getAmount());

        return new TransferResponseEvent(origin, destination);
    }

    private ResponseEvent handleWithdraw(WithdrawRequestEvent event) {
        var account = findAccountById(event.getOrigin());
        account.setBalance(account.getBalance() - event.getAmount());
        return new WithdrawResponseEvent(account);
    }

    private Account findAccountById(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new NoSuchElementException("Account not found with ID: " + accountId));
    }

    public void reset() {
        accountRepository.resetAll();
    }

    public int getBalanceAccount(String idAccount) {
        var origin = accountRepository.findById(idAccount);

        if (origin.isEmpty()) {
            throw new NoSuchElementException("Account not found.");
        }

        return origin.get().getBalance();
    }


}
