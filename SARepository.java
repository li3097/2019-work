package com.ibx.cac2web.sensitiveaccounts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SensitiveAccountsRepository extends JpaRepository<SensitiveAccountsEntity, Long> {

    List<SensitiveAccountsEntity> findByDeleteIndicator(char del_ind);
    List<SensitiveAccountsEntity> findByMemberIDContainingAndDeleteIndicator(String memberId, char del_ind);


}
