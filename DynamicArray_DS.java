import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // www.hackerrank.com/challenges/dynamic-array/problem
        // java 8
        List<List<Integer>>  arr = new ArrayList<>();       // Declare a 2-dimensional array  
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());                     // arr is n empty arrays. 
        }
        List<Integer>  lastAnswerArray = new ArrayList<>();
        int lastAnswer = 0;                                 // Declare an integer and initialize it to 0.
        for (List<Integer> query : queries) {
            int idx = (query.get(1) ^ lastAnswer) % n;
            if (query.get(0) == 1) { 
                arr.get(idx).add(query.get(2));
            } else if(query.get(0) == 2){
                lastAnswer =  arr.get(idx).get(query.get(2) % arr.get(idx).size());
                lastAnswerArray.add(lastAnswer);
            }
        }
        return lastAnswerArray;
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
