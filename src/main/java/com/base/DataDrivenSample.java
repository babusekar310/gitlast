package com.base;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class DataDrivenSample extends BaseClass {
	
	public static void main(String[] args) throws IOException {
		browserInteract();
		openUrl("https://www.facebook.com/");
		toMaximize();
		WebElement usrEmail = driver.findElement(By.id("email"));
		usrEmail.sendKeys(excelData(3, 1));
		WebElement usrPass = driver.findElement(By.id("pass"));
		usrPass.sendKeys(excelData(3, 2));
	}


}
