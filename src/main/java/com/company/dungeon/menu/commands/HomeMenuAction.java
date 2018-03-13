package com.company.dungeon.menu.commands;

import java.util.Arrays;

import com.company.dungeon.menu.Menu;

public class HomeMenuAction extends MenuCommandTemplate {

	public HomeMenuAction( Menu menu) {
		super("Home", menu);
	}

	@Override
	public void execute() {
		this.menu.addAllCommands(Arrays.asList(
				new NewGameCommand("Start new game", menu),
				new LoadSaveFilesCommand("Load Game", menu)
				));

	}

	@Override
	public boolean isSubMenu() {
		return false;
	}


}
