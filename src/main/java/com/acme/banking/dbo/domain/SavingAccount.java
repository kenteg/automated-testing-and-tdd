package com.acme.banking.dbo.domain;

import com.acme.banking.dbo.service.Guard;

import java.util.UUID;

public class SavingAccount implements Account {
    private UUID id;
    private Client client;
    private double amount;

    public SavingAccount(UUID id, Client client, double amount) {
        Guard.checkNonNull(id, () -> {throw new IllegalArgumentException();});
        Guard.checkNonNull(client, () -> {throw new IllegalArgumentException();});
        this.id = id;
        this.client = client;
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public UUID getClientId() {
        return client.getId();
    }
}
