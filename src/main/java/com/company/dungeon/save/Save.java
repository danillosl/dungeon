package com.company.dungeon.save;

import java.io.Serializable;

import com.company.dungeon.game.Game;

public class Save implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private Game game;

	public Save(String name, Game game) {
		super();
		this.name = name;
		this.game = game;
	}

	public Game getGame() {
		return game;
	}

	public String getName() {
		return name;
	}

}
