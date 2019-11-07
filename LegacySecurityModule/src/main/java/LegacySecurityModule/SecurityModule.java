package LegacySecurityModule;

import org.springframework.stereotype.Component;

public interface SecurityModule {

    boolean isAdmin(String role) throws Exception;
}
