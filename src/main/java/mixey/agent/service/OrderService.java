package mixey.agent.service;

import mixey.agent.model.Order;
import mixey.agent.model.OrderProduct;
import mixey.agent.model.Product;
import mixey.agent.repository.jpa.JpaClientRepository;
import mixey.agent.repository.jpa.JpaOrderRepository;
import mixey.agent.repository.jpa.JpaOrganizationRepository;
import mixey.agent.repository.jpa.JpaProductRepository;
import mixey.agent.to.OrderProductTo;
import mixey.agent.to.OrderTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class OrderService {
    @Autowired
    private JpaOrderRepository orderRepository;
    @Autowired
    private JpaOrganizationRepository organizationRepository;
    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private JpaProductRepository productRepository;

    public Order save(OrderTo orderTo) {
        Order order = new Order(orderTo.getId(), LocalDate.parse(orderTo.getDate()), LocalTime.parse(orderTo.getTime()));
        order.setOrganization(organizationRepository.getRef(orderTo.getOrganization()));
        order.setClient(clientRepository.getRef(orderTo.getClient()));
        Set<OrderProduct> orderProducts = new HashSet<>();
        Double total = 0.0;
        for(OrderProductTo orderProductTo : orderTo.getOrderProductTos()) {
            Product product = productRepository.getRef(orderProductTo.getProduct());
            Double cost = orderProductTo.getCost();
            Double amount = orderProductTo.getAmount();
            total += (cost * amount);
            OrderProduct orderProduct = new OrderProduct(product, cost, amount);
            orderProduct.setOrder(order);
            orderProducts.add(orderProduct);
        }
        order.setTotal(total);
        order.setOrderProducts(orderProducts);
        return orderRepository.save(order);
    }

    public boolean delete(Integer id) {
        return orderRepository.delete(id);
    }

    public OrderTo get(Integer id) {
        return OrderTo.asToFull(orderRepository.get(id));
    }

    public List<OrderTo> getAll() {
        return OrderTo.listAsTo(orderRepository.getAll());
    }
}