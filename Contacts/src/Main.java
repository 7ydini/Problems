import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        ArrayList<String> contacts = new ArrayList<>();
        IntStream.range(0, n).forEach(nItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String op = firstMultipleInput[0];

                String contact = firstMultipleInput[1];
                Contacts(contacts, op, contact);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    public static ArrayList<String> Contacts(ArrayList<String> contacts, String partial, String name){
        switch (partial){
            case ("add"):{
                if(!contacts.contains(name)){
                    contacts.add(name);
                    break;
                }
            }
            case ("find"):{
                int count = 0;
                for (String contact :
                        contacts) {
                    if(contact.startsWith(name.toLowerCase())){
                        count++;
                    }
                }
                System.out.println(count);
            }
        }
        return contacts;
    }
}
