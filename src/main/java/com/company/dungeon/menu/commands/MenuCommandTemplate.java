package com.company.dungeon.menu.commands;

import com.company.dungeon.menu.Menu;

public abstract class MenuCommandTemplate implements MenuCommand {
	protected String name;
	protected Menu menu;

	public MenuCommandTemplate(String name, Menu menu) {
		super();
		this.name = name;
		this.menu = menu;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(MenuCommand o) {
		return this.getName().compareTo(o.getName());
	}

}
