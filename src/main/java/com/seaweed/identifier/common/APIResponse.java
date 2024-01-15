package com.seaweed.identifier.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class APIResponse {
    public APIResponse() {
        this.status = Status.Ok;
    }

    public static enum Status {
        Ok(0),
        Failed(1),
        Error(2);


        private int status;
        public int getStatus() {
            return status;
        }
        private Status(int number) {
            this.status = number;
        }
    }
    private String message;
    private Status status;
    private Object data;

    public APIResponse(Status status, String message){
        this.message = message;
        this.status = status;
    }
    public APIResponse(Status status, String message, Object data){
        this.message = message;
        this.status = status;
        this.data = data;
    }
}
