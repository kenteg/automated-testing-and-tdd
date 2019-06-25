package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Account;
import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ClientTest {

    private static final String TEST_CLIENT_NAME = "John";
    public static final double AMOUNT = 100.0;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void shouldSavePropertiesWhenCreated() {
        //region given
        UUID stubId = UUID.randomUUID();
        //endregion

        //region when
        Client sut = new Client(stubId, "dummy client name");
        //endregion

        //region then
        assertThat(sut.getId(),
                allOf(
                        equalTo(stubId),
                        notNullValue()
                ));
        //endregion
    }

    @Test
    public void shouldThrowExceptionWhenNullUUID() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Id of client is null");
        new Client(null, TEST_CLIENT_NAME);
    }

    @Test
    public void shouldThrowExceptionWhenNullName() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name of client is null");
        new Client(UUID.randomUUID(), null);
    }

    @Test
    public void shouldThrowExceptionWhenNameIsEmpty() {
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Name of client is empty");
        new Client(UUID.randomUUID(), "");
    }

    @Test
    public void shouldGettersReturnValuesAfterClientCreated() {
        final UUID clientId = UUID.randomUUID();
        Client client = new Client(clientId, TEST_CLIENT_NAME);
        assertThat(client.getId(), equalTo(clientId));
        assertThat(client.getName(),
                equalTo(TEST_CLIENT_NAME)
        );

    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowsExceptionWhenAddAccountRelatedToOtherClient() {
        Client otherClient = new Client(UUID.randomUUID(), "otherClient");
        Account otherClientAccount = new SavingAccount(UUID.randomUUID(), otherClient, AMOUNT);
        Client testClient = new Client(UUID.randomUUID(), TEST_CLIENT_NAME);
        testClient.addAccount(otherClientAccount);
    }
}
