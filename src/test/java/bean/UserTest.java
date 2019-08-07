package bean;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
	
   @Test
    public void testVerifyIsOwner() throws Exception {
       boolean expectedValue = true;
       UserBean app=new UserBean();
       boolean actualValue=app.isOwnerUser("wara");
       assertEquals(expectedValue, actualValue);
    }
   
   @Test
   public void testVerifyUserOnlyString() throws Exception {
      boolean expectedValue = true;
      UserBean app=new UserBean();
      boolean actualValue=app.onlyChars("wara");
      assertEquals(expectedValue, actualValue);
   }   
   
   @Test
   public void testVerifyuserNoMoreThanSixChars() throws Exception {
      boolean expectedValue = true;
      UserBean app=new UserBean();
      boolean actualValue=app.userNoMoreThanSixChars("Teresa");
      assertEquals(expectedValue, actualValue);
   }   
}