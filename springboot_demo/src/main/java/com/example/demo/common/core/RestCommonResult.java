package com.example.demo.common.core;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SanKai
 * @since 2019-11-05
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class RestCommonResult<T> implements Serializable {

    public static final String FAIL     = "fail";

    public static final String SUCCESS  = "success";

    public static final String DEFAULT_SUCCESS_CODE = "000000";

    public static final String DEFAULT_ERROR_CODE = "999999";

    private String code;

    private T data;

    private String status = SUCCESS;

    private List<?> errors;

    public RestCommonResult(){
        this.code = DEFAULT_SUCCESS_CODE;
        this.status = SUCCESS;
        this.errors = new ArrayList<>();
    }

    public RestCommonResult(final T data){
        this();
        this.data = data;
    }

}