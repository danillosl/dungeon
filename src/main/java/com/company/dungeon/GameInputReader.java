package com.company.dungeon;

import com.company.dungeon.game.Game;
import com.company.dungeon.utilities.ScannerUtil;

public class GameInputReader {
	private Game game;

	public GameInputReader(Game game) {
		this.game = game;
	}

	public void read() {
		String next = ScannerUtil.getScanner().next();
		this.game.input(next);

	}

}
