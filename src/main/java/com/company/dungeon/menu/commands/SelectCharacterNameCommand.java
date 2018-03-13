package com.company.dungeon.menu.commands;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.factory.EntityFactory;
import com.company.dungeon.game.factory.GameFactory;
import com.company.dungeon.menu.Menu;
import com.company.dungeon.utilities.ScannerUtil;

public class SelectCharacterNameCommand extends MenuCommandTemplate {

	public SelectCharacterNameCommand(String name, Menu menu) {
		super(name, menu);
	}

	@Override
	public void execute() {

			String characterName = ScannerUtil.printMessageAndGetInput("Type your character name: ");
			Game game = GameFactory.getGame("generic_game", EntityFactory.getEntity(characterName));
			this.menu.setGame(game);
			menu.stop();


	}

	@Override
	public boolean isSubMenu() {
		return false;
	}

}
