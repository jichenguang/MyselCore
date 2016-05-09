package StroeBack;

public class TestAnalysisGet {

	public static String  url = "http://adminprodq.700paper.cn/admin/refreshcache";
	public static String param = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		AnalysisGet  tt = new AnalysisGet();
		tt.sendGet(url, param);
		
		//函数调用时填入URL和参数（参数非必须）就可以获取返回的数据，发送post请求调用示例
		//String result=HttpRequest.sendPost(
		//"<a href="http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=E4805d16520de693a3fe707cdc962045"" 
		//target="_blank">http://api.map.baidu.com/telematics/v3/weather?location=%E5%8C%97%E4%BA%AC&output=json&ak=E4805d16520de693a3fe707cdc962045"
		//</a>,"")
	}

}
