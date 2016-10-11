
public class Coordinates {
	int x, y;
	
	Coordinates() { // Default Constructor
		x = 0;
		y = 0;
	}
	
	Coordinates(int inputX, int inputY) { // Constructor with x and y values
		x = inputX;
		y = inputY;
	}
	
	void set(int newX, int newY) { // Set x and y to new values
		x = newX;
		y = newY;
	}
	
	void set(Coordinates newCoords) { // Copy other Coordinates object
		x = newCoords.x;
		y = newCoords.y;
	}
	
	void print() { // Print coordinates
		System.out.print("(" + x + "," + y + ")");
	}
	
	Coordinates getNorth() { // Return coordinates directly north
		return new Coordinates(x, y + 1);
	}
	
	Coordinates getSouth() { // Return coordinates directly south
		return new Coordinates(x, y - 1);
	}
	
	Coordinates getEast() { // Return coordinates directly east
		return new Coordinates(x + 1, y);
	}
	
	Coordinates getWest() { // Return coordinates directly west
		return new Coordinates(x - 1, y);
	}
	
	boolean isEqual(Coordinates a) { // Comparison function
		if(x == a.x && y == a.y)
			return true;
		else
			return false;
	}
}
