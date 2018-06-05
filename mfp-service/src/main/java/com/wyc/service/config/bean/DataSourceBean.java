package com.wyc.service.config.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DataSourceBean {

    @Value("${dateSourceUrl}")
    private String dateSourceUrl;
    @Value("${dateSourceUserName}")
    private String dateSourceUserName;
    @Value("${dateSourcePassWd}")
    private String  dateSourcePassWd;

    public String getDateSourceUrl() {
        return dateSourceUrl;
    }

    public void setDateSourceUrl(String dateSourceUrl) {
        this.dateSourceUrl = dateSourceUrl;
    }

    public String getDateSourceUserName() {
        return dateSourceUserName;
    }

    public void setDateSourceUserName(String dateSourceUserName) {
        this.dateSourceUserName = dateSourceUserName;
    }

    public String getDateSourcePassWd() {
        return dateSourcePassWd;
    }

    public void setDateSourcePassWd(String dateSourcePassWd) {
        this.dateSourcePassWd = dateSourcePassWd;
    }
}
