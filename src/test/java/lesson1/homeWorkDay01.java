package lesson1;

public class homeWorkDay01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ad1 = 4;
		int ad2 = 5;
		int ad3 = 6;		
		View( ad1, ad2, ad3);
		
		
	}

	public static void View(int so1,int so2,int so3) {
		// TODO Auto-generated method stub
		
		int a=so1;
		int b=so2;
		int c=so3;
		
		
		System.out.println("请输入三个数字：");
		int r=a+b-c;
		int w=a+c-b;
		int x=b+c-a;
		if(r>0&&w>0&&x>0){
			System.out.println("两边之和大于第三边，是三角形");
			if(a==b||b==c||a==c){
				System.out.println("两个边相等，是等腰三角形");
			}else if(a==b&&a==c&&b==c){
				System.out.println("三边相等，是等边三角形");
			}
		}else{			
			System.out.println("不是三角形");
		}
		
	}


}
