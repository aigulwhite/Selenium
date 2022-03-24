package TESTNG;
import org.testng.annotations.Test;
public class TestNGIntro {

    // NO MAIN METHOD for testNG

   @Test(priority = 1)
   public void c(){              // this is the METHOD for testNG
       System.out.println("test1");
   }
    @Test(priority = 3)
    public void b(){
        System.out.println("test2");
   }
   @Test(priority = 2)
    public void a(){
       System.out.println("test3");
   }

}
