package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Client;
import com.acme.banking.dbo.domain.SavingAccount;
import org.junit.Assert;
import org.junit.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class ClientTest {
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

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNullUUID() {
        new Client(null, "kek");
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenNullName() {
        new Client(UUID.randomUUID(), null);
    }

    @Test
    public void shouldGettersReturnValues() {
        final UUID clientId = UUID.fromString("1");
        final String clientName = "kek";
        Client client = new Client(clientId, clientName);
        assertEquals(clientId, client.getId());
        assertEquals(clientName, client.getName());
    }
}
