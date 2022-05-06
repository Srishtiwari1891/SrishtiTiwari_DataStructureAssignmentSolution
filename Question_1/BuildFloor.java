package com.greatlearning.dsa.assignment.architect.buildFloorLogic;

import java.util.Stack;

public class BuildFloor {

	public int floorNum[], sortedFloors[], totalFloors;

	public BuildFloor(int n) {
		this.floorNum = new int[n];
		this.sortedFloors = new int[n];
	}

	public void getFloorInputs(int floor, int i) {
		floorNum[i] = floor;
	}

	public void calculateFloorSequence() {
		int j = 0;
		sortedFloors=floorNum.clone();
		// Sort floor in reverse order. For some reason, Arrays.sort(sortedFloors,Collections.reverseorder()) 
		// was not working here hence using user defined method for sorting
		sortFloors();
		Stack<Integer> floorStack = new Stack<Integer>();
		for (int i = 0; i < floorNum.length; i++) {
            if (floorNum[i] == sortedFloors[j]) {
                if (i == floorNum.length - 1) j = i;
                else j = i + 1;

                // Print the current floor and pop value from stack to print values until its empty 
                System.out.println("Day " + (i + 1)+":");
                if (floorStack != null) {
                    System.out.print(floorNum[i] + " ");
                    while (!floorStack.isEmpty()) {
                        int data = floorStack.pop();
                        if (data >= sortedFloors[j]) {
                            System.out.print(data + " ");
                        } else {
                            floorStack.push(data);
                            j -= floorStack.size();
                            break;
                        }
                    }
                    System.out.println("");
                } else {
                    System.out.println(floorNum[i]);
                }
            } else
            // Push element to stack until the if condition satisfies
            {
                System.out.println("Day " + (i + 1)+": ");
                floorStack.push(floorNum[i]);
            }
        }
	}
	
	public void sortFloors() {
		for (int i=0;i<floorNum.length; i++){
			for(int j=i+1;j<floorNum.length;j++) {
				if(floorNum[i]<floorNum[j]) {
					sortedFloors[i]=floorNum[j];
					sortedFloors[j]=floorNum[i];
				}
			}
		}
	}
}
