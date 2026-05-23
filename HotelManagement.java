import java.util.ArrayList;
import java.util.Scanner;
class Guest{
    String name;
    int id;
    Guest(String name,int id){
        this.id = id;
        this.name = name;
    }
}
public class HotelManagement {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String[] firstLines = firstLine.split(" ");
        int N = Integer.parseInt(firstLines[0]);
        int C = Integer.parseInt(firstLines[1]);
        ArrayList<Guest> guestList = new ArrayList<>();
        ArrayList<Guest> waitList = new ArrayList<>();
        for(int i=0;i<N;i++){
            String line = scanner.nextLine();
            String[] lines = line.split(" ");
            if(lines.length!=3){
                System.out.println("Invalid Value");
                return;
            }
            if(lines[0].equals("IN") && C>=guestList.size()){
                guestList.add(new Guest(lines[1],Integer.parseInt(lines[2])));
            }
            else if(lines[0].equals("IN") && C<guestList.size()){
                waitList.add(new Guest(lines[1],Integer.parseInt(lines[2])));
            }
            else if(lines[0].equals("OUT") && !guestList.isEmpty()){
                for(int j=0;j<guestList.size();j++){
                    if(Integer.parseInt(lines[2]) == guestList.get(j).id) guestList.remove(j);
                }
                if(!waitList.isEmpty()){
                    guestList.add(waitList.get(0));
                    waitList.remove(0);
                }
            }
        }
        for(Guest guest:guestList){
            System.out.println(guest.id+" "+guest.name);
        }
    }
}
