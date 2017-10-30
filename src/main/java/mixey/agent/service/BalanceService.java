package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Balance;
import mixey.agent.repository.jpa.JpaBalanceRepository;
import mixey.agent.to.BalanceTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BalanceService {
    @Autowired
    private JpaBalanceRepository repository;

    public List<BalanceTo> getBalance() {
        return BalanceTo.listAsTo(repository.getBalance(AuthorizedUser.getOrganization()));
    }

    public List<BalanceTo> getBalance(String date) {
        return BalanceTo.listAsTo(repository.getBalance(LocalDate.parse(date), AuthorizedUser.getOrganization()));
    }
}
