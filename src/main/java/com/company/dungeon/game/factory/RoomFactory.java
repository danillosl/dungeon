package com.company.dungeon.game.factory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.company.dungeon.game.actions.Action;
import com.company.dungeon.game.actions.ActionType;
import com.company.dungeon.game.actions.templates.ChangeRoomAction;
import com.company.dungeon.game.actions.templates.EndGameAction;
import com.company.dungeon.game.actions.templates.StartBattleAction;
import com.company.dungeon.game.rooms.DungeonRoom;
import com.company.dungeon.game.rooms.Room;

public final class RoomFactory {

	private RoomFactory() {
		throw new IllegalStateException("Factory class");
	}

	public static Room getRoom(String roomName) {
		String name = null;
		String description = null;
		List<Action> roomActions = new ArrayList<>();
		switch (roomName) {

		case "first_room":

			name = "Dungeon";
			description = "A massive overgrown boulder in a bleak mountain top marks the entrance to this dungeon. Beyond the overgrown boulder lies a modest, crumbling room. It's covered in dirt, large bones and large bones.\n"
					+ "Your torch allows you to see remnants of what once must've been a mess hall of sorts, battered and defaced by time itself.\n"
					+ "Further ahead are two paths, you take the left. Its twisted trail leads downwards and soon you enter a clammy area. It's filled with tombs, but their owners are spread across the floor. What happened in this place?\n"
					+ "You continue onwards, deeper into the dungeon's darkness. You pass various passages, they all look so similar, this whole place is a maze. You eventually make it to what is likely the final room. A thick granite door blocks your path. Dried blood splatters are all over it, somehow untouched by time and the elements. You step closer to inspect it and.. wait.. did something just move behind this door?";

			roomActions.addAll(Arrays.asList(
					new ChangeRoomAction("Go through the door", ActionType.ROOM, RoomFactory.getRoom("second_room")),
					new StartBattleAction("fight the monster", ActionType.ROOM, EntityFactory.getEntity("dragon"))));
			return new DungeonRoom(name, description, roomActions);

		case "second_room":

			name = "Dungeon 2";
			description = "You feel a sense of foreboding upon peering into this cavernous chamber.\n"
					+ " At its center lies a low heap of refuse, rubble, and bones atop which sit several huge broken eggshells.\n"
					+ " Judging by their shattered remains, the eggs were big enough to hold a crouching man, making you wonder how large -- and where -- the mother is.\n";

			roomActions.add(
					new EndGameAction("Go through the other door", ActionType.ROOM, RoomFactory.getRoom("third_room")));
			return new DungeonRoom(name, description, roomActions);

		case "third_room":

			name = "Dungeon 3";
			description = "A dozen statues stand or kneel in this room, and each one lacks a head and stands in a posture of action or defense.\n"
					+ " All are garbed for battle. It's difficult to tell for sure without their heads, but two appear to be dwarves, one might be an elf,\n"
					+ " six appear human, and the rest look like they might be orcs.\n" + "You are free!!!";

			return new DungeonRoom(name, description, roomActions);

		case "end_room":

			name = "End Room";
			description = "You are leaving the game without completing, thanks for playing.";

			return new DungeonRoom(name, description, roomActions);

		default:
			throw new IllegalStateException(String.format("No room with the name of %s", roomName));
		}
	}

}
