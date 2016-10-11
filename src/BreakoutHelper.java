import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class BreakoutHelper {
	BreakoutHelper() throws IOException {
		int lineLeng = 0;
		int count = -1;
		int[][] input = new int[38][35];
		
		
		for (String line : Files.readAllLines(Paths.get("/Users/ianbulovic/Documents/Other/Tech and Programming/Java/HackNEHS/map.txt"))) {
			int templineLeng = line.length();
			if (templineLeng > lineLeng)
				lineLeng = templineLeng;
			count++;
			for (int c = 0; c < lineLeng; c++)
				input[c][count] = line.charAt(c) - '0';
		}
	
		int i = 0;
		for(int x = 0; x < input.length; x++)
			for(int y = 0; y < input[0].length; y ++)
				if(input[x][y] == 1)
					i++;
		int[][] output = new int[i][2];
		int j = 0;
		for(int x = 0; x < input.length; x++)
			for(int y = 0; y < input[0].length; y ++)
				if(input[x][y] == 1) {
					output[j][0] = x;
					output[j][1] = y;
					j++;
				}
		int startX = 0, startY = 0;
		for(int x = 0; x < input.length; x++)
			for(int y = 0; y < input[0].length; y ++)
				if(input[x][y] == 2) {
					startX = x;
					startY = y;
				}
		
		int endX = 0, endY = 0;
		for(int x = 0; x < input.length; x++)
			for(int y = 0; y < input[0].length; y ++)
				if(input[x][y] == 3) {
					endX = x;
					endY = y;
				}
		
        ArrayList<Cell> path = AStar.test(input.length, input[0].length, startX, startY, endX, endY, output);
//        System.out.println(path);
        for(Cell k : path) 
        	input[k.i][k.j] = 4;
        for(int[] l : input) {
        	for(int m : l)
        		if(m == 0)
        			System.out.print(" ");
        		else if(m == 1)
        			System.out.print("•");
        		else if(m == 2)
        			System.out.print("S");
        		else if(m == 3)
        			System.out.print("F");
        		else if(m == 4)
        			System.out.print("°");
        	System.out.println();
        }
	}

}
