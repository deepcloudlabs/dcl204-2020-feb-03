package com.example.animals.app;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.example.animals.domain.Animal;
import com.example.animals.domain.Cat;
import com.example.animals.domain.Fish;
import com.example.animals.domain.Pet;
import com.example.animals.domain.Spider;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class AnimalsApp {

	public static void main(String[] args) {
		List<Animal> animals = Arrays.asList(new Spider(), new Cat(), new Fish("Free Willy"), new Cat("Garfield"),
				new Fish("Jaws"), new Spider());
		for (Animal animal : animals) {
			animal.walk();
			animal.eat();
			if (animal instanceof Pet) {
				((Pet) animal).play();
			}
		}
		Consumer<Animal> walk = Animal::walk;
		Consumer<Animal> eat = Animal::eat;
		Consumer<Animal> playIfPet = animal -> {
			if (animal instanceof Pet) {
				((Pet) animal).play();
			}
		};
        Function<? super Animal, ? extends Class<?>> toClassMapper = Object::getClass;
		long count = animals.stream()
        		           .map(toClassMapper)
        		           .distinct()
        		           .count();
        System.out.println("count: "+ count);
		animals.stream().forEach(walk.andThen(eat).andThen(playIfPet));
		int totalLegs = animals.stream().mapToInt(Animal::getLegs).sum();
		System.out.println(totalLegs);
		long totalPets = animals.stream().filter(Pet.class::isInstance).count();
		System.out.println(totalPets);
		Map<String,Long> animalGrp =
				animals.stream()
				.collect(
						Collectors.groupingBy(
								toClassMapper.andThen(Class::getSimpleName),
								Collectors.counting()
								)
						);
		System.out.println(animalGrp);
		Map<String,Long> animalGrpLegs =
				animals.stream()
				.collect(
						Collectors.groupingBy(
								toClassMapper.andThen(Class::getSimpleName),
								Collectors.summingLong(Animal::getLegs)
								)
						);
		System.out.println(animalGrpLegs);
		
	}

}
