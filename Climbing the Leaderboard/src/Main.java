import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.print("Number of players on the leaderboard >> ");
        int playersInLeaderboard = Constraint();
        System.out.println("Input space-separated integers ranked[i], the leaderboard scores in decreasing order>>");
        int[] ranked = ConstraintArray(playersInLeaderboard, 1);//1 - sorted(fof Leaderboard) other - not sorted(player scores)

        System.out.print("Number games the players plays >> ");
        int gamesPlayersPlays = Constraint();
        System.out.println("Input space-separated integers player[j], the leaderboard scores in decreasing order >> ");
        int[] player = ConstraintArray(gamesPlayersPlays, 0);

        ClimbingTheLeaderboard(player, ranked);


    }

    private static void ClimbingTheLeaderboard(int[] player, int[] ranked) {
        int top;
        for (int k : player) {
            top = 1;
            for (int i = 0; i < ranked.length; i++, top++) {
                if (k >= ranked[i]) {
                    System.out.println(top);
                    break;
                } else if (k < ranked[i]) {
                    while (ranked[i + 1] == ranked[i]) {i++;}
                }
            }
        }
    }

    private static int Constraint() {
        Scanner scanner = new Scanner(System.in);
        int constraint = scanner.nextInt();
        while (!(constraint >= 1 && constraint <= (2 * (int)Math.pow(10, 5)))) {
            System.out.print("Input corrected number >> ");
            constraint = scanner.nextInt();
        }
        //scanner.close();
        return constraint;
    }

    private static int[] ConstraintArray(int size, int mode){
        Scanner scanner = new Scanner(System.in);
        int[] constraint;
        if (mode == 1){
            constraint = Arrays.stream(scanner.nextLine().split(" ")).sorted().sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();
        }else constraint = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        while (constraint.length != size || !CorrectArray(constraint)){
            System.out.print("Input corrected scores >> ");
            if (mode == 1){
                constraint = Arrays.stream(scanner.nextLine().split(" ")).sorted().sorted(Comparator.reverseOrder()).mapToInt(Integer::parseInt).toArray();
            }else constraint = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        return constraint;
    }

    private static boolean CorrectArray(int[] constraint) {
        for (int score:
             constraint) {
            if(score > (int) Math.pow(10, 9) || score <= 0){
                return false;
            }
        }
        return true;
    }
}
