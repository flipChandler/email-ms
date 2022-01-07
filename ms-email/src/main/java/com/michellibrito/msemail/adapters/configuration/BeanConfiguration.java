package com.michellibrito.msemail.adapters.configuration;

import com.michellibrito.msemail.MsEmailApplication;
import com.michellibrito.msemail.applicationcore.ports.EmailRepositoryPort;
import com.michellibrito.msemail.applicationcore.ports.SendEmailServicePort;
import com.michellibrito.msemail.applicationcore.services.EmailServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = MsEmailApplication.class)
public class BeanConfiguration {

    @Bean
    EmailServiceImpl emailServiceImpl(EmailRepositoryPort repository, SendEmailServicePort sendEmailServicePort) {
        return new EmailServiceImpl(repository, sendEmailServicePort);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}