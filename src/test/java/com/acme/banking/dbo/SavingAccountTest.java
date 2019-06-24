package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Test;

import java.util.UUID;

public class SavingAccountTest {

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionWhenNullUUID() {
        new SavingAccount(null, new Client(UUID.randomUUID(), "kek"), 100.00);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldThrowExceptionWhenNullClient() {
        new SavingAccount(UUID.randomUUID(), null, 100.00);
    }
}