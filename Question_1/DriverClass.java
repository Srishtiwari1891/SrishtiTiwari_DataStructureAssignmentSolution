package com.greatlearning.dsa.assignment.bst.driver;

import java.util.Scanner;

import com.greatlearning.dsa.assignment.bst.skewedlogic.PrepareSkewedBST;

public class DriverClass extends  IllegalArgumentException {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		PrepareSkewedBST objSkew;
		int n;
		try {
			objSkew=new PrepareSkewedBST();			
			//Get number of nodes in the BST
			System.out.println("No. of nodes in BST:");
			n=sc.nextInt();
			
			//Insert nodes in BST
			System.out.println("Enter Tree nodes(by level)");
			for(int i=1;i<=n;i++)
				objSkew.insertNode(sc.nextInt());	
			
			//Method to convert to Skewed tree			
			objSkew.createSkewedTree();
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
