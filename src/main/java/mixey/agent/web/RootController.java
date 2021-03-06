package mixey.agent.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RootController {
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String productList() {
        return "productList";
    }

    @RequestMapping(value = "/admins", method = RequestMethod.GET)
    public String adminList() {
        return "adminList";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String userList() {
        return "userList";
    }

    @RequestMapping(value = "/pc", method = RequestMethod.GET)
    public String priceCategoryList() {
        return "pcList";
    }

    @RequestMapping(value = "/prices", method = RequestMethod.GET)
    public String priceList() {
        return "priceList";
    }

    @RequestMapping(value = "/organizations", method = RequestMethod.GET)
    public String organizationList() {
        return "orgList";
    }

    @RequestMapping(value = "/clients", method = RequestMethod.GET)
    public String clientList() {
        return "clientList";
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String orderList() {
        return "orderList";
    }

    @RequestMapping(value = "/productions", method = RequestMethod.GET)
    public String productionList() {
        return "productionList";
    }

    @RequestMapping(value = "/contracts", method = RequestMethod.GET)
    public String contractList() {
        return "contractList";
    }

    @RequestMapping(value = "/balance", method = RequestMethod.GET)
    public String balanceList() {
        return "balanceList";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String startPage() {
        return "start";
    }
}
