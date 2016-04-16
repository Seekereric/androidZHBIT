interface IStringDeal{
	public String filterBlankChar();
}

public class OutString {
	public static void main(String[] args){
		final String origin = "ha ha ha ha ha";
		IStringDeal s = new IStringDeal(){
			public String filterBlankChar(){
				String result = origin.replace(" ", "");
				return result;
			}
		};
		System.out.println(origin);
		System.out.println(s.filterBlankChar());
	}
}
