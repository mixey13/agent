package mixey.agent.web;

import mixey.agent.model.Client;
import mixey.agent.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ajax/clients")
public class ClientAjaxController {
    @Autowired
    private ClientService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client get(@PathVariable("id") Integer id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getAll() {
        return service.getAll();
    }

    @RequestMapping(value = "/org", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> getAllByOrganization() {
        return service.getAllByOrganization();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void updateOrCreate(@RequestBody Client client) {
        service.save(client);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") int id) {
        return service.delete(id);
    }
}
