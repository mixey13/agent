package mixey.agent.service;

import mixey.agent.AuthorizedUser;
import mixey.agent.model.Contract;
import mixey.agent.repository.jpa.JpaClientRepository;
import mixey.agent.repository.jpa.JpaContractRepository;
import mixey.agent.repository.jpa.JpaPriceCategoryRepository;
import mixey.agent.to.ContractTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {
    @Autowired
    private JpaContractRepository contractRepository;
    @Autowired
    private JpaClientRepository clientRepository;
    @Autowired
    private JpaPriceCategoryRepository priceCategoryRepository;

    public Contract save(ContractTo contractTo) {
        Contract contract = new Contract(contractTo.getId());
        contract.setOrganization(AuthorizedUser.getOrganization());
        contract.setClient(clientRepository.getRef(contractTo.getClient()));
        contract.setPriceCategory(priceCategoryRepository.getRef(contractTo.getPriceCategory()));
        return contractRepository.save(contract);
    }

    public Contract update(Contract contract) {
        return null;
    }

    public boolean delete(Integer id) {
        return contractRepository.delete(id);
    }

    public ContractTo get(Integer id) {
        return ContractTo.asTo(contractRepository.get(id));
    }

    public List<ContractTo> getAll() {
        return ContractTo.listAsTo(contractRepository.getAllByOrganization(AuthorizedUser.getOrganization().getId()));
    }
}
