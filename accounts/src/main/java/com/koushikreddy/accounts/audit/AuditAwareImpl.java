package com.koushikreddy.accounts.audit;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/* 
 * This class is used to get the current auditor of the application.
 */
@Component("auditAwareImpl") // to specify the name of the bean
public class AuditAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        
        return Optional.of("ACCOUNTS_MS");
    }

}
