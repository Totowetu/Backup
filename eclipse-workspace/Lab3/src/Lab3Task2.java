import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
public class Lab3Task2 {
	//runningSum2DArray(int[][] array, int dir) ​across rows (left to right or right to left)
	//or columns (top to bottom or bottom to top)  

	public static void runningSum2DArray(int[][] array, int dir) {
		//int[][] multi = new int[4][4];
		int sum=0;
		int column = 0; //to make them  a
		int row;
		//if(dir==2) move right while summing up each next item **
		if(dir==2) {
			for (row = 0; row < array.length; row++) { 

				for ( column = 0; column < array[row].length; column++) {

					sum += array[row][column];

					System.out.print(sum +  "\t");	
					//10 15 30 40;15 5 8 2;20 2 4 2;1 4 5 0
				}
				//if a new row reset sum to 0
				sum=0;
				//then start printing on a new line 
				System.out.println();
			}}
		
		
		//if(dir==1) move left as u add
		else if(dir==1) {
			for (row = array.length-1; row >=0 ; row--) { 

				for ( column = array.length-1; column >=0 ; column--) {
					
					sum+=array[row][column];
					array[row][column]=sum;
				}
				sum=0; //if a new row reset sum to 0 
				//System.out.println();	 //then start printing on a new line
			}
			for (row = 0; row < array.length; row++) { 
				for ( column = 0; column < array[row].length; column++) {
					System.out.print(array[row][column]+"\t");
					
				}
				System.out.println();
				}
				}
			
		
		
		
		
		//if(dir==3) move UP while summing up each next item 
	else if(dir==3) {
		for ( column = 0; column < array.length; column++) {
		for(row=array.length-1;row>=0;row--) {
			sum+=array[row][column];
			array[row][column]=sum;
		}
		sum=0;	
		}
		for(row=0;row<array.length;row++) {
		for ( column = 0; column < array[row].length; column++) {
			
				System.out.print(array[row][column]+"\t");	
			}
			System.out.println();
		}
		}
	
	
		//if(dir==4) move DOWN while summing up each next item 
	if(dir == 4) { //move down while summing each element 
		for ( column = 0; column < array.length; column++) { 
			for (row = 0; row < array[column].length; row++) {
				sum += array[row][column];
				array[row][column] = sum; 
			}
			sum = 0;
		}
		for( row = 0; row < array.length; row++) {
			for(column = 0; column < array[row].length; column ++) {
				System.out.print(array[row][column] + "\t");
			}
			System.out.println(); 
		}
	}

	}	
public static void runningSum2DArrayList(ArrayList<ArrayList <Integer > > list, int dir) { 
	//sum to right (2)
	int sum =0;
	if(dir==2) {
	for (int row = 0; row < list.size(); row++) { 
		for (int column = 0; column < list.get(row).size(); column++) {
			sum+=list.get(row).get(column);
			System.out.print(sum+ "\t");

		}
		sum=0;
		System.out.println();
	}}
	//sum from left (1)
	else if(dir==1) {
		for(int row=list.size()-1; row>=0; row--){
			for(int column=list.get(row).size()-1; column>=0; column--){
			   	
				sum+=list.get(row).get(column);
				list.get(row).set(column, sum);
				
				
			}
			
			sum=0;
			    }
			for(int row=0;row<list.size();row++) {
				for (int column = 0; column < list.get(row).size(); column++) {
					System.out.print(list.get(row).get(column)+ "\t");
				}
				System.out.println();
				}
				
			}
			
			
	//if (3)move UP while summing
else if(dir==3) {
	for ( int column = 0; column < list.size(); column++) {
		for(int row=list.size()-1;row>=0;row--) {
			sum+=list.get(row).get(column);
			list.get(row).set(column, sum);
			//sum+=array[row][column];
			//array[row][column]=sum;
		}
		sum=0;	
		}
		for(int row=0;row<list.size();row++) {
		for ( int column = 0; column < list.get(row).size(); column++) {
			
				System.out.print(list.get(row).get(column)+"\t");	
			}
			System.out.println();
		}
	
		
	
}
//	//if (4) move DOWN summing
else if(dir==4) {
	for (int column = 0; column < list.size(); column++) { 
		for (int row = 0; row < list.get(column).size(); row++) {
			sum += list.get(row).get(column);
			list.get(row).set(column, sum);
		}
		sum = 0;
	}
	for(int row = 0; row < list.size(); row++) {
		for(int column = 0; column < list.get(row).size(); column ++) {
			System.out.print(list.get(row).get(column)+ "\t");
		}
		System.out.println(); 
	}
}
	
}

	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input arrays with ";" between them
		String[] temp = scanner.nextLine().split(";");

		//input integers with white space between them
		int[][] arr = new int[4][4];
		for(int i = 0; i < 4; i++){
			String[] tempA = temp[i].split("\\s");
			for(int j = 0; j < 4; j++){
				arr[i][j] = Integer.parseInt(tempA[j]);
			}
		}

		
		
				//input integers with white space between them
				ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
				for(int i = 0; i < 4; i++){
					String[] tempA = temp[i].split("\\s");
					list.add(i, new ArrayList<Integer>());
					for(int j = 0; j < 4; j++){
						list.get(i).add(j, Integer.parseInt(tempA[j]));
					}
				}

		runningSum2DArray(arr, 1);
		runningSum2DArray(arr, 2);
		runningSum2DArrayList(list, 3);
		runningSum2DArrayList(list, 4);
				
		scanner.close();


	}

}
