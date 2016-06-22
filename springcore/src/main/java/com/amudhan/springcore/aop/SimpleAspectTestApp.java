package com.amudhan.springcore.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.amudhan.springcore.autowiring.Movie;
import com.amudhan.springcore.autowiring.MovieCatalogue;
import com.amudhan.springcore.validation.Contact;


public class SimpleAspectTestApp {
	
	public static void main(String[] args){
		ApplicationContext context = new AnnotationConfigApplicationContext(AspectConfig.class);
		Contact contact = (Contact)context.getBean("contact");
		contact.setMailId("testmail@mail.com");
		contact.getMailId();
		
		Movie movie=(Movie)context.getBean("movie");
		movie.setName("Godfather");
		movie.getName();
	}
}
