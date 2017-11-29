package com.timeline.common;

import com.google.common.collect.Maps;

import java.util.Map;

public class ResponseUtils {

    public static final String SUCCESS = "success";

    public static final String FAILURE = "failure";

    private static <T> Map<String, Object> wrap(T data, int status, String msg) {

        Map<String, Object> modal = Maps.newHashMap();
        modal.put("status", status);
        modal.put("data", data);
        modal.put("msg", msg);
        return modal;
    }

    public static <T> Map<String, Object> toSuccess(T data) {

        return wrap(data, 200, SUCCESS);
    }

    public static <T> Map<String, Object> toFailure(T data, int status) {

        return wrap(data, status, FAILURE);
    }

    public static <T> Map<String, Object> toFailure(T data) {

        return toFailure(data, 500);
    }
}
