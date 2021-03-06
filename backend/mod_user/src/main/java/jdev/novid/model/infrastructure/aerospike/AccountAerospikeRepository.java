package jdev.novid.model.infrastructure.aerospike;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jdev.novid.common.identity.UserId;
import jdev.novid.component.persistence.PersistenceQualifiers;
import jdev.novid.model.domain.Account;
import jdev.novid.model.infrastructure.AccountRepository;

@Component
@Qualifier(PersistenceQualifiers.AEROSPIKE)
public class AccountAerospikeRepository implements AccountRepository {

    @Autowired
    private AccountRecordRepository accountRecordRepository;

    @Override
    public void save(Account domain) {

        AccountRecord state = new AccountRecord();

        AccountRecord.map(domain, state);

        this.accountRecordRepository.save(state);

    }

    @Override
    public void delete(UserId id) {

    }

    @Override
    public Account get(UserId id) {

        return null;

    }

    @Override
    public Optional<Account> findById(UserId id) {

        Optional<AccountRecord> optAccountRecord = this.accountRecordRepository.findById(id);

        if (optAccountRecord.isPresent()) {

            return Optional.of(Account.Builder.fromState(optAccountRecord.get()));

        }

        return Optional.empty();

    }

}
