package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.junit.Assert.assertTrue;

public class SavingAccountTest {

    private static final Client TEST_CLIENT = new Client(UUID.randomUUID(), "John");
    private static final double NEGATIVE_AMOUNT = -1.0;
    private static final double POSITIVE_AMOUNT = 1.0;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldThrowExceptionWhenNullUUID() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Id of account is null");
        new SavingAccount(null, TEST_CLIENT, POSITIVE_AMOUNT);
    }

    @Test
    public void shouldThrowExceptionWhenNullClient() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Client of account is null");
        new SavingAccount(UUID.randomUUID(), null, POSITIVE_AMOUNT);
    }

    @Test
    public void shouldThrowExceptionWhenAmountIsNegative() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Amount of account is sub zero");
        new SavingAccount(UUID.randomUUID(), TEST_CLIENT, NEGATIVE_AMOUNT);
    }

    @Test
    public void shouldAddAccountIdToClientWhenCreateAccount() {
        UUID accountId = UUID.randomUUID();
        new SavingAccount(accountId, TEST_CLIENT, POSITIVE_AMOUNT);
        assertTrue(TEST_CLIENT.getAccountIds().contains(accountId));
    }


}