import java.util.ArrayList;

class CheckersGame {
    private Board board;
    private Player player1;
    private Player player2;
    private String result;

	CheckersGame(ArrayList<String[]> moves) {
		Board board = new Board();
		for (int i=0;i<moves.size();i++){
			if (!board.playerMove(moves.get(i))){
				result = "Illegal move!!!!111!!1onze!!!1 -> " + moves.get(i)[0] + "," + moves.get(i)[1];
				break;
			}
		}
		if (result == null) result = "Valid game!";
	}

	public String getResult(){
		return result;
	}
}