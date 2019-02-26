package org.iit.mmp.mmp_iit;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import org.iit.mmp.pages.RegistrationPage;
import org.iit.util.TestBaseClass;
import org.junit.Assert;
import org.testng.annotations.Test;

public class US_005_RegisterPatientTests extends TestBaseClass {

	HashMap<String, String> hMapPatientData;

	firstname
	
	
	@Test
	public void registerPatientTest() throws Exception {

		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		Random rdm = new Random();
		String username = "Test" + rdm.nextInt(999999);
		String password = "Test1234";
		String email = username + "@gmail.com";
		String answer = "Shepherd";

		RegistrationPage regPage = new RegistrationPage(driver);
		hMapPatientData = regPage.register(email, username, password, answer);
		Set<String> setFieldKeys = hMapPatientData.keySet();

		for (String setFieldKey : setFieldKeys) {
			System.out.println("Key : " + setFieldKey + "     Value: " + hMapPatientData.get(setFieldKey));
		}
		 
//		logintoAdmin();
//		approvePatient(SSN);
//		logout()
//		logintoPatient();
//		boolean result = verifyProfilePage(hMapPatientData,Name);
//		Assert.assertTrue(result);
	}
}
