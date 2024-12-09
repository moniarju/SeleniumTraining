package org.stepdefinition;

import org.bas.BaseClass;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HooksClass extends BaseClass {

@Before
// precondition
private void precondition() {
	
launchBrowser();
windowMaximize();
}

@After
// postcondition
private void postcondition() {
	closeEntireBrowser();

}


}
