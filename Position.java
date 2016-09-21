class Position {
	private int col;
	private int row;

	Position (String positionStr){
		this.col = ((int) positionStr.charAt(0)) - 97;
		this.row = Character.getNumericValue(positionStr.charAt(1)) - 1;
	}

	Position (int col, int row){
		this.col = col;
		this.row = row;
	}

	public int getCol(){
		return col;
	}

	public int getRow(){
		return row;
	}

	public char getCharCol(){
		int tmp = col + 97;
		return ((char) tmp);
	}

	@Override
	public String toString(){
		return getCharCol() + Integer.toString(row);
	}
}