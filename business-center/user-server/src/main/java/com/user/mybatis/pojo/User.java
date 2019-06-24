package com.user.mybatis.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

public class User {
    private int userId;
    private String userName;
    private String phoneNumber;
    private String idCardNo;
    @JsonIgnore
    private String password;
    private String channelCode;
    private int userStatus;
    private Timestamp creationDate;
    private int realnameVerified;
    private Timestamp realnameVerifiedDate;
    private int mobileVerified;
    private Timestamp mobileVerifiedDate;
    private int basicInfoVerified;// 基本信息是否完善
    private Timestamp basicInfoVerifiedDate;
    private int bankCardVerified;
    private Timestamp bankCardVerifiedDate;
    private int maillistVerified;
    private Timestamp maillistVerifiedDate;
    private Timestamp firstLoginAppDate;
    private Timestamp lastLoginAppDate;
    private int appListVerified; //app列表数据上传状态
    private Timestamp appListVerifiedDate;//app列表数据上传时间
    private String appListVerifiedPath;//app安装列表对应OSS的key
    private String pushToken;//用户的推送信息
    public String getAppListVerifiedPath() {
        return appListVerifiedPath;
    }

    public void setAppListVerifiedPath(String appListVerifiedPath) {
        this.appListVerifiedPath = appListVerifiedPath;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode;
    }

    public int getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(int userStatus) {
        this.userStatus = userStatus;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public int getRealnameVerified() {
        return realnameVerified;
    }

    public void setRealnameVerified(int realnameVerified) {
        this.realnameVerified = realnameVerified;
    }

    public Timestamp getRealnameVerifiedDate() {
        return realnameVerifiedDate;
    }

    public void setRealnameVerifiedDate(Timestamp realnameVerifiedDate) {
        this.realnameVerifiedDate = realnameVerifiedDate;
    }

    public int getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(int mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public Timestamp getMobileVerifiedDate() {
        return mobileVerifiedDate;
    }

    public void setMobileVerifiedDate(Timestamp mobileVerifiedDate) {
        this.mobileVerifiedDate = mobileVerifiedDate;
    }

    public int getBasicInfoVerified() {
        return basicInfoVerified;
    }

    public void setBasicInfoVerified(int basicInfoVerified) {
        this.basicInfoVerified = basicInfoVerified;
    }

    public Timestamp getBasicInfoVerifiedDate() {
        return basicInfoVerifiedDate;
    }

    public void setBasicInfoVerifiedDate(Timestamp basicInfoVerifiedDate) {
        this.basicInfoVerifiedDate = basicInfoVerifiedDate;
    }

    public int getBankCardVerified() {
        return bankCardVerified;
    }

    public void setBankCardVerified(int bankCardVerified) {
        this.bankCardVerified = bankCardVerified;
    }

    public Timestamp getBankCardVerifiedDate() {
        return bankCardVerifiedDate;
    }

    public void setBankCardVerifiedDate(Timestamp bankCardVerifiedDate) {
        this.bankCardVerifiedDate = bankCardVerifiedDate;
    }

    public int getMaillistVerified() {
        return maillistVerified;
    }

    public void setMaillistVerified(int maillistVerified) {
        this.maillistVerified = maillistVerified;
    }

    public Timestamp getMaillistVerifiedDate() {
        return maillistVerifiedDate;
    }

    public void setMaillistVerifiedDate(Timestamp maillistVerifiedDate) {
        this.maillistVerifiedDate = maillistVerifiedDate;
    }


    public Timestamp getFirstLoginAppDate() {
        return firstLoginAppDate;
    }

    public void setFirstLoginAppDate(Timestamp firstLoginAppDate) {
        this.firstLoginAppDate = firstLoginAppDate;
    }

    public Timestamp getLastLoginAppDate() {
        return lastLoginAppDate;
    }

    public void setLastLoginAppDate(Timestamp lastLoginAppDate) {
        this.lastLoginAppDate = lastLoginAppDate;
    }

    public int getAppListVerified() {
        return appListVerified;
    }

    public void setAppListVerified(int appListVerified) {
        this.appListVerified = appListVerified;
    }

    public Timestamp getAppListVerifiedDate() {
        return appListVerifiedDate;
    }

    public void setAppListVerifiedDate(Timestamp appListVerifiedDate) {
        this.appListVerifiedDate = appListVerifiedDate;
    }

    public String getPushToken() {
        return pushToken;
    }

    public void setPushToken(String pushToken) {
        this.pushToken = pushToken;
    }

}
