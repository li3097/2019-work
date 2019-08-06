package com.ibx.cac2web.sensitiveaccounts;

import com.ibx.cac2web.framework.SessionCheckInterceptor;
import com.ibx.cac2web.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SensitiveAccountsService implements ISensitiveAccountsService {

    private SensitiveAccountsRepository sensitiveAccountsRepository;
    private JdbcTemplate jdbcTemplate;
    private ISensitiveAccountsDAO sensitiveAccountsDAO;
    private SessionCheckInterceptor sessionCheckInterceptor;

    @Autowired
    public SensitiveAccountsService(SensitiveAccountsRepository sensitiveAccountsRepository, JdbcTemplate jdbcTemplate, ISensitiveAccountsDAO sensitiveAccountsDAO, SessionCheckInterceptor sessionCheckInterceptor) {
        this.sensitiveAccountsRepository = sensitiveAccountsRepository;
        this.jdbcTemplate = jdbcTemplate;
        this.sensitiveAccountsDAO = sensitiveAccountsDAO;
        this.sessionCheckInterceptor = sessionCheckInterceptor;
    }

    public List<SensitiveAccount> getMemberDataFromMADSensitiveAccount() {
        List<SensitiveAccountsEntity> sensitiveAccountsEntities = sensitiveAccountsRepository.findByDeleteIndicator('N');
        return makeArrayList(sensitiveAccountsEntities);
    }

    @Override
    public List<SensitiveAccount> getAccountsByMemberId(String memberId) {
        List<SensitiveAccountsEntity> sensitiveAccountsEntities = sensitiveAccountsRepository.findByMemberIDContainingAndDeleteIndicator(memberId, 'N');
        return makeArrayList(sensitiveAccountsEntities);
    }

    public synchronized void addSensitiveAccounts(String memberId, String memberFName, String dob, String comments) {
        String userId = sessionCheckInterceptor.getUserName();
        sensitiveAccountsDAO.insertSensitiveAccount(memberId, userId, memberFName, dob, comments);
    }

    public void deleteSensitiveAccount(String memberId, String memberFName, String dob) {
        String userID = sessionCheckInterceptor.getUserName();
        sensitiveAccountsDAO.deleteSensitiveAccount(memberId, userID, memberFName, dob);
    }

    private List<SensitiveAccount> makeArrayList(List<SensitiveAccountsEntity> entityList) {
        List<SensitiveAccount> accountList = new ArrayList();
        for (SensitiveAccountsEntity entity : entityList) {
            SensitiveAccount account = new SensitiveAccount();
            account.setMemberId(entity.getMemberID());
            account.setFirstName(entity.getFirstName());
            account.setDateOfBirth(DateUtils.dateToString(entity.getBirthday()));
            account.setComments(entity.getAccountDescription());
            accountList.add(account);
        }
        return accountList;
    }
}
