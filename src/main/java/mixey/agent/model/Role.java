package mixey.agent.model;

import org.springframework.security.core.GrantedAuthority;


public enum Role implements GrantedAuthority {
    ROLE_ROOT,
    ROLE_ADMIN,
    ROLE_OPERATOR,
    ROLE_AGENT;

    @Override
    public String getAuthority() {
        return name();
    }
}
