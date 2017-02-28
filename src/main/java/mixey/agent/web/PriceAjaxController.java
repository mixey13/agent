package mixey.agent.web;

import mixey.agent.model.Price;
import mixey.agent.model.PriceCategory;
import mixey.agent.service.PriceService;
import mixey.agent.to.PriceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/ajax/prices")
public class PriceAjaxController {
    @Autowired
    private PriceService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceTo get(@PathVariable("id") Integer id) {
        return PriceTo.asTo(service.get(id));
    }

/*
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceTo> getAll() {
        return PriceTo.listAsTo(service.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("number") Integer number,
                               @RequestParam("priceCategory") PriceCategory priceCategory,
                               @RequestParam("date") LocalDateTime dateTime
    ) {
        Price price = new Price(id, number, priceCategory, dateTime);
        if (id == 0) {
            service.save(price);
        } else {
            service.update(price);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }*/
}
