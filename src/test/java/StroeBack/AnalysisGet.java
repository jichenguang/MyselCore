package StroeBack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
 
public class AnalysisGet {
    /**
     * 向指定URL发送GET方法的请求
     * 
     * @param url
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String url, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            
            
            /**
             * @author 700sfriend
             * 设置为外送模式
             */
            connection.setDoOutput(true);
            
            
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:44.0) Gecko/20100101 Firefox/44.0");
            connection.setRequestProperty("Cookie", "ASP.NET_SessionId=d4zgawxlfh3qlvmyib0c2auq; selprono=110000; upcart=333; goods=%7b%22Total%22%3a3299"+".00%2c%22ToPay%22%3a3299.00%2c%22Data%22%3a%5b%7b%22CartId%22%3a3215%2c%22SkuId%22%3a341%2c%22Quantity"+
"%22%3a1%7d%2c%7b%22CartId%22%3a3216%2c%22SkuId%22%3a342%2c%22Quantity%22%3a1%7d%2c%7b%22CartId%22%3a3219"+
"%2c%22SkuId%22%3a333%2c%22Quantity%22%3a1%7d%5d%7d");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
//            System.out.println("获取的内容："+connection.getContent());
            
            
            /**
    		 * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
    		 */
    		OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(),"8859_1");
    		out.write("username=administrator&password=111111"); //post的关键所在！
    		// remember to clean up
    		out.flush();
    		out.close();
    		/**
    		 * 这样就可以发送一个看起来象这样的POST： 
    		 * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:
    		 * text/plain Content-type: application/x-www-form-urlencoded
    		 * Content-length: 99 username=bob password=someword
    		 */
            
            
            
            
            
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.out.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream(),"8859_1"));
            String line;
            while ((line = in.readLine()) != null) {
                System.out .println("----------------------------------------------------------");
                result += line;
                System.out .println("###########################################################");
            }
        } catch (Exception e) {
            System.out.println("发送GET请求出现异常！" + e);
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
 
    /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("User-Agent","Mozilla/5.0 (Macintosh; Intel Mac OS X 10.11; rv:44.0) Gecko/20100101 Firefox/44.0");
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(param);
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }    
}
