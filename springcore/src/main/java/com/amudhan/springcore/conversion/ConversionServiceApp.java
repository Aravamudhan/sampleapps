package com.amudhan.springcore.conversion;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

public class ConversionServiceApp {
	
	private static ApplicationContext context;
	private static TopSellingBook topSellingBook;
	private static ConversionService conversionService;

	public static void main(String[] args) {
		context=new ClassPathXmlApplicationContext("conversionserviceconfig.xml");
		conversionService=(ConversionService) context.getBean("conversionService");

		/*for(String s:context.getBeanDefinitionNames())
			System.out.println(s);*/
		
		topSellingBook=(TopSellingBook)context.getBean("topSellingBook");
		System.out.println(topSellingBook);
		Movie movie=((ConversionService) conversionService).convert(topSellingBook.getBook(), Movie.class);
		System.out.println(movie);
		Documentary documentary=((ConversionService) conversionService).convert(topSellingBook.getBook(), Documentary.class);
		System.out.println(documentary);
		
		String source="one,two,three";
		stringToArray(source,conversionService);
		stringToList(source,conversionService);
	}
	public static void stringToArray(String source,ConversionService conversionService){
		String[] target= conversionService.convert(source, String[].class);
		for(String s:target){
			System.out.print(s+" ");
		}
	}
	public static void stringToList(String source,ConversionService conversionService){
		@SuppressWarnings("unchecked")
		List<String> target= (List<String>)conversionService.convert(source, List.class);
		System.out.println(target);
	}

}
