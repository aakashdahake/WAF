package com.constants;

public enum ProjectXpaths {
	loginpage_usernametextbox("//*[@id=\"name\"]"), loginpage_passwordtextbox("//*[@id=\"password\"]"),
	loginpage_submitbutton("//*[@id=\"login-button\"]"),

	screenresolution_dialog("//*[@id=\"resolution-warning-dialog\"]"),
	screenresolution_checkbox("//*[@id=\"confirm-dialog\"]/input"),
	screenresolution_okayButton("//*[@id=\"resolution-warning-dialog\"]/div[2]/div/div[3]/div/div/button"),

	eula_dialog("/html/body/div[21]"), eula_acceptButton("/html/body/div[21]/div[3]/div/button[2]"),
	eula_declineButton("/html/body/div[21]/div[3]/div/button[3]"),

	timeanddate_dialog("/html/body/div[3]/div[2]/div/div[2]/div/section[1]/div[1]"),
	timeanddate_next("/html/body/div[3]/div[2]/div/div[2]/div/section[1]/div[2]/div/input"),
	timeanddate_time_radiobutton("//*[@id=\"dateTimeRadioId\"]"),
	timeanddate_ntp_radiobutton("//*[@id=\"ntpServerRadioId\"]");
	
	
	

	public final String label;

	ProjectXpaths(String label) {
		this.label = label;
	}
}
