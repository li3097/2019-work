package com.ibx.cac2web.sensitiveaccounts;

import java.util.Date;

public interface ISensitiveAccountsDAO {
    void insertSensitiveAccount(final String memberId, final String userId, String memberFName, String dob, String comments);
    void deleteSensitiveAccount(final String memberId, final String userId, String memberFName, String dob);
}
