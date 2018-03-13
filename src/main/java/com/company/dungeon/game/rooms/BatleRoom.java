package com.company.dungeon.game.rooms;

import java.util.ArrayList;
import java.util.List;

import com.company.dungeon.game.actions.Action;
import com.company.dungeon.game.fight.FightMediator;

public class BatleRoom implements Room {
	private static final long serialVersionUID = 1L;
	private FightMediator fightMediator;
	private List<Action> actions;
	private String name = "Battle room";

	public BatleRoom() {
		this.actions = new ArrayList<>();
	}

	@Override
	public List<Action> getActions() {
		return this.actions;
	}

	@Override
	public void removeAction(Action action) {
		this.actions.remove(action);
	}

	@Override
	public String getDescription() {
		return fightMediator.toString();
	}

	@Override
	public String getName() {
		return this.name;
	}

	public void setFightMediator(FightMediator fightMediator) {
		this.fightMediator = fightMediator;
	}

}
