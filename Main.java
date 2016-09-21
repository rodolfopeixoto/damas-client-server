import java.nio.file.*;
import java.io.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
    	ArrayList<String[]> moves = new ArrayList<>();
        Path filePath = FileSystems.getDefault().getPath("matches", "match01.txt");
        try {
        	Files.lines(filePath).forEach(
        		line -> moves.add(line.split(","))
        	);
    	} catch (IOException e) {
    		System.out.println("Could not read file!");
    		e.printStackTrace();
    	}

    	CheckersGame checkersGame = new CheckersGame(moves);
    	System.out.println(checkersGame.getResult());
    }
}