import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Number of players on the leaderboard.");
        int playersInLeaderboard = Constraint();
        System.out.println("Input space-separated integers ranked[i], the leaderboard scores in decreasing order.");
        int[] ranked = ConstraintArray(playersInLeaderboard, 1);//1 - sorted(for Leaderboard) other - not sorted(player scores)

        System.out.print("Number games the players plays >> ");
        int gamesPlayersPlays = Constraint();
        System.out.println("Input space-separated integers player[j], the leaderboard scores in decreasing order.");
        int[] player = ConstraintArray(gamesPlayersPlays, 0);

        ClimbingTheLeaderboard(player, ranked);
    }

    private static void ClimbingTheLeaderboard(int[] playerScores, int[] rankedScores) {
        int top;
        for (int score : playerScores) {
            top = 1;
            for (int i = 0; i < rankedScores.length; i++, top++) {
                if (score >= rankedScores[i]) {
                    System.out.println(top);
                    break;
                } else if (score < rankedScores[i]) {
                    while ( i < rankedScores.length - 1 && rankedScores[i + 1] == rankedScores[i]) {i++;}
                    if(i == rankedScores.length - 1){
                        top++;
                        System.out.println(top);//processing the last element
                    }
                }
            }
        }
    }

    private static int Constraint() {
        int constraint = 0;
        while (!(constraint >= 1 && constraint <= (2 * (int)Math.pow(10, 5)))) {
            System.out.print("Input number >> ");
            try{
                Scanner scanner = new Scanner(System.in);
                constraint = scanner.nextInt();
            }catch (InputMismatchException ex){
                constraint = -1;
            }
        }
        return constraint;
    }

    private static int[] ConstraintArray(int size, int mode){

        int[] constraint = new int[0];
        if (mode == 1){
        while (constraint.length != size || !CorrectArray(constraint)){
            try {
                System.out.print("Input scores >> ");
                Scanner scanner = new Scanner(System.in);
                constraint = Arrays.stream(Arrays.stream(scanner.nextLine().split(" "))
                        .sorted().mapToInt(Integer::parseInt).toArray())//Sorted Input to array
                        .boxed().sorted(Collections.reverseOrder())//sorted Integer
                        .mapToInt(Integer::intValue).toArray();//return int[]
            }catch (NumberFormatException ex){
                constraint = new int[0];
            }
        }
        }else {
            while (constraint.length != size || !CorrectArray(constraint)) {
                try {
                    System.out.print("Input scores >> ");
                    Scanner scanner = new Scanner(System.in);
                    constraint = Arrays.stream(scanner.nextLine().split(" "))
                            .mapToInt(Integer::parseInt).toArray();
                }catch (NumberFormatException ex){
                    constraint = new int[0];
                }
            }
        }
        return constraint;
    }

    private static boolean CorrectArray(int[] constraint) {
        for (int score:
             constraint) {
            if(score > (int) Math.pow(10, 9) || score < 0){
                return false;
            }
        }
        return true;
    }
}
