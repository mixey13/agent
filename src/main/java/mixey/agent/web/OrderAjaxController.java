package mixey.agent.web;

import mixey.agent.service.OrderService;
import mixey.agent.to.OrderTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/orders")
public class OrderAjaxController {
    @Autowired
    private OrderService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderTo get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderTo> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestBody OrderTo orderTo) {
        service.save(orderTo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
