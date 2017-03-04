package mixey.agent.web;

import mixey.agent.model.Price;
import mixey.agent.model.PriceCategory;
import mixey.agent.service.PriceService;
import mixey.agent.to.PriceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceTo> getAll() {
        List<PriceTo> list = PriceTo.listAsTo(service.getAll());
        System.out.println(list);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("number") Integer number,
                               @RequestParam("priceCategory") Integer pc_id,
                               @RequestParam("dateTime") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime
                               ) {
        Price price = new Price(id, number, dateTime);
        if (id == 0) {
            service.save(price, pc_id);
        } else {
            service.update(price, pc_id);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
