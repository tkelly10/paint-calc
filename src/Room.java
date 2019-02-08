
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable{

    private ArrayList<Wall> wallList;
    
    private static int roomCount = 0;
    
    private  int roomNum = 0;

    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
        roomCount++;
        roomNum = roomCount;
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }
   
    @Override
   public String toString()
   {
       StringBuilder sb = new StringBuilder();
       sb.append("Room: ");
       sb.append(roomNum).append("\n");
       sb.append(getArea()).append("\n");
       
       return sb.toString();
   }
    
}
