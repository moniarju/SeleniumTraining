package org.pojo;

import org.bas.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPojo extends BaseClass {
public FbLoginPojo() {
	PageFactory.initElements(driver, this);
}
	//WebElement email = driver.FindElement(By.id("email"));
	@FindBy(id="email")
	private WebElement email;
	@FindAll({
	@FindBy	(xpath = "//input[@id='email']"),
	@FindBy(xpath = "//input[@name=\"email\"]"),
	@FindBy(xpath = "//input[@data-testid=\"royal_email\"]"),
	
	})
	private WebElement VarRef;
	
	public WebElement getVarRef() {
		return VarRef;
	}
	@FindBy(xpath = "//input[@id='pass']")
	private WebElement password;
	
	@FindBy(name ="login")
	private WebElement loginbutton;

	
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getLoginbutton() {
		return loginbutton;
	}

}

