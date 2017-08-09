package com.jiang.zheng.yan.goldscissorslibrary;

public class InjectException extends RuntimeException {
	private static final long serialVersionUID = -8782914729012957108L;

	public InjectException() {

	}

	public InjectException(String detailMessage, Throwable throwable) {
		super(detailMessage, throwable);
	}

	public InjectException(String detailMessage) {
		super(detailMessage);
	}

	public InjectException(Throwable throwable) {
		super(throwable);
	}

}
