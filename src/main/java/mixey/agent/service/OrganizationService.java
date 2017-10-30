package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Organization;
import mixey.agent.model.Role;
import mixey.agent.repository.jpa.JpaOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrganizationService {
    @Autowired
    private JpaOrganizationRepository repository;

    public Organization save(Organization org) {
        return repository.save(org);
    }

    public Organization update(Organization org) {
        return repository.save(org);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Organization get(Integer id) {
        return repository.get(id);
    }

    public List<Organization> getAll() {
        if (AuthorizedUser.get().getAuthorities().contains(Role.ROLE_ROOT)) {
            return repository.getAll();
        } else {
            return Collections.singletonList(AuthorizedUser.getOrganization());
        }
    }
}
