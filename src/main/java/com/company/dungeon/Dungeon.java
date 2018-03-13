package com.company.dungeon;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.GameState;
import com.company.dungeon.menu.Menu;

public class Dungeon {

	public static void main(String[] args) {
		new Dungeon().run();
	}

	public void run() {

		Menu menu = new Menu();

		menu.run();
		Game game = menu.getGame();
		GamePrinter gamePrinter = new GamePrinter(game);
		GameInputReader gameInputReader = new GameInputReader(game);

		while (game.getState() != GameState.END) {
			gamePrinter.print();
			gameInputReader.read();
		}
		// print the ending screen.
		gamePrinter.print();
	}

}
