package mixey.agent.web;

import mixey.agent.service.PriceService;
import mixey.agent.to.PriceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/ajax/prices")
public class PriceAjaxController {
    @Autowired
    private PriceService service;
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceTo get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(value = "/{cli}/{date}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceTo getByDate(@PathVariable("cli") Integer cli, @PathVariable("date") String date) {
        return service.get(cli, date);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceTo> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestBody PriceTo priceTo) {
        service.save(priceTo);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
