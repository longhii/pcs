package br.com.longhi.payment.account.repository;

import br.com.longhi.payment.account.model.Account;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.Vector;

@ApplicationScoped
public class AccountRepository {

    private Vector<Account> accounts = init();

    private Vector<Account> init() {
        return new Vector<>(Set.of(
                new Account("100", 0),
                new Account("300", 0)));
    }

    public Optional<Account> findById(String id) {
        return accounts.stream()
                .filter(a -> Objects.equals(a.getId(), id))
                .findFirst();
    }

    public boolean resetAll() {
        this.accounts = init();
        return true;
    }

}
