package mixey.agent.service;

import mixey.agent.model.Admin;
import mixey.agent.model.Role;
import mixey.agent.repository.jpa.JpaAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AdminService {
    @Autowired
    private JpaAdminRepository repository;

    public Admin save(Admin admin) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_ROOT);
        admin.setRoles(roles);
        return repository.save(admin);
    }

    public Admin update(Admin admin) {
        return repository.save(admin);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Admin get(Integer id) {
        return repository.get(id);
    }

    public List<Admin> getAll() {
        return repository.getAll();
    }
}
