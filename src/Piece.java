class Piece {
	private Boolean isWhite;
	private Boolean isKing;
	private Position position;

	Piece(Position position, Boolean isWhite){
		this.isKing = false;
		this.isWhite = isWhite;
		this.position = position;
	}

	private Boolean isLegalMove(Position newPosition, Boolean isJump){
		int moveLength = isJump ? 2 : 1;
		if (newPosition.getCharCol() > 'h' || newPosition.getCharCol() < 'a' || newPosition.getRow() > 7 || newPosition.getRow() < 0) return false;
		if (this.position.getCol() + moveLength == newPosition.getCol() || this.position.getCol() - moveLength == newPosition.getCol()) {
			if (this.position.getRow() + moveLength == newPosition.getRow() && isWhite || isKing){
				return true;
			} else if (this.position.getRow() - moveLength == newPosition.getRow() && !isWhite) {
				return true;
			}
		}
		return false;
	}

	private void promote(){
		this.isKing = true;
	}

	public Boolean isWhite(){
		return this.isWhite;
	}

	public Position getPosition(){
		return this.position;
	}

	public Boolean move(Position newPosition, Boolean isJump){
		if (!isLegalMove(newPosition, isJump)) return false;
		else {
			this.position = newPosition;
			if ((this.position.getRow() == 7 && isWhite) || (this.position.getRow() == 0 && !isWhite)){
				promote();
			}
			return true;
		}
	}
}