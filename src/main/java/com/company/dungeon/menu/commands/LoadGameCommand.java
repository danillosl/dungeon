package com.company.dungeon.menu.commands;

import com.company.dungeon.game.Game;
import com.company.dungeon.menu.Menu;

public class LoadGameCommand extends MenuCommandTemplate {

	private Game game;

	public LoadGameCommand(String name, Menu menu, Game game) {
		super(name, menu);
		this.game = game;
	}

	@Override
	public void execute() {
		this.menu.setGame(this.game);
		menu.stop();

	}

	@Override
	public boolean isSubMenu() {
		return false;
	}

}
