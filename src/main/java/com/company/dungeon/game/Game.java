package com.company.dungeon.game;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.company.dungeon.game.actions.Action;
import com.company.dungeon.game.actions.ActionBag;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.entities.Entity;
import com.company.dungeon.game.fight.FightMediator;
import com.company.dungeon.game.fight.Observer;
import com.company.dungeon.game.rooms.BatleRoom;
import com.company.dungeon.game.rooms.Room;
import com.company.dungeon.utilities.Numerics;

public class Game implements ActionBag, Observer {

	private static final long serialVersionUID = 1L;
	private Entity player;
	private Room currentRoom;
	private BatleRoom batleRoom;
	private GameState gameState = GameState.ROOM;
	private List<Action> actions = new ArrayList<>();
	private FightMediator fightMediator;
	private String gameMessage = "";

	public Game(Entity player, Room currentRoom, List<Action> actions) {
		super();
		this.player = player;
		this.currentRoom = currentRoom;
		this.actions.addAll(actions);
		this.batleRoom = new BatleRoom();
	}

	public void changeRoom(Room room) {
		this.currentRoom = room;
	}

	public List<Action> getCurrentActions() {
		switch (gameState) {
		case BATTLE:
			return filterActionsByState(ActionType.BATTLE);
		case ROOM:
			return filterActionsByState(ActionType.ROOM);
		case END:
			return filterActionsByState(ActionType.END);
		default:
			throw new IllegalStateException("an internal error occurred during the game execution.");

		}
	}

	private List<Action> filterActionsByState(ActionType type) {
		return this.getActions().stream().filter(p -> p.getActionType().equals(type)).collect(Collectors.toList());
	}

	public void input(String next) {
		if (Numerics.isNumeric(next)) {
			this.executeAction(this.getCurrentActions().get(Integer.valueOf(next)));
		} else {
			this.gameMessage = String.format("%s is not a valid option, type the number of the option.", next);
		}
	}

	public String getGameMessage() {
		return gameMessage;
	}

	public void clearGameMessage() {
		this.gameMessage = "";
	}

	public void setCurrentRoom(Room currentRoom) {
		this.currentRoom = currentRoom;
	}

	public void startFight(Entity enemy) {
		this.fightMediator = new FightMediator(this.player, enemy);
		this.gameState = GameState.BATTLE;
		this.fightMediator.add(this);
		this.batleRoom.setFightMediator(fightMediator);
	}

	public void removeAction(Action action) {
		this.player.removeAction(action);
		this.currentRoom.removeAction(action);
		this.batleRoom.removeAction(action);
		this.actions.remove(action);
	}

	public void executeAction(Action action) {
		action.execute(this);
	}

	@Override
	public List<Action> getActions() {
		return Stream
				.of(this.player.getActions(), this.currentRoom.getActions(), this.batleRoom.getActions(),
						Collections.unmodifiableList(this.actions))
				.flatMap(Collection::stream).collect(Collectors.toList());
	}

	public String getRoomDescription() {
		if (this.gameState.equals(GameState.BATTLE)) {
			return this.batleRoom.getDescription();
		}
		return this.currentRoom.getDescription();
	}

	public String getRoomName() {
		if (this.gameState.equals(GameState.BATTLE)) {
			return this.batleRoom.getName();
		}
		return this.currentRoom.getName();
	}

	public String getPlayerDescription() {
		return this.player.toString();
	}

	@Override
	public void update() {
		this.gameState = this.player.isAlive() ? GameState.ROOM : GameState.END;
	}

	public void executeBatleTurn() {
		this.fightMediator.executeTurn();
	}

	public GameState getState() {
		return this.gameState;
	}

	public void endGame() {
		this.gameState = GameState.END;
	}
}
