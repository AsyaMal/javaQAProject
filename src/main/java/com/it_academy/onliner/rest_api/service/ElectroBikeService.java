package com.it_academy.onliner.rest_api.service;

import com.it_academy.onliner.rest_api.pojo.ElectroBikeProduct;
import com.it_academy.onliner.rest_api.utils.GetRequestUtils;
import com.it_academy.onliner.rest_api.utils.ResponseBodyUtils;
import io.qameta.allure.Step;
import io.restassured.response.ResponseBody;

import java.util.List;

public class ElectroBikeService {

    @Step("Select ElectroBike products")
    public List<ElectroBikeProduct> getElectroBikeProduct(String endpoint) {
        ResponseBody responseBody = GetRequestUtils.makeRequestAndGetResponseBody(endpoint, null, null);
        return ResponseBodyUtils.getObjectsByJsonPath(responseBody, "products",
                ElectroBikeProduct.class);
    }
}
