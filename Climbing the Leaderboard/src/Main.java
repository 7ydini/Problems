import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        System.out.print("Number of players on the leaderboard >> ");
        int playersInLeaderboard = Constraint();
        System.out.println("Input space-separated integers ranked[i], the leaderboard scores in decreasing order>>");
        int[] ranked = ConstraintArray(playersInLeaderboard);

        System.out.println("Number games the players plays >> ");
        int gamesPlayersPlays = Constraint();
        System.out.println("Input space-separated integers player[j], the leaderboard scores in decreasing order >> ");
        int[] player = ConstraintArray(gamesPlayersPlays);
        int top = 0;

        for (int i = 0; i < ranked.length; i++){
            for (int j = 0; j < player.length; j++){
                if(ranked[i] < player[j]){

                }
            }
        }
    }

    private static int Constraint() {
        Scanner scanner = new Scanner(System.in);
        int constraint = scanner.nextInt();;
        while (!(constraint >= 1 && constraint <= (2 * 10 ^ 5))) {
            System.out.print("Input corrected number >> ");
            constraint = scanner.nextInt();
        }
        scanner.close();
        return constraint;
    }

    private static int[] ConstraintArray(int size){
        Scanner scanner = new Scanner(System.in);
        int[] constraint = Arrays.stream(scanner.nextLine().split(" ")).sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();

        while (constraint.length != size || !CorrectArray(constraint)){
            System.out.print("Input corrected scores >> ");
            constraint = Arrays.stream(scanner.nextLine().split(" ")).sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();
        }

        scanner.close();
        return constraint;
    }

    private static boolean CorrectArray(int[] constraint) {
        for (int score:
             constraint) {
            if(score > (10^9)|| score <= 0){
                return false;
            }
        }
        return true;
    }
}
