package com.test.loadbalancer;

import com.test.loadbalancer.objects.Analyzer;
import com.test.loadbalancer.objects.RandomDataLoadGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class LoadBalancerApplication {
	public static void main(String[] args) {
		SpringApplication.run(LoadBalancerApplication.class, args);

		System.out.println("Welcome to LoadBalancer App");

		Analyzer analyzer = new Analyzer();
		boolean success;
		Scanner in = new Scanner(System.in);

		//First example of exercise
		List<Integer> taskReceived_1 = new ArrayList<>(Arrays.asList(1,3,4,2,2,2,1,1,2));
		System.out.println("Testing first example of exercise: " + taskReceived_1.stream().collect(Collectors.toList()));

		analyzer.Initialize(taskReceived_1);
		success = analyzer.StartAnalysis();
		if (success) {
			System.out.println("Solution found dropping " + analyzer._drop1pos + " and " + analyzer._drop2pos + " positions");
		}
		else{
			System.out.println("Solution not found.");
		}
		//Second example of exercise
		List<Integer> taskReceived_2 = new ArrayList<>(Arrays.asList(1,1,1,1,1,1));
		System.out.println("Testing second example of exercise: " + taskReceived_2.stream().collect(Collectors.toList()));
		analyzer.Initialize(taskReceived_2);
		success = analyzer.StartAnalysis();
		if (success) {
			System.out.println("Solution found dropping " + analyzer._drop1pos + " and " + analyzer._drop2pos + " positions");
		}
		else{
			System.out.println("Solution not found.");
		}

		//Perform optional random analysis?
		System.out.println("Do you want to perform extra random test? (Y / any key to exit)");
		String answer = in.nextLine();
		if (answer.equals("Y")){
			RandomDataLoadGenerator random = new RandomDataLoadGenerator();
			random.Init();
		}
		System.out.println("End of analysis. Bye.");
		System.exit(0);
	}
}
