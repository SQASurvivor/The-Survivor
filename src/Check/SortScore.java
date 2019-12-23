package Check;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SortScore {
	private File file;
	private int count;
	private int[] score;
	
	/**
	 * Constructor
	 * @param filename the name of the file
	 */
	public SortScore(String filename) {
		file = new File(filename);
		count = Filesize(file);
	}
	
	/**
	 * Sort the array with descending order
	 * @return the sorted array which contains the sorted score
	 * @throws IOException if file cannot open or cannot be found
	 */
	public int[] sortArray() throws IOException{
		Scanner scanner = new Scanner(file);
		int[] arr = new int[count];
		for(int i = 0; i < count; i++) {
			int score = Integer.parseInt(scanner.next());
			arr[i] = score;
		}
		scanner.close();
		for(int i = 0; i < count - 1; ++i) {
			for(int j = i + 1; j < count; ++j) {
				if (arr[i] < arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		return arr;
	}
	
	/**
	 * Get the count of data in the file
	 * @param file which stores the score
	 * @return the count
	 */
	private int Filesize(File file) {
		int size = 0;
        try (Scanner input = new Scanner(file)){
            while(input.hasNext()) {
                input.next();
                size = size + 1;
            }
        }
        catch (FileNotFoundException exc) {
            System.out.println("File not found.");
        }
        return size;
	}
	
	/**
	 * Getter
	 * @return the number of score
	 */
	public int getSize() {
		return count;
	}
}
