package com.greatlearning.dsa.assignment.architect.driver;

import java.util.Scanner;
import com.greatlearning.dsa.assignment.architect.buildFloorLogic.BuildFloor;

public class DriverClass extends IllegalArgumentException{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		BuildFloor objBuild;
		int n;
		try {
			//User input for total number of floors
			System.out.println("Enter the total number of floors in the building:");
			n=sc.nextInt();
			//Calling constructor to define floor array
			objBuild=new BuildFloor(n);
			for(int i=0; i<n;i++) {
				//User input for floor details on each day
				System.out.println("\nEnter the floor size given on day "+(i+1)+": ");
				objBuild.getFloorInputs(sc.nextInt(),i);
			}
			//Calculating floor sequence as per conditions given in problem statement
			objBuild.calculateFloorSequence();
		}
		catch (IllegalArgumentException e) {
			System.out.println("Please input only positive numbers");
			sc.next();
		}
		finally {
			sc.close();
		}
	}

}
