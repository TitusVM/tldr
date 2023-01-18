package ch.hearc.jee.tldr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true)
@SpringBootApplication
public class TldrApplication {

	public static void main(String[] args) {
		SpringApplication.run(TldrApplication.class, args);
	}

}
