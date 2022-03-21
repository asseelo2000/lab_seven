package lab_seven.lab_seven_assignment;

/**
 * Created by Asseel Tarish on 3/22/2022.
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JosephProblem {

    public static void main(String[] args) {
        int winner = joseph(5, 3);
        System.out.println("winner is " + winner);
        winner = joseph(10, 3);
        System.out.println("winner is " + winner);
        winner = joseph(5, 2);
        System.out.println("winner is " + winner);
        winner = joseph(7, 3);
        System.out.println("winner is " + winner);
    }

    public static int joseph(int noOfPeople, int remPosition) {
        int tempPos = remPosition - 1;
        int[] people = new int[noOfPeople];

        for (int i = 0; i < noOfPeople; i++) {
            people[i] = i + 1;
        }

        int iteration = noOfPeople - 1;

        List<Integer> list = IntStream.of(people).boxed().collect(Collectors.toList());

        while (iteration > 0) {
            list.remove(tempPos);
            tempPos += remPosition - 1;
            if (tempPos > list.size() - 1) {
                tempPos = tempPos % list.size();
            }
            iteration--;
        }

        return list.get(0);
    }

}
