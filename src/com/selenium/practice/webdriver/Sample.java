package com.selenium.practice.webdriver;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Dog implements Comparable<Dog> {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Dog dog) {

		return this.age - dog.age;
	}

}

class Cat implements Comparable<Cat> {
	private String name;
	private Integer age;

	public Cat(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int compareTo(Cat cat) {
		return this.age - cat.age;
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

}

public class Sample {
	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Dog dog1 = new Dog();
		dog1.setName("Dog1");
		dog1.setAge(3);

		Dog dog2 = new Dog();
		dog2.setName("Dog2");
		dog2.setAge(1);

		Dog dog3 = new Dog();
		dog3.setName("Dog3");
		dog3.setAge(6);

		Dog dog4 = new Dog();
		dog4.setName("Dog4");
		dog4.setAge(4);

		Dog dog5 = new Dog();
		dog5.setName("Dog5");
		dog5.setAge(2);

		List<Dog> dogList = new ArrayList<>();
		dogList.add(dog1);
		dogList.add(dog2);
		dogList.add(dog3);
		dogList.add(dog4);
		dogList.add(dog5);

		Collections.sort(dogList);
		System.out.println(dogList);

		List<Cat> catList = new ArrayList<>();
		catList.add(new Cat("cat1", 2));
		catList.add(new Cat("cat2", 6));
		catList.add(new Cat("cat3", 7));
		catList.add(new Cat("cat4", 4));
		catList.add(new Cat("cat5", 3));
		Collections.sort(catList);
		System.out.println(catList);

		Map<Integer, Integer> ageMap = new HashMap<>();
		for (int i = 0; i < dogList.size(); i++) {

			Cat cat = catList.get(i);
			Field age = cat.getClass().getDeclaredField("age");
			age.setAccessible(true);
			int ageOfcat = (Integer) age.get(cat);
			ageMap.put(ageOfcat, dogList.get(i).getAge());
		}
		System.out.println("print ageMap in ascending order");
		System.out.println(ageMap);
	}
}
