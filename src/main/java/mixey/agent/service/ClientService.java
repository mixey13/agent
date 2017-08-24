package mixey.agent.service;

import mixey.agent.model.Client;
import mixey.agent.repository.jpa.JpaClientRepository;
import mixey.agent.repository.jpa.JpaPriceCategoryRepository;
import mixey.agent.to.ClientTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private JpaClientRepository repository;
    @Autowired
    private JpaPriceCategoryRepository priceCategoryRepository;

    public Client save(ClientTo clientTo) {
        Client client = new Client(clientTo.getId(), clientTo.getName(), clientTo.getFullName(), clientTo.getInn(), clientTo.getAddress());
        client.setPriceCategory(priceCategoryRepository.getRef(clientTo.getPriceCategory()));
        return repository.save(client);
    }

    public Client update(ClientTo clientTo) {
        Client client = new Client(clientTo.getId(), clientTo.getName(), clientTo.getFullName(), clientTo.getInn(), clientTo.getAddress());
        client.setPriceCategory(priceCategoryRepository.getRef(clientTo.getPriceCategory()));
        return repository.save(client);
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public ClientTo get(Integer id) {
        return ClientTo.asTo(repository.get(id));
    }

    public List<ClientTo> getAll() {
        return ClientTo.listAsTo(repository.getAll());
    }
}
