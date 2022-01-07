package com.michellibrito.msemail.applicationcore.ports;

import com.michellibrito.msemail.applicationcore.domain.Email;
import com.michellibrito.msemail.applicationcore.domain.PageInfo;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmailRepositoryPort {

    Email save(Email email);
    List<Email> findAll(PageInfo pageInfo);
    Optional<Email> findById(UUID emailId);
}
