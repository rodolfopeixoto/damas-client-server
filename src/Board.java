import java.lang.Math;

class Board {
	private Piece [][] grid;
	private static final int BOARD_SIZE = 8;
	private int blackPiecesOut = 0;
	private int whitePiecesOut = 0;

	Board() {
		this.grid = new Piece[BOARD_SIZE][BOARD_SIZE];
		for (int row=0;row<BOARD_SIZE;row++){
			for (int col=0;col<BOARD_SIZE;col++){
				// System.out.print(" ");
				if (row > 2 && row < 5) continue;
				if (row%2==0 && col%2!=0) continue;
				if (row%2!=0 && col%2==0) continue;

				boolean isWhite = true;
				if (row >= 5){
					isWhite = false;
				}
				grid[col][row] = new Piece(new Position(col, row), isWhite);
				// System.out.print(new Position(col, row+1));
			}
			// System.out.println("");
		}
		printBoard();
	}

	public Boolean playerMove(String [] move) {
		Position oldPosition = new Position(move[0]);
		Position newPosition = new Position(move[1]);
		Piece p = grid[oldPosition.getCol()][oldPosition.getRow()];

		if (grid[newPosition.getCol()][newPosition.getRow()] == null) {
			if (Math.abs(newPosition.getRow() - oldPosition.getRow()) == 2){
				int row = oldPosition.getRow()+1;
				int col = oldPosition.getCol()+1;
				if (newPosition.getRow() < oldPosition.getRow()) {
					row = oldPosition.getRow()-1;
				}
				if (newPosition.getCol() < oldPosition.getCol()){
					col = oldPosition.getCol()-1;
				}
				Piece opponent = grid[col][row];
				if (opponent != null && opponent.isWhite() != p.isWhite()){
					if (p.move(newPosition, true)){
						grid[newPosition.getCol()][newPosition.getRow()] = p;
						grid[oldPosition.getCol()][oldPosition.getRow()] = null;
						grid[opponent.getPosition().getCol()][opponent.getPosition().getRow()] = null;
						if (opponent.isWhite()){
							whitePiecesOut++;
						} else {
							blackPiecesOut++;
						}
						printBoard();
						return true;
					} else {
						return false;
					}
				}
				return true;
			} else if (Math.abs(newPosition.getRow() - oldPosition.getRow()) == 1){
				if (p.move(newPosition, false)){
					grid[newPosition.getCol()][newPosition.getRow()] = p;
					grid[oldPosition.getCol()][oldPosition.getRow()] = null;
					printBoard();
					return true;
				} else {
					return false;
				}
			}
		} else {
			System.out.println("There's a piece in your way =/");
			return false;
		}
		System.out.println("Couldn't move. Sorry.");
		return false;
	}

	private void printBoard(){
		for (int row=0;row<BOARD_SIZE;row++){
			for (int col=0;col<BOARD_SIZE;col++){
				Piece p = grid[col][row];
				if (p == null)
					System.out.print("  ");
				else{
					if (p.isWhite())
						System.out.print("w ");
					else
						System.out.print("b ");
				}
			}
			System.out.println("");
		}
		System.out.println("=================");
	}
}