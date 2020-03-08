package com.brij;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;

//@Configuration
//@ComponentScan("com.brij")
@SpringBootApplication
public class SpringBootProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
		
		 Logger log=Logger.getLogger(SpringBootProjectApplication.class.getName());
	       log.debug("Debug");
	       log.info("Info");
	       log.warn("Wan");
	       log.fatal("Fatal");
	       
	       System.out.println("Done");
	}

}
