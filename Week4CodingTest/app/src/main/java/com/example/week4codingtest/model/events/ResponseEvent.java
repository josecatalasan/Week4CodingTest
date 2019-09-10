package com.example.week4codingtest.model.events;


import com.example.week4codingtest.model.response.Response;

import java.util.List;

public class ResponseEvent {
    List<Response> responseList;

    public List<Response> getResponseList() {
        return responseList;
    }

    public void setResponseList(List<Response> responseList) {
        this.responseList = responseList;
    }

    public ResponseEvent(List<Response> responseList) {
        this.responseList = responseList;
    }
}
