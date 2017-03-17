package mixey.agent.web;

import mixey.agent.service.PriceService;
import mixey.agent.to.PriceTo;
import mixey.agent.to.PriceView;
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
    public PriceView get(@PathVariable("id") Integer id) {
        return PriceView.asView(service.get(id));
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceView> getAll() {
        return PriceView.listAsView(service.getAll());
    }

    /*@RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("number") Integer number,
                               @RequestParam("priceCategory") Integer pc_id,
                               @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                               @RequestParam("priceProducts[]") Map<Integer, Integer> productValues
                               ) {
        System.out.println(productValues);
        *//*Price price = new Price(id, number, date);
        if (id == 0) {
            service.save(price, pc_id, productValues);
        } else {
            service.update(price, pc_id, productValues);
        }*//*
    }*/

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(PriceTo priceTo) {
        System.out.println();
        System.out.println();
        System.out.println(priceTo);
        System.out.println();
        System.out.println();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
