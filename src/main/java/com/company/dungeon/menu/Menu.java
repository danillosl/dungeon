package com.company.dungeon.menu;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

import com.company.dungeon.game.Game;
import com.company.dungeon.menu.commands.LoadSaveFilesCommand;
import com.company.dungeon.menu.commands.MenuCommand;
import com.company.dungeon.menu.commands.NewGameCommand;
import com.company.dungeon.utilities.Numerics;
import com.company.dungeon.utilities.ScannerUtil;

public class Menu {

	private Game game;
	private boolean running;
	private List<MenuCommand> currentCommands;
	private String menuMessage = "";

	public Menu() {
		running = true;
		currentCommands = new LinkedList<>();
		currentCommands.addAll(
				Arrays.asList(new NewGameCommand("Start new game", this), new LoadSaveFilesCommand("Load Game", this)));
	}

	public void addAllCommands(List<MenuCommand> currentCommands) {
		this.currentCommands.clear();
		this.currentCommands.addAll(currentCommands);
	}

	public List<MenuCommand> getCurrentCommands() {
		return Collections.unmodifiableList(this.currentCommands);
	}

	public void run() {

		while (running) {
			StringJoiner joiner = new StringJoiner("\n");
			joiner.add("\033[H\033[2J");
			joiner.add(String.join("", Collections.nCopies(70, "=")));
			int index = 0;
			for (MenuCommand menuCommand : this.getCurrentCommands()) {
				joiner.add(String.format("%d : %s", index++, menuCommand.getName()));
			}
			joiner.add(menuMessage);
			this.clearMenuMessage();
			joiner.add("type the number of the action you want to take: ");
			System.out.println(joiner.toString());
			String next = ScannerUtil.getScanner().next();
			if (Numerics.isNumeric(next)) {
				this.executeCommandWithIndex(Integer.valueOf(next));
			} else {
				this.menuMessage = String.format("%s is not a valid option, type the number of the option.", next);
			}

		}

	}

	public void executeCommandWithIndex(int index) {
		this.getCurrentCommands().get(index).execute();
	}

	public void stop() {
		this.running = false;
	}

	public void clearMenuMessage() {
		this.menuMessage = "";
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

}
