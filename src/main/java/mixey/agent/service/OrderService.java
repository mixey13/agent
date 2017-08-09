package mixey.agent.service;

import mixey.agent.model.Order;
import mixey.agent.repository.jpa.JpaOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private JpaOrderRepository repository;

    public Order save() {
        return repository.save();
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public Order get(Integer id) {
        return repository.get(id);
    }

    public List<Order> getAll() {
        return repository.getAll();
    }
}