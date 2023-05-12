package com.t.flendzz;

import com.google.gson.annotations.SerializedName;

public class Models {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String website;

    @SerializedName("address")
    private DetailsAddress detailsAddress;

    @SerializedName("company")
    private DetailsCompany detailsCompany;

    public Models(String id, String name, String email, String phone, String website,
                  DetailsAddress detailsAddress, DetailsCompany detailsCompany) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.website = website;
        this.detailsAddress = detailsAddress;
        this.detailsCompany = detailsCompany;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public DetailsAddress getDetailsAddress() {
        return detailsAddress;
    }

    public void setDetailsAddress(DetailsAddress detailsAddress) {
        this.detailsAddress = detailsAddress;
    }

    public DetailsCompany getDetailsCompany() {
        return detailsCompany;
    }

    public void setDetailsCompany(DetailsCompany detailsCompany) {
        this.detailsCompany = detailsCompany;
    }
}
