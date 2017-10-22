package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.User;

import mixey.agent.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService implements UserDetailsService {
    @Autowired
    private JpaUserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public User update(User user) {
        return repository.save(user);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public User get(Integer id) {
        return repository.get(id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public AuthorizedUser loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = repository.getByName(name);
        AuthorizedUser authorizedUser = new AuthorizedUser(user);
        return authorizedUser;
    }
}
