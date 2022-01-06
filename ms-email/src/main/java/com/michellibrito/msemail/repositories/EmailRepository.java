package com.michellibrito.msemail.repositories;

import com.michellibrito.msemail.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<Email, UUID> {
}
