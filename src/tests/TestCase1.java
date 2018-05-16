package tests;

import java.awt.event.KeyEvent;

import org.testng.Assert;
import org.testng.annotations.Test;

import generics.BaseTest;
import generics.GenericMethods;

public class TestCase1 extends BaseTest{
	
	@Test
	public void test1() 
	{
		
		try {
			s.wait("./images/image_rect.png");
			s.find("./images/image_rect.png");
			s.wait("./images/image_tri.png");
			s.find("./images/image_tri.png");
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test()
	public void test2() 
	{
		try {
			String path1=GenericMethods.partialScreenshot("rectangle", 0.35, 0.30);
			String path2=GenericMethods.partialScreenshot("triangle", 0.53, 0.30);
			rob.keyPress(KeyEvent.VK_PAGE_DOWN);
			rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
			s.wait(path1);
			s.find(path1);
			s.wait(path2);
			s.find(path2);
		}
		catch (Exception e) {
			e.getStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void test3() 
	{
		try {
			String path1=GenericMethods.partialScreenshot("rectangle", 0.35, 0.30);
			rob.keyPress(KeyEvent.VK_PAGE_DOWN);
			rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
			s.wait(path1);
			s.find(path1);
		}
		catch (Exception e) {
			Assert.fail();
		}
	}

}
