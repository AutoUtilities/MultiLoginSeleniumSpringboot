package com.Sample.Sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Account {
    @JsonProperty("Username")
    private String Username;

    @JsonProperty("Password")
    private String Password;
}

