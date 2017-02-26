package mixey.agent.web;

import mixey.agent.model.PriceCategory;
import mixey.agent.service.PriceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/pc")
public class PriceCategoryAjaxController {
    @Autowired
    private PriceCategoryService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceCategory get(@PathVariable("id") Integer id) {
        return service.get(id);
    }


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PriceCategory> getAll() {
        return service.getAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestParam("id") int id,
                               @RequestParam("name") String name,
                               @RequestParam("description") String description
    ) {
        PriceCategory priceCategory = new PriceCategory(id, name, description);
        if (id == 0) {
            service.save(priceCategory);
        } else {
            service.update(priceCategory);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}