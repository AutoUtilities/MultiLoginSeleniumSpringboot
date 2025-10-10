package com.Sample.Sample.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Account {
    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;
}

