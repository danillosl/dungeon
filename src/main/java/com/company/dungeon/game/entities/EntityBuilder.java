package com.company.dungeon.game.entities;

import java.util.ArrayList;
import java.util.List;

import com.company.dungeon.game.actions.Action;
import com.company.dungeon.utilities.Preconditions;
import com.company.dungeon.utilities.Strings;

public class EntityBuilder {

	private String name;
	private String picture;
	private int totalLife;
	private int defense;
	private int attack;
	private int level;
	private List<Action> actions = new ArrayList<>();
	private int experienceToLevelUp = 200;

	public EntityBuilder withName(String name) {
		this.name = name;
		return this;
	}

	public EntityBuilder withPicture(String picture) {
		this.picture = picture;
		return this;
	}

	public EntityBuilder withTotalLife(int totalLife) {
		this.totalLife = totalLife;
		return this;
	}

	public EntityBuilder withDefense(int defense) {
		this.defense = defense;
		return this;
	}

	public EntityBuilder withAttack(int attack) {
		this.attack = attack;
		return this;
	}

	public EntityBuilder withLevel(int level) {
		this.level = level;
		return this;
	}

	public EntityBuilder withExperienceToLevelUp(int experienceToLevelUp) {
		this.experienceToLevelUp = experienceToLevelUp;
		return this;
	}

	public EntityBuilder withAction(Action action) {
		this.actions.add(action);
		return this;
	}

	public EntityBuilder addAllAction(List<Action> actions) {
		this.actions.addAll(actions);
		return this;
	}

	public Entity build() {
		Preconditions.checkState(!Strings.isNullOrEmpty(name), "entity name cannot be null");
		Preconditions.checkState(experienceToLevelUp > 0, "experience to level up must be greater than zero");
		Preconditions.checkState(totalLife > 0, "total life must be greater than zero");
		Preconditions.checkState(defense > 0, "defense must be greater than zero");
		Preconditions.checkState(attack > 0, "attack must be greater than zero");
		EntityAttributes attribute = new EntityAttributes(totalLife, defense, attack, level, experienceToLevelUp);
		return new EntityTemplate(name, picture, attribute, actions);
	}

}
