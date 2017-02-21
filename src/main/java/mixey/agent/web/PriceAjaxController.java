package mixey.agent.web;

import mixey.agent.model.Price;
import mixey.agent.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/prices")
public class PriceAjaxController {
    @Autowired
    private PriceService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Price get(@PathVariable("id") Integer id) {
        return service.get(id);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Price> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("description") String description
    ) {
        Price price = new Price(id, name, description);
        if (id == 0) {
            service.save(price);
        } else {
            service.update(price);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
