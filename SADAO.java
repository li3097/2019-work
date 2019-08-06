package com.ibx.cac2web.sensitiveaccounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SensitiveAccountsDAO implements ISensitiveAccountsDAO {
        static final String MEMBER = "sensitive member ";
        @Autowired
        private JdbcTemplate jdbcTemplate;

        //public String MAD_SPECIAL_ACCOUNT_RETRIVE = "select MSAA_MBR_IDENTIFER, MSAA_UPDATE_DATE from MAD.MAD_SPECIAL_ACCOUNT_ACCESS where MSAA_ACCESS_INDICATOR = 'N' order by MSAA_MBR_IDENTIFER";
        public static final String MAD_SPECIAL_ACCOUNT_RETRIVE = "select SACC_MBR_ID,  SACC_MBR_1ST_NM, to_char(SACC_MBR_BTH_DT,'MM/DD/YYYY') as MBR_BIRTH_DT, SACC_SENS_ACC_DSC from  MAD.MAD_SENS_ACCOUNT where DEL_IND = 'N'";
        //public String MAD_SPECIAL_ACCOUNT_INSERT = "INSERT INTO MAD.MAD_SPECIAL_ACCOUNT_ACCESS " +
        //	    "(MSAA_MBR_IDENTIFER, MSAA_GROUP_NUMBER, MSAA_ACCESS_INDICATOR, MADR_DENIAL_REASON_CD, MSAA_UPDATE_DATE, MSAA_USER_ID) VALUES ";

        public static final String MAD_SPECIAL_ACCOUNT_INSERT = "INSERT INTO MAD.MAD_SENS_ACCOUNT " +
                "(SACC_SENS_ACC_SK,SACC_MBR_ID,SACC_MBR_1ST_NM,SACC_MBR_BTH_DT,MADR_RSN_CD,SACC_SENS_ACC_DSC,CRE_USE_ID," +
                "CRE_PGM_NM,CRE_TS,LAST_UPD_USE_ID,LAST_UPD_PGM_NM,LAST_UPD_TS,DEL_IND) values " +
                "(MAD.SACC_SENS_ACC_SEQ.nextval,?,?,to_date(?, 'MM/DD/YYYY'),'10',?,?,'CAC',systimestamp,?,'CAC',systimestamp,'N')";
        public static final String MAD_SPECIAL_ACCOUNT_DELETE = "delete from MAD.MAD_SPECIAL_ACCOUNT_ACCESS where MSAA_MBR_IDENTIFER = ";
        //public String MAD_SPECIAL_ACCOUNT_LOGICAL_DELETE = "update MAD.MAD_SPECIAL_ACCOUNT_ACCESS set MSAA_ACCESS_INDICATOR = 'Y' where MSAA_MBR_IDENTIFER = ";
        public static final String MAD_SPECIAL_ACCOUNT_LOGICAL_DELETE = "update MAD.MAD_SENS_ACCOUNT set DEL_IND = 'Y', LAST_UPD_USE_ID=?, LAST_UPD_PGM_NM='CAC', LAST_UPD_TS=systimestamp " +
                "where SACC_MBR_ID=? and SACC_MBR_1ST_NM=? and SACC_MBR_BTH_DT=to_date(?, 'MM/DD/YYYY')";

        public static final String MAD_SPECIAL_ACCOUNT_RESET = "update MAD.MAD_SENS_ACCOUNT set DEL_IND = 'N', LAST_UPD_USE_ID=?, LAST_UPD_PGM_NM='CAC', LAST_UPD_TS=systimestamp, SACC_SENS_ACC_DSC=? " +
                "where SACC_MBR_ID=? and SACC_MBR_1ST_NM=? and SACC_MBR_BTH_DT=to_date(?, 'MM/DD/YYYY')";

        public static final String MAD_SPECIAL_ACCOUNT_EXISTS = "select COUNT(*) from  MAD.MAD_SENS_ACCOUNT where " +
                " SACC_MBR_ID=? and SACC_MBR_1ST_NM=? and SACC_MBR_BTH_DT=to_date(?, 'MM/DD/YYYY')";


        public void insertSensitiveAccount(final String memberId, final String userId, String memberFName, String dob, String comments) {
        System.out.println(MEMBER +memberId+" added by "+userId);
                //Check if account already exists
                Object[] argsCount = new Object[] {memberId, memberFName, dob};
                int count = jdbcTemplate.queryForObject(MAD_SPECIAL_ACCOUNT_EXISTS, argsCount, Integer.class);
                if (count > 0){
                        System.out.println(MEMBER +memberId+" exists, resetting data.");

                        Object[] argsReset = new Object[] {userId, comments, memberId, memberFName, dob };
                        int out = jdbcTemplate.update(MAD_SPECIAL_ACCOUNT_RESET, argsReset);
                        if(out !=0){
                                System.out.println(MEMBER +memberId+" reset successfully by "+userId);
                        }else {
                                System.out.println(MEMBER +memberId+" reset by "+userId + " failed.");
                        }
                }else{
                        Object[] args = new Object[] {memberId, memberFName, dob, comments, userId, userId};
                        int out = jdbcTemplate.update(MAD_SPECIAL_ACCOUNT_INSERT, args);
                        System.out.println(MEMBER +memberId+" added successfully");

                }
                

        }

        public void deleteSensitiveAccount(final String memberId, final String userId, String memberFName, String dob) {
            //System.out.println("sensitive member "+memberId+" deleted by "+userId);

            Object[] args = new Object[] {userId, memberId, memberFName, dob};
            int out = jdbcTemplate.update(MAD_SPECIAL_ACCOUNT_LOGICAL_DELETE, args);
            if(out !=0){
                System.out.println(MEMBER +memberId+" deleted successfully by "+userId);
            }else {
                System.out.println(MEMBER +memberId+" delete by "+userId + " failed.");
            }
        }




}
