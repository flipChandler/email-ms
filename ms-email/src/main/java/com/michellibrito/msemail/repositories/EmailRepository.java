package com.michellibrito.msemail.repositories;

import com.michellibrito.msemail.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}
