/*
	This is the Geb configuration file.
	
	See: http://www.gebish.org/manual/current/configuration.html
*/


import org.openqa.selenium.firefox.FirefoxProfile
// import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
// import org.openqa.selenium.chrome.ChromeDriver

// Use htmlunit as the default
// See: http://code.google.com/p/selenium/wiki/HtmlUnitDriver
driver = { 
//	def driver = new HtmlUnitDriver()
//	driver.javascriptEnabled = true
//	if (System.getProperty('ZAP_PROXY_HOST') && System.getProperty('ZAP_PROXY_PORT')) {
//	    String zapProxyHost = System.getProperty('ZAP_PROXY_HOST')
//	    int zapProxyPort = System.getProperty('ZAP_PROXY_PORT').toInteger()
//	    driver.setProxy(zapProxyHost, zapProxyPort)
//	}
//	driver

	FirefoxProfile profile = new FirefoxProfile()
	profile.setPreference("intl.accept_languages", "en-us")
	if (System.getProperty('ZAP_PROXY_HOST') && System.getProperty('ZAP_PROXY_PORT')) {
		int port = System.getProperty('ZAP_PROXY_PORT').toInteger()
		profile.setPreference("network.proxy.type", 1)
		profile.setPreference("network.proxy.http", System.getProperty('ZAP_PROXY_HOST'))
		profile.setPreference("network.proxy.http_port", port)
	}
	profile.enableNativeEvents = false

	def driverInstance = new FirefoxDriver(profile) 
	driverInstance.manage().window().maximize() 
	driverInstance
}

baseNavigatorWaiting = true
atCheckWaiting = true

/*
environments {

	// run as “grails -Dgeb.env=chrome test-app”
	// See: http://code.google.com/p/selenium/wiki/ChromeDriver
	chrome {
		driver = { new ChromeDriver() }
	}
	
	// run as “grails -Dgeb.env=firefox test-app”
	// See: http://code.google.com/p/selenium/wiki/FirefoxDriver
	firefox {
		driver = { new FirefoxDriver() }
	}

}
*/