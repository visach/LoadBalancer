package com.test.loadbalancer;

import com.test.loadbalancer.objects.BruteForce;
import com.test.loadbalancer.objects.Tester;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class LoadbalancerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalancerApplication.class, args);

		System.out.println("Welcome to LoadBalancer App");

		IntStream.iterate(10, x -> x + 10).limit(5)
				.forEach(System.out::println);

		//BruteForce bruteForce = new BruteForce();

		Tester tester = new Tester();
	}

}
