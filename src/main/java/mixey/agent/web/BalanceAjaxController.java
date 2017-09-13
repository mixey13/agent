package mixey.agent.web;

import mixey.agent.model.Balance;
import mixey.agent.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ajax/balance")
public class BalanceAjaxController {
    @Autowired
    private BalanceService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Balance> getBalance() {
        return service.getBalance();
    }
}
