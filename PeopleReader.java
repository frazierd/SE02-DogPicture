import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PeopleReader {
    private final String filename;

    public PeopleReader(String filename) {
        this.filename = filename;
    }

    public List<Person> getAllPeople() throws IOException {
        List<Person> people = new ArrayList<>();
        Person person = new Person(firstName, lastName, middleName, age, fear);

        List<String> lines = Files.readAllLines(Path.of(filename));
        for (String line : lines) {
            String index[] = line.split(" ");

            String firstName = index[0];
            if(isInt(index[2])== true){
                String lastName = index[1];
                int age = Integer.parseInt(index[2]);
                String fear = index[3];
                if(index.length == 5){
                    fear = index[3] + " " + index[4];
                }
                else{
                    fear = index[3];
                }
            }
            else{
                String middleName = index[1];
                String lastName = index[2];
                int age = Integer.parseInt(index[3]);
                String fear = index[4];
                if(index.length == 6){
                    fear = index[4] + " " + index[5];
                }
                else{
                    fear = index[4];
                }
                people.add(new Person(firstName, middleName, lastName, age, fear));

            }
            Person person = new Person(firstName, lastName, firstName, 0, firstName);
        }
        return people;
    }
    public boolean isInt(String str){
        try {
            Integer.parseInt(str);
        }catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}