package org.pojo;

import org.bas.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;//input[@id='u_0_8_Hq']

public class SigninPojo extends BaseClass {
public SigninPojo() {
PageFactory.initElements(driver, this);


}


@FindBy(xpath="//a[@id='u_0_0_e0']")
private WebElement createNewAccount;

@FindBy(xpath="//input[@id='u_0_8_Hq']")
private WebElement firstNmeTxtBox;

@FindBy(xpath="//input[@id='u_0_a_5B']")
private WebElement secondNameTxtBox;

@FindBy(xpath="//input[@id='u_0_h_B2']")
private WebElement mobileNumberorEmailTextBox;

@FindBy(xpath="//input[@id='password_step_input']")
private WebElement newpassword;

public WebElement getCreateNewAccount() {
	return createNewAccount;
}

public void setCreateNewAccount(WebElement createNewAccount) {
	this.createNewAccount = createNewAccount;
}

public WebElement getFirstNmeTxtBox() {
	return firstNmeTxtBox;
}

public void setFirstNmeTxtBox(WebElement firstNmeTxtBox) {
	this.firstNmeTxtBox = firstNmeTxtBox;
}

public WebElement getSecondNameTxtBox() {
	return secondNameTxtBox;
}

public void setSecondNameTxtBox(WebElement secondNameTxtBox) {
	this.secondNameTxtBox = secondNameTxtBox;
}

public WebElement getMobileNumberorEmailTextBox() {
	return mobileNumberorEmailTextBox;
}

public void setMobileNumberorEmailTextBox(WebElement mobileNumberorEmailTextBox) {
	this.mobileNumberorEmailTextBox = mobileNumberorEmailTextBox;
}

public WebElement getNewPassword() {
	return newpassword;
}

public void setNewPassword(WebElement newPassword) {
	this.newpassword = newPassword;
}





}
