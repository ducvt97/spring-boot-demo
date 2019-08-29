package com.example.test;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@SpringBootApplication
@Import(AppConfig.class)
@SpringBootConfiguration
@EnableAutoConfiguration
public class TestApplication implements BundleActivator {


	//private ConfigurableApplicationContext appContext;

	@Override
	public void start(BundleContext bundleContext) throws Exception {

		System.out.println("STARTING DEMO...");
		try{
			//Thread.currentThread().setContextClassLoader(this.getClass().getClassLoader());
			System.out.println("setContextClassLoader...");

			/*appContext = */
			SpringApplication.run(TestApplication.class);
			System.out.println("appContext...");

		}catch (Exception e){
			throw e;
		}

		System.out.println("STARTING DEMO222...");
		//SpringApplication.run(TestApplication.class,null);
		//System.out.println("STARTING DEMO: hello, world");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("STOPPING DEMO");
	}
/*
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}
*/

}
