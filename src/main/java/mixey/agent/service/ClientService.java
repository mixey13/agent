package mixey.agent.service;

import mixey.agent.model.Client;
import mixey.agent.repository.jpa.JpaClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private JpaClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Client update(Client client) {
        return null;
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Client get(Integer id) {
        return repository.get(id);
    }

    public List<Client> getAll() {
        return repository.getAll();
    }
}
