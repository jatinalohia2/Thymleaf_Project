package com.techtamasha.techtamasha.testing;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.techtamasha.techtamasha.beans.Banana;
import com.techtamasha.techtamasha.beans.Weather;

@Configuration
public class Config {
	
	// exp. creattion method :
	
	@Bean
	public Weather weather() {
		return new Weather();
	}

	@Bean
	public Banana banana() {
		return new Banana();
	}
	
	
}
