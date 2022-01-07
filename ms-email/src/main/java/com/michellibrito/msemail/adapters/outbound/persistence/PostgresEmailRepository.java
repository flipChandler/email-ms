package com.michellibrito.msemail.adapters.outbound.persistence;

import com.michellibrito.msemail.adapters.outbound.persistence.entities.EmailEntity;
import com.michellibrito.msemail.applicationcore.domain.Email;
import com.michellibrito.msemail.applicationcore.domain.PageInfo;
import com.michellibrito.msemail.applicationcore.ports.EmailRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@Primary
public class PostgresEmailRepository implements EmailRepositoryPort {

    private final SpringDataPostgresEmailRepository postgresEmailRepository;

    @Autowired
    ModelMapper modelMapper;

    public PostgresEmailRepository(final SpringDataPostgresEmailRepository orderRepository) {
        this.postgresEmailRepository = orderRepository;
    }

    @Override
    public Email save(Email email) {
        EmailEntity entity = postgresEmailRepository.save(modelMapper.map(email, EmailEntity.class));
        return modelMapper.map(entity, Email.class);
    }

    @Override
    public List<Email> findAll(PageInfo pageInfo) {
        Pageable pageable = PageRequest.of(pageInfo.getPageNumber(), pageInfo.getPageSize());
        return postgresEmailRepository.findAll(pageable).stream()
                .map(entity -> modelMapper.map(entity, Email.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Email> findById(UUID emailId) {
        Optional<EmailEntity> optional = postgresEmailRepository.findById(emailId);
        if (optional.isPresent()) {
            return Optional.of(modelMapper.map(optional.get(), Email.class));
        }
        return Optional.empty();
    }
}
