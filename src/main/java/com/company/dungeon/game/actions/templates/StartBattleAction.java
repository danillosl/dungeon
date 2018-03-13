package com.company.dungeon.game.actions.templates;

import com.company.dungeon.game.Game;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.entities.Entity;

public class StartBattleAction extends ActionTemplate {

	private static final long serialVersionUID = 1L;
	private final Entity enemy;

	public StartBattleAction(String description, ActionType actionType, Entity enemy) {
		super(description, actionType);
		this.enemy = enemy;

	}

	@Override
	public void execute(Game game) {
		game.startFight(this.enemy);
		game.removeAction(this);
	}

}
