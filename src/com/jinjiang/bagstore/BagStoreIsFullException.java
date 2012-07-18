package com.jinjiang.bagstore;

public class BagStoreIsFullException extends RuntimeException {
    public BagStoreIsFullException() {
    }

    public BagStoreIsFullException(String msg) {
        super(msg);
    }
}
