package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.BaseUser;
import mixey.agent.repository.jpa.JpaSecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("securityService")
public class SecurityService implements UserDetailsService {
    @Autowired
    private JpaSecurityRepository repository;

    @Override
    public AuthorizedUser loadUserByUsername(String name) throws UsernameNotFoundException {
        BaseUser user = repository.getByName(name);
        AuthorizedUser authorizedUser = new AuthorizedUser(user);
        return authorizedUser;
    }
}
