package com.metalearning.base.exception;

/**
 * @author wang
 * @version 1.0
 * @description TODO
 * @date 2023/2/17 14:21
 */
public class MetalearningException extends RuntimeException {
    private String errMessage;

    public MetalearningException() {
        super();
    }

    public MetalearningException(String message) {
        super(message);
        this.errMessage = message;
    }

    public String getErrMessage(){
        return errMessage;
    }

    public static void cast(String errMessage){
        throw new MetalearningException(errMessage);
    }
    public static void cast(CommonError commonError){
        throw new MetalearningException(commonError.getErrMessage());
    }
}
