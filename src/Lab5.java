
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.*;

import java.util.function.Predicate;
import java.util.stream.Collectors;



/**
 * Lab 5
 *
 * Write a program to read in the data from seinfeld_scripts.csv then use streams to answer the following questions
 *
 * You can make use of the file ShowLine to help with this task
 *
 *
 * TODO 1:
 * Read in the lines of the file into a List<ShowLine> object
 *
 * TODO 2:
 * 2. print the Count of total number of entries
 *
 *
 * TODO 3:
 * 3. Use streams to determine the total number of lines for each of the main characters (JERRY, ELAINE, KRAMER and GEORGE)
 * store the values in a Map<String, Long> where the key is the Character Name and the Long is the count
 * - ignore the odd variation in names and just count pure instances of each main Character
 *     i.e., ignore character names like "GEORGE (telling Elaine)" but count character names like "GEORGE"
 *
 *    Print this Map out
 *
 * TODO 4:
 *
 * 4. Repeat the goal of 3. but this time collect into the Map the Characters NEWMAN, PUDDY, SUSAN and BANIA
 * for this task create a higher order function called matchCharacters that takes in a variable size array and returns a
 * Predicate indicating whether the .getCharacter() attribute matches any from the argument list
 *
 * Use your higher Order function to solve this task
 *
 *
 * Hint: Your higher order function header might look like this:
 *
 * //characters is an array of characters for which the predicate will return true if
 * //the ShowLine character name matches
 * public static Predicate<ShowLine> matchesAnyCharacter(String ... characters)
 *
 *
 * Add your favorite character to the list if you like - if you have no favorite character you can add UNCLE LEO and
 * repeat the search
 *
 *
 * TODO 5:
 *
 * 5. Repeat step 4 except using a parallel stream and get an estimate of the time required for this by using:
 *
 *    long start = System.nanoTime()
 *    //do work
 *
 *    long stop = System.nanoTime()
 *
 *    long durationMS = stop - start / 1000000.0;
 *
 *    compare that to the time required without parallel streams
 *
 *
 * TODO 6:
 * Determine the average words per line for each of Elaine and Jerry For this task map the ShowLines to a primitive stream and
 *    let's assume every word is separated by a space in his dialogue. Thus s->s.split(" ").length would give the number of words as an int
 *    for a line of text. Get this average
 *
 * Answer the question of who on average got the longer lines, Jerry or Elaine
 *
 *
 */
public class Lab5 {

    public static ShowLine toShowLine(String s) {
        String[] sArr = s.split(",");
        return new ShowLine(sArr[1],sArr[2],Integer.valueOf(sArr[3]),Integer.valueOf(sArr[5]));
    }



    //4. a higher order function that determines if a provided ShowLine s has a charactername
    //the matches any from the list of characters


    public static Predicate<ShowLine> matchesAnyCharacter(String ... characters) {

        //remember s is the value that is provided through your stream below is a lambda expression
        //matching the Predicate<ShowLine> requirements
        return s->

        {
            for (int i = 0; i < characters.length; i++)
            {
                if(characters[i].equals(s.getCharacter()))
                    return true;
            }
                    return false;
        };

    }




    //public static Function<String, String> matchesCharacter<


    public static void main(String [] args) throws IOException {
        Predicate<ShowLine> x = matchesAnyCharacter("JERRY");
        //1. Read in the data
        Scanner scan = new Scanner(new File("seinfeld_scripts.csv"));
        String currentLine;
        List<ShowLine> lineList = new ArrayList<>();


        while(scan.hasNextLine())
        {
            currentLine = scan.nextLine();
            lineList.add(toShowLine(currentLine));
        }

        //2.
        long countEntries = lineList.stream().count();
        /**
 * 3. Use streams to determine the total number of lines for each of the main characters (JERRY, ELAINE, KRAMER and GEORGE)
                * store the values in a Map<String, Long> where the key is the Character Name and the Long is the count
 * - ignore the odd variation in names and just count pure instances of each main Character
 *     i.e., ignore character names like "GEORGE (telling Elaine)" but count character names like "GEORGE"
                *
 *    Print this Map out
 ***/
ArrayList<String> listOfNames = new ArrayList<>();
listOfNames.add("KRAMER");
listOfNames.add("JERRY");
listOfNames.add("GEORGE");
listOfNames.add("ELAINE");

        //3.
        Map<String, Long> characterLines = lineList.stream()
                .filter(x)
                .filter(w -> listOfNames.contains(w.getCharacter()))
                .collect(Collectors.groupingBy(w -> w.getCharacter(), Collectors.counting()));

        for(String key : characterLines.keySet())
        {
            System.out.println(key);
            System.out.println(characterLines.get(key));
        }
/**
 * 4. Repeat the goal of 3. but this time collect into the Map the Characters NEWMAN, PUDDY, SUSAN and BANIA
 * for this task create a higher order function called matchCharacters that takes in a variable size array and returns a
 * Predicate indicating whether the .getCharacter() attribute matches any from the argument list
                *
 * Use your higher Order function to solve this task
                *
 *
 * Hint: Your higher order function header might look like this:
 *
 * //characters is an array of characters for which the predicate will return true if
 * //the ShowLine character name matches
 * public static Predicate<ShowLine> matchesAnyCharacter(String ... characters)
 *
 *
 * Add your favorite character to the list if you like - if you have no favorite character you can add UNCLE LEO and
                * repeat the search
 **/
ArrayList<String> newListOfNames = new ArrayList<>();

        newListOfNames.add("NEWMAN");
        newListOfNames.add("PUDDY");
        newListOfNames.add("SUSAN");
        newListOfNames.add("BANIA");

        //4. matchesAnyCharacter is our higher order function





        long start = System.nanoTime();
        long stop = System.nanoTime();
        long duration = stop - start;

        System.out.println(duration / 1000000.0);


        //5. Use a parallel stream and time it
        start = System.nanoTime();

        stop = System.nanoTime();
        duration = stop - start;

        System.out.println(duration/1000000.0);


        //6 use a primitive stream to determine Elaines average words per line and Jerry's




        //7. Print the words per line for uncle leo for each season Not a task but left in place as an example

    }
    public static Predicate<ShowLine> matchCharacters(String[] characters)
    {

    }


}
