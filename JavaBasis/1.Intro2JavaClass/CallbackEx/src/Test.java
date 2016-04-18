interface ICallBack{
	void postExec();
}

class FooBar{
	private ICallBack callBack;
	
	public void setCallBack(ICallBack callBack){
		this.callBack = callBack;
	}
	public void doSth(){
		callBack.postExec();
	}
}

public class Test {
	public static void main(String[] args){
		FooBar foo = new FooBar();
		foo.setCallBack(new ICallBack(){
			public void postExec(){
				 System.out.println("method done");
			}
		});
		foo.doSth();
	}
}
