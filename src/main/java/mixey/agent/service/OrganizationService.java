package mixey.agent.service;

import mixey.agent.model.Organization;
import mixey.agent.repository.jpa.JpaOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return repository.getAll();
    }
}
