class Board {
	private Piece [][] grid;
	private static final int BOARD_SIZE = 8;

	Board() {
		this.grid = new Piece[BOARD_SIZE][BOARD_SIZE];
		for (int row=0;row<BOARD_SIZE;row++){
			for (int col=0;col<BOARD_SIZE;col++){
				if (row > 2 && row < 5) continue;
				if (row%2==0 && col%2!=0) continue;
				if (row%2!=0 && col%2==0) continue;

				boolean isWhite = true;
				if (row >= 5){
					isWhite = false;
				}
				grid[col][row] = new Piece(new Position(col, row), isWhite);
				System.out.print(new Position(col, row) + " ");
			}
			System.out.println("");
		}
	}

	public Boolean playerMove(String [] move) {
		Position oldPosition = new Position(move[0]);
		Position newPosition = new Position(move[1]);


		if (grid[newPosition.getCol()][newPosition.getRow()] == null) {
			if (newPosition.getRow() == oldPosition.getRow() + 2 || newPosition.getRow() == oldPosition.getRow() - 2){
				// TODO JUMP CASE
				return true;
			} else if (newPosition.getRow() == oldPosition.getRow() + 1 || newPosition.getRow() == oldPosition.getRow() - 1){
				// TODO MOVE CASE
				return true;
			}
		} else {
			System.out.println("There's a piece in your way =/");
			return false;
		}
		System.out.println("Couldn't make the move. Sorry.");
		return false;
	}
}