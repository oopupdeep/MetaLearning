package com.metalearning.base.exception;

import java.io.Serializable;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/2/17 14:28
 */
public class RestErrorResponse implements Serializable {

    private String errMessage;

    public RestErrorResponse(String errMessage){
        this.errMessage= errMessage;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }
}

