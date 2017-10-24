package mixey.agent.service;

import mixey.agent.model.Role;
import mixey.agent.model.User;

import mixey.agent.repository.jpa.JpaOrganizationRepository;
import mixey.agent.repository.jpa.JpaUserRepository;
import mixey.agent.to.UserTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService{
    @Autowired
    private JpaUserRepository repository;
    @Autowired
    private JpaOrganizationRepository organizationRepository;

    public User save(UserTo userTo) {
        User user = new User(userTo.getId(), userTo.getName(), userTo.getPassword());
        user.setOrganization(organizationRepository.getRef(userTo.getOrganization()));
        Set<Role> roles = new HashSet<>();
        roles.add(Role.ROLE_AGENT);
        user.setRoles(roles);
        return repository.save(user);
    }

    public User update(User user) {
        return null;
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public UserTo get(Integer id) {
        return UserTo.asTo(repository.get(id));
    }

    public List<UserTo> getAll() {
        return UserTo.listAsTo(repository.getAll());
    }
}
