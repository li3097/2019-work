package com.ibx.cac2web.sensitiveaccounts;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MAD.MAD_SENS_ACCOUNT")
public class SensitiveAccountsEntity {
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Id
   @Column(name="SACC_SENS_ACC_SK")
    private Long Id;
   @Column(name="SACC_MBR_ID")
   private String memberID;
   @Column(name="SACC_MBR_1ST_NM")
   private String firstName; //Brand Name
    @Column(name="SACC_MBR_BTH_DT")
    private Date birthday;
    @Column(name="MADR_RSN_CD")
    private String  rsnCD;
    @Column(name="SACC_SENS_ACC_DSC")
    private String AccountDescription;
    @Column(name="CRE_USE_ID")
    private String createdUsername;
    @Column(name="CRE_PGM_NM")
    private String  createdPGMName;
    @Column(name="CRE_TS")
    private Date  createdTimestamp;
    @Column(name="LAST_UPD_USE_ID")
    private String lastUpdateUsername;
    @Column(name="LAST_UPD_PGM_NM")
    private String lastUpdatePGMName;
    @Column(name="LAST_UPD_TS")
    private Date  lastUpdateTimestamp;
    @Column(name="DEL_IND")
    private char deleteIndicator;

    public Long getId() {
        return Id;
    }

    public String getMemberID() {
        return memberID;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getRsnCD() {
        return rsnCD;
    }

    public String getAccountDescription() {
        return AccountDescription;
    }

    public String getCreatedUsername() {
        return createdUsername;
    }

    public String getCreatedPGMName() {
        return createdPGMName;
    }

    public Date getCreatedTimestamp() {
        return createdTimestamp;
    }

    public String getLastUpdateUsername() {
        return lastUpdateUsername;
    }

    public String getLastUpdatePGMName() {
        return lastUpdatePGMName;
    }

    public Date getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    public char getDeleteIndicator() {
        return deleteIndicator;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setRsnCD(String rsnCD) {
        this.rsnCD = rsnCD;
    }

    public void setAccountDescription(String accountDescription) {
        AccountDescription = accountDescription;
    }

    public void setCreatedUsername(String createdUsername) {
        this.createdUsername = createdUsername;
    }

    public void setCreatedPGMName(String createdPGMName) {
        this.createdPGMName = createdPGMName;
    }

    public void setCreatedTimestamp(Date createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public void setLastUpdateUsername(String lastUpdateUsername) {
        this.lastUpdateUsername = lastUpdateUsername;
    }

    public void setLastUpdatePGMName(String lastUpdatePGMName) {
        this.lastUpdatePGMName = lastUpdatePGMName;
    }

    public void setLastUpdateTimestamp(Date lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    public void setDeleteIndicator(char deleteIndicator) {
        this.deleteIndicator = deleteIndicator;
    }

    @Override
    public String toString() {
        return "SensitiveAccountsEntity{" +
                "Id=" + Id +
                ", memberID='" + memberID + '\'' +
                ", firstName='" + firstName + '\'' +
                ", birthday=" + birthday +
                ", rsnCD='" + rsnCD + '\'' +
                ", AccountDescription='" + AccountDescription + '\'' +
                ", createdUsername='" + createdUsername + '\'' +
                ", createdPGMName='" + createdPGMName + '\'' +
                ", createdTimestamp=" + createdTimestamp +
                ", lastUpdateUsername='" + lastUpdateUsername + '\'' +
                ", lastUpdatePGMName='" + lastUpdatePGMName + '\'' +
                ", lastUpdateTimestamp=" + lastUpdateTimestamp +
                ", deleteIndicator=" + deleteIndicator +
                '}';
    }
}
