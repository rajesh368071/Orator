package com.Utility;


import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import com.github.javafaker.FunnyName;
import com.github.javafaker.Internet;
import com.github.javafaker.Name;
import com.github.javafaker.PhoneNumber;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import net.bytebuddy.implementation.bytecode.assign.primitive.VoidAwareAssigner;

public class FakeData {
	
	Faker fakedata = new Faker(new Locale("en-IN"));
	FakeValuesService fakeservice = new FakeValuesService(new Locale("en-US"), new RandomService());
	
	public String getFirstName() {
		return fakedata.name().firstName().toString();
	}
	
	public String getLastname() {
		return fakedata.name().lastName().toString();
	}
	
	public String getEmail() {
		return fakeservice.bothify("????##@yopmail.com");
	}
	
	public String getPhone() {
		//fakedata.number().digits(10);
		return "9"+fakedata.number().digits(9).toString();
	}
	
	public String getRandom() {
		return fakedata.company().name();
	}
	
	public String getMessage() {
		return fakedata.backToTheFuture().quote();
	}
	
	public String getSubject() {
		return fakedata.book().title();
	}
	
	public String getCompany() {
		return fakedata.company().name();
	}

	
}
