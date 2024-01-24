package com.maha.Employee_Management_Application.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

//@Component
/*
 * As of Spring Boot 2.2, Spring finds and registers @ConfigurationProperties
 * classes via classpath scanning. Scanning of @ConfigurationProperties needs to
 * be explicitly opted into by adding the @ConfigurationPropertiesScan
 * annotation. Therefore we don’t have to annotate such classes with @Component
 * or @Configuration. The classpath scanner enabled by @SpringBootApplication
 * finds the ConfigProperties class even though we did not annotated this class
 * with @Component.
 * 
 * @ConfigurationProperties – binding the external properties file values with
 * the java classes.
 */
@ConfigurationProperties(prefix = "notify.email")
public class ApplicationConfiguration {
	private String from;
	private String to;
	private String smtpHost;
	private String smtpPort;

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSmtpHost() {
		return smtpHost;
	}

	public void setSmtpHost(String smtpHost) {
		this.smtpHost = smtpHost;
	}

	public String getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(String smtpPort) {
		this.smtpPort = smtpPort;
	}

}
