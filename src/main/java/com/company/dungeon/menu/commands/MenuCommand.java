package com.company.dungeon.menu.commands;

public interface MenuCommand extends Comparable<MenuCommand> {

	String getName();

	void execute();

	boolean isSubMenu();

}
