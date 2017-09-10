package mixey.agent.service;

import mixey.agent.model.Order;
import mixey.agent.repository.jpa.JpaOrderRepository;
import mixey.agent.to.OrderTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private JpaOrderRepository repository;

    public Order save(OrderTo orderTo) {
        return repository.save();
    }

    public boolean delete(Integer id) {
        return repository.delete(id);
    }

    public OrderTo get(Integer id) {
        return OrderTo.asToFull(repository.get(id));
    }

    public List<OrderTo> getAll() {
        return OrderTo.listAsTo(repository.getAll());
    }
}