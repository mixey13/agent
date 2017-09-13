package mixey.agent.service;

import mixey.agent.model.Balance;
import mixey.agent.repository.jpa.JpaBalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalanceService {
    @Autowired
    private JpaBalanceRepository repository;

    public List<Balance> getBalance() {
        return repository.getBalance();
    }
}
