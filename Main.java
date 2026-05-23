import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            String line = br.readLine();
            if(line == null||line.trim().isEmpty()) {
                System.out.println(0);
                return;
            }
            String cleaned = line.replaceAll("[\\[\\]]","").trim();
            String[] tokens = cleaned.split("[,\\s]+");
            ArrayList<Integer> arr = new ArrayList<>();
            for(String s:tokens){
                arr.add(Integer.parseInt(s));
            }
            for(int i:arr) System.out.println(i);
        }
        catch(Exception e){
            System.out.println("exception");
            return;
        }
    }
}
