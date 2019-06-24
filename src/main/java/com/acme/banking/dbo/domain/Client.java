package com.acme.banking.dbo.domain;

import com.acme.banking.dbo.service.Guard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public class Client {
    private UUID id;
    private String name;

    public Collection<UUID> getAccountIds() {
        return accountIds;
    }

    private Collection<UUID> accountIds = new ArrayList<>(); //TODO

    public Client(UUID id, String name) {
        Guard.checkNonNull(id, () -> {
            throw new IllegalArgumentException("Id of client is null");
        });
        Guard.checkNonNull(name, () -> {
            throw new IllegalArgumentException("Name of client is null");
        });
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account){
        if (account.getClientId().equals(id)) {
            accountIds.add(account.getId());
        } else {
            throw new IllegalStateException("Account is related to other client");
        }
    }
}
