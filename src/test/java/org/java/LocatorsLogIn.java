package org.java;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsLogIn extends Base{
	
	public LocatorsLogIn() {
		PageFactory.initElements(driver,this);
	}
		@CacheLookup
		@FindBy(id="email")
		private WebElement txtEMail;
		
		@FindBy(name="pass")
		private WebElement txtPwd;
		
		@FindBy(xpath="//button[@name='login']")
		private WebElement fbLoginBtn;
		
		
		//right click ---source ---generate getters and setters

		public WebElement getTxtEMail() {
			return txtEMail;
		}

		public WebElement getTxtPwd() {
			return txtPwd;
		}

		public WebElement getFbLoginBtn() {
			return fbLoginBtn;
		}
		
	}
