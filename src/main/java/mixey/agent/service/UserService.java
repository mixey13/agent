package mixey.agent.service;

import mixey.agent.model.User;

import mixey.agent.repository.jpa.JpaUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
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
}
