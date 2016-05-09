package test;

import java.io.IOException;

import com.dbyl.libarary.pageAction.act;
import com.dbyl.libarary.pageAction.makeFiles;

public class testBasePage {
	
    static String path;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		act ACT = new act();
		path = ACT.testPg();
		
		makeFiles mKF = new makeFiles();
		mKF.makefiles(path);
		
	}
	


}
