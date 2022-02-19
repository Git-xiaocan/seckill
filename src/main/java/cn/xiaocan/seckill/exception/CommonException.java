package cn.xiaocan.seckill.exception;


import cn.xiaocan.seckill.result.CodeMsg;

public class CommonException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private CodeMsg cm;
	
	public CommonException(CodeMsg cm) {
		super(cm.toString());
		this.cm = cm;
	}
	public CodeMsg getCm() {
		return cm;
	}

}
