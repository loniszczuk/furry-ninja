package ar.com.fn.match;

import org.testng.annotations.*;


public class MatchTest {

    @Test
    public void test() {
        String player1 = "player1";
        String player2 = "player2";

        int[] moves1 = new int[]{1,1,1,1,1};
        int[] moves2 = new int[]{0,0,0,0,0};

        Match m = new Match();

        m.addMovements(player1, moves1);
        m.addMovements(player2, moves2);

        State s = m.getCurrentState();

        assert s.isFinished();
        assert s.getWinner() == player1;
    }

    @Test
    public void test1() {

        String player1 = "player1";

        int[] moves1 = new int[]{1,1,1,1,1};

        Match m = new Match();

        m.addMovements(player1, moves1);
        State s = m.getCurrentState();

        assert !s.isFinished();
        try {
            s.getWinner();
            assert false;
        } catch (RuntimeException e) {
            assert true;
        }
    }

    @Test
    public void test2() {
        String player1 = "alfredo";
        String player2 = "roberto";

        int[] moves1 = new int[]{1,1,1,1,1};
        int[] moves2 = new int[]{1,1,1,1,1};

        Match m = new Match();

        m.addMovements(player1, moves1);
        m.addMovements(player2, moves2);

        State s = m.getCurrentState();

        assert s.isFinished();
        assert s.getWinner() == player2;
    }

    @Test
    public void test3() {
        String player1 = "roberto";
        String player2 = "alfredo";

        int[] moves1 = new int[]{1,1,1,1,1};
        int[] moves2 = new int[]{1,1,1,1,1};

        Match m = new Match();

        m.addMovements(player1, moves1);
        m.addMovements(player2, moves2);

        State s = m.getCurrentState();

        assert s.isFinished();
        assert s.getWinner() == player2;
    }

}