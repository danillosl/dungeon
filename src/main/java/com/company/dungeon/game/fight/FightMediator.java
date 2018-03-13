package com.company.dungeon.game.fight;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.company.dungeon.game.entities.Entity;

public class FightMediator implements Observable, Serializable {

	private static final long serialVersionUID = 1L;

	private boolean active;
	private Entity player;
	private Entity enemy;
	private List<Observer> observers = new ArrayList<>();

	public FightMediator(Entity player, Entity enemy) {
		super();
		this.player = player;
		this.enemy = enemy;
		this.active = true;
	}

	public void executeTurn() {
		this.attack(player, enemy);
		this.attack(enemy, player);

	}

	public boolean isActive() {
		return active;
	}

	public void notifyObservers() {
		observers.forEach(Observer::update);
	}

	private void attack(Entity p1, Entity p2) {
		if (!this.active) {
			return;
		}
		p2.takeDamage(p1.getAttack() - p2.getDefense());
		if (!player.isAlive() || !enemy.isAlive()) {
			if (player.isAlive()) {
				player.gainXP(enemy.getExperienceToLevelUp());
			}
			this.notifyObservers();
			this.active = false;
		}
	}

	@Override
	public void add(Observer observer) {
		this.observers.add(observer);

	}

	@Override
	public String toString() {
		return this.enemy.toString();
	}

}
