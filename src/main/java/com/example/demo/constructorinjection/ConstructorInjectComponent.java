package com.example.demo.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * As per the documentation at
 * https://docs.spring.io/spring/docs/current/spring-framework-reference/core.html#beans-autowired-annotation :
 * Only one annotated constructor per class can be marked as required, but
 * multiple non-required constructors can be annotated. In that case, each is
 * considered among the candidates and Spring uses the greediest constructor
 * whose dependencies can be satisfied — that is, the constructor that has the
 * largest number of arguments. The constructor resolution algorithm is the same
 * as for non-annotated classes with overloaded constructors, just narrowing the
 * candidates to annotated constructors.
 * 
 * But I find this to be untrue.
 * 
 */
@Component
@EnableScheduling
public class ConstructorInjectComponent {

	private InjectionServiceOne injectionServiceOne;

	private InjectionServiceTwo injectionServiceTwo;

	private InjectionServiceThree injectionServiceThree;

	public ConstructorInjectComponent() {
	}

	@Autowired(required = true)
	public ConstructorInjectComponent(InjectionServiceOne injectionServiceOne,
			InjectionServiceTwo injectionServiceTwo) {
		this.injectionServiceOne = injectionServiceOne;
		this.injectionServiceTwo = injectionServiceTwo;
	}

//	@Autowired(required = false)
	public ConstructorInjectComponent(InjectionServiceTwo injectionServiceTwo) {
		this.injectionServiceTwo = injectionServiceTwo;
	}

//	@Autowired(required = false)
	public ConstructorInjectComponent(InjectionServiceOne injectionServiceOne) {
		this.injectionServiceOne = injectionServiceOne;
	}

	@Autowired
	public void setInjectionServiceThree(InjectionServiceThree injectionServiceThree) {
		this.injectionServiceThree = injectionServiceThree;
	}

	@Scheduled(fixedRate = 1000L)
	public void allFieldsConstructorInjectionTest() {
		System.err.println("constructorInjection " + injectionServiceOne.method() + " " + injectionServiceTwo.method()
				+ " " + injectionServiceThree.method());
	}

}
