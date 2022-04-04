package com.it_academy.onliner.rest_api.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ElectroBikeProduct {
    private int id;
    private String key;
    private String name;
    private String full_name;
    private String name_prefix;
}

