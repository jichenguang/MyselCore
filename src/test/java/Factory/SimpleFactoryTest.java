package Factory;

/*

* 测试客户端

*/

public class SimpleFactoryTest {

   public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
       //实例化各种食物
	   //?为什么要在工厂中进行实例化？
       Food mcChicken = FoodFactory.getFood("McChicken");
       Food chips = FoodFactory.getFood("Chips");
       Food eggs = FoodFactory.getFood("Eggs");
       //获取食物
       if(mcChicken!=null){
           mcChicken.get();
       }
       if(chips!=null){
           chips.get();
       }
       if(eggs!=null){
           eggs.get();
       }
   }
} 