package com.company.dungeon.menu.commands;

import java.util.ArrayList;
import java.util.List;

import com.company.dungeon.menu.Menu;
import com.company.dungeon.save.Save;
import com.company.dungeon.save.SaveRepositoryImpl;

public class LoadSaveFilesCommand extends MenuCommandTemplate {

	public LoadSaveFilesCommand(String name, Menu menu) {
		super(name, menu);
	}

	@Override
	public void execute() {
		List<Save> saves = SaveRepositoryImpl.getSaveRespository().list();
		List<MenuCommand> commands = new ArrayList<>();
		saves.forEach(p -> commands.add(new LoadGameCommand(p.getName(), menu, p.getGame())));
		commands.add(new HomeMenuAction(menu));
		menu.addAllCommands(commands);

	}

	@Override
	public boolean isSubMenu() {
		return false;
	}

}
