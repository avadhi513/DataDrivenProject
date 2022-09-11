package org.java;

import java.io.IOException;

public class Integration extends Base{
	public static void main(String[] args) throws IOException {
		
		getDriver();
		
		getUrl("https://www.facebook.com/");
		
		LocatorsLogIn loc=new LocatorsLogIn();
		
		type(loc.getTxtEMail(), getData(1,1));
		
		type(loc.getTxtPwd(), getData(0,2));
		
		btnClick(loc.getFbLoginBtn());
	}

}