
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class RoomReader {
    public static List<Room> readRooms(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException
    {
        List<Room> list = new ArrayList<Room>();
        
        FileInputStream fis = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fis); 
        
        while(true)
        {
            try{
            Object obj = ois.readObject();
            Room room = (Room)obj;
            list.add(room);
            }catch(EOFException eof){
                break;
            }
            
        }
        ois.close();
        return list;
    }
}
