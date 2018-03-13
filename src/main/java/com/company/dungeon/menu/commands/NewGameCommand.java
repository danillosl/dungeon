package com.company.dungeon.menu.commands;

import com.company.dungeon.menu.Menu;

public class NewGameCommand extends MenuCommandTemplate {

	public NewGameCommand(String name, Menu menu) {
		super(name, menu);
	}

	@Override
	public void execute() {
		SelectCharacterNameCommand selectCharacterNameCommand = new SelectCharacterNameCommand("select name", this.menu);
		selectCharacterNameCommand.execute();

	}

	@Override
	public boolean isSubMenu() {
		return false;
	}


}
