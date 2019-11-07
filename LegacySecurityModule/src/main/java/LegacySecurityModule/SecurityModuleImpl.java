package LegacySecurityModule;

import org.springframework.stereotype.Component;

public class SecurityModuleImpl implements SecurityModule {

    public boolean isAdmin(String role)  {
        return role.equals("ADMIN");
    }
}
