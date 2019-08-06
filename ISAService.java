package com.ibx.cac2web.sensitiveaccounts;

import java.util.List;

    public interface ISensitiveAccountsService {

        List<SensitiveAccount> getMemberDataFromMADSensitiveAccount();
        List<SensitiveAccount> getAccountsByMemberId(String memberId);

        void addSensitiveAccounts(String memberId, String memberFName, String dob, String comments);
        void deleteSensitiveAccount(String memberId, String memberFName, String dob);


}





