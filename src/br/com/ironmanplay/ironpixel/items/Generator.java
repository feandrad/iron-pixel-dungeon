/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */
package br.com.ironmanplay.ironpixel.items;

import java.util.HashMap;

import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.actors.hero.Hero;
import br.com.ironmanplay.ironpixel.actors.mobs.npcs.Wandmaker;
import br.com.ironmanplay.ironpixel.items.armor.PlateArmor;
import br.com.ironmanplay.ironpixel.items.bags.Bag;
import br.com.ironmanplay.ironpixel.items.food.Food;
import br.com.ironmanplay.ironpixel.items.food.MysteryMeat;
import br.com.ironmanplay.ironpixel.items.food.Pasty;

import com.watabou.utils.Random;

import br.com.ironmanplay.ironpixel.items.armor.Armor;
import br.com.ironmanplay.ironpixel.items.armor.ClothArmor;
import br.com.ironmanplay.ironpixel.items.armor.LeatherArmor;
import br.com.ironmanplay.ironpixel.items.armor.MailArmor;
import br.com.ironmanplay.ironpixel.items.armor.ScaleArmor;
import br.com.ironmanplay.ironpixel.items.potions.Potion;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfExperience;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfFrost;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfHealing;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfInvisibility;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfLevitation;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfLiquidFlame;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfMight;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfMindVision;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfParalyticGas;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfPurity;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfStrength;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfToxicGas;
import br.com.ironmanplay.ironpixel.items.rings.Ring;
import br.com.ironmanplay.ironpixel.items.rings.RingOfAccuracy;
import br.com.ironmanplay.ironpixel.items.rings.RingOfDetection;
import br.com.ironmanplay.ironpixel.items.rings.RingOfElements;
import br.com.ironmanplay.ironpixel.items.rings.RingOfEvasion;
import br.com.ironmanplay.ironpixel.items.rings.RingOfHaggler;
import br.com.ironmanplay.ironpixel.items.rings.RingOfHaste;
import br.com.ironmanplay.ironpixel.items.rings.RingOfHerbalism;
import br.com.ironmanplay.ironpixel.items.rings.RingOfMending;
import br.com.ironmanplay.ironpixel.items.rings.RingOfPower;
import br.com.ironmanplay.ironpixel.items.rings.RingOfSatiety;
import br.com.ironmanplay.ironpixel.items.rings.RingOfShadows;
import br.com.ironmanplay.ironpixel.items.rings.RingOfThorns;
import br.com.ironmanplay.ironpixel.items.scrolls.Scroll;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfChallenge;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfEnchantment;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfIdentify;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfLullaby;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfMagicMapping;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfMirrorImage;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfPsionicBlast;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfRecharging;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfRemoveCurse;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfTeleportation;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfTerror;
import br.com.ironmanplay.ironpixel.items.scrolls.ScrollOfUpgrade;
import br.com.ironmanplay.ironpixel.items.wands.Wand;
import br.com.ironmanplay.ironpixel.items.wands.WandOfAmok;
import br.com.ironmanplay.ironpixel.items.wands.WandOfAvalanche;
import br.com.ironmanplay.ironpixel.items.wands.WandOfBlink;
import br.com.ironmanplay.ironpixel.items.wands.WandOfDisintegration;
import br.com.ironmanplay.ironpixel.items.wands.WandOfFirebolt;
import br.com.ironmanplay.ironpixel.items.wands.WandOfFlock;
import br.com.ironmanplay.ironpixel.items.wands.WandOfLightning;
import br.com.ironmanplay.ironpixel.items.wands.WandOfMagicMissile;
import br.com.ironmanplay.ironpixel.items.wands.WandOfPoison;
import br.com.ironmanplay.ironpixel.items.wands.WandOfRegrowth;
import br.com.ironmanplay.ironpixel.items.wands.WandOfSlowness;
import br.com.ironmanplay.ironpixel.items.wands.WandOfTelekinesis;
import br.com.ironmanplay.ironpixel.items.wands.WandOfTeleportation;
import br.com.ironmanplay.ironpixel.items.weapon.Weapon;
import br.com.ironmanplay.ironpixel.items.weapon.melee.BattleAxe;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Dagger;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Glaive;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Knuckles;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Longsword;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Mace;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Quarterstaff;
import br.com.ironmanplay.ironpixel.items.weapon.melee.ShortSword;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Spear;
import br.com.ironmanplay.ironpixel.items.weapon.melee.Sword;
import br.com.ironmanplay.ironpixel.items.weapon.melee.WarHammer;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.Boomerang;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.CurareDart;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.Dart;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.IncendiaryDart;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.Javelin;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.Shuriken;
import br.com.ironmanplay.ironpixel.items.weapon.missiles.Tamahawk;
import br.com.ironmanplay.ironpixel.plants.Dreamweed;
import br.com.ironmanplay.ironpixel.plants.Earthroot;
import br.com.ironmanplay.ironpixel.plants.Fadeleaf;
import br.com.ironmanplay.ironpixel.plants.Firebloom;
import br.com.ironmanplay.ironpixel.plants.Icecap;
import br.com.ironmanplay.ironpixel.plants.Plant;
import br.com.ironmanplay.ironpixel.plants.Sorrowmoss;
import br.com.ironmanplay.ironpixel.plants.Sungrass;

public class Generator {

	public static enum Category {
		WEAPON	( 15,	Weapon.class ),
		ARMOR	( 10,	Armor.class ),
		POTION	( 50,	Potion.class ),
		SCROLL	( 40,	Scroll.class ),
		WAND	( 4,	Wand.class ),
		RING	( 2,	Ring.class ),
		SEED	( 5,	Plant.Seed.class ),
		FOOD	( 0,	Food.class ),
		GOLD	( 50,	Gold.class ),
		MISC	( 5,	Item.class );
		
		public Class<?>[] classes;
		public float[] probs;
		
		public float prob;
		public Class<? extends Item> superClass;
		
		private Category( float prob, Class<? extends Item> superClass ) {
			this.prob = prob;
			this.superClass = superClass;
		}
		
		public static int order( Item item ) {
			for (int i=0; i < values().length; i++) {
				if (values()[i].superClass.isInstance( item )) {
					return i;
				}
			}
			
			return item instanceof Bag ? Integer.MAX_VALUE : Integer.MAX_VALUE - 1;
		}
	};
	
	private static HashMap<Category,Float> categoryProbs = new HashMap<Generator.Category, Float>();
	
	static {
		
		Category.GOLD.classes = new Class<?>[]{ 
			Gold.class };
		Category.GOLD.probs = new float[]{ 1 };
		
		Category.SCROLL.classes = new Class<?>[]{ 
			ScrollOfIdentify.class,
			ScrollOfTeleportation.class,
			ScrollOfRemoveCurse.class,
			ScrollOfRecharging.class,
			ScrollOfMagicMapping.class,
			ScrollOfChallenge.class,
			ScrollOfTerror.class,
			ScrollOfLullaby.class,
			ScrollOfPsionicBlast.class,
			ScrollOfMirrorImage.class,
			ScrollOfUpgrade.class,
			ScrollOfEnchantment.class };
		Category.SCROLL.probs = new float[]{ 30, 10, 15, 10, 15, 12, 8, 8, 4, 6, 0, 1 };
		
		Category.POTION.classes = new Class<?>[]{ 
			PotionOfHealing.class,
			PotionOfExperience.class,
			PotionOfToxicGas.class,
			PotionOfParalyticGas.class,
			PotionOfLiquidFlame.class,
			PotionOfLevitation.class,
			PotionOfStrength.class,
			PotionOfMindVision.class,
			PotionOfPurity.class,
			PotionOfInvisibility.class,
			PotionOfMight.class,
			PotionOfFrost.class };
		Category.POTION.probs = new float[]{ 45, 4, 15, 10, 15, 10, 0, 20, 12, 10, 0, 10 };
		
		Category.WAND.classes = new Class<?>[]{ 
			WandOfTeleportation.class,
			WandOfSlowness.class,
			WandOfFirebolt.class,
			WandOfRegrowth.class,
			WandOfPoison.class,
			WandOfBlink.class,
			WandOfLightning.class,
			WandOfAmok.class,
			WandOfTelekinesis.class,
			WandOfFlock.class,
			WandOfMagicMissile.class,
			WandOfDisintegration.class,
			WandOfAvalanche.class };
		Category.WAND.probs = new float[]{ 10, 10, 15, 6, 10, 11, 15, 10, 6, 10, 0, 5, 5 };
		
		Category.WEAPON.classes = new Class<?>[]{ 
			Dagger.class,
			Knuckles.class,
			Quarterstaff.class,
			Spear.class,
			Mace.class,
			Sword.class,
			Longsword.class,
			BattleAxe.class,
			WarHammer.class,
			Glaive.class,
			ShortSword.class,
			Dart.class,
			Javelin.class,
			IncendiaryDart.class,
			CurareDart.class,
			Shuriken.class,
			Boomerang.class,
			Tamahawk.class };
		Category.WEAPON.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1 };
		
		Category.ARMOR.classes = new Class<?>[]{ 
			ClothArmor.class,
			LeatherArmor.class,
			MailArmor.class,
			ScaleArmor.class,
			PlateArmor.class };
		Category.ARMOR.probs = new float[]{ 1, 1, 1, 1, 1 };
		
		Category.FOOD.classes = new Class<?>[]{ 
			Food.class, 
			Pasty.class,
			MysteryMeat.class };
		Category.FOOD.probs = new float[]{ 4, 1, 0 };
			
		Category.RING.classes = new Class<?>[]{ 
			RingOfMending.class,
			RingOfDetection.class,
			RingOfShadows.class,
			RingOfPower.class,
			RingOfHerbalism.class,
			RingOfAccuracy.class,
			RingOfEvasion.class,
			RingOfSatiety.class,
			RingOfHaste.class,
			RingOfElements.class,
			RingOfHaggler.class,
			RingOfThorns.class };
		Category.RING.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0 };
		
		Category.SEED.classes = new Class<?>[]{ 
			Firebloom.Seed.class,
			Icecap.Seed.class,
			Sorrowmoss.Seed.class,
			Dreamweed.Seed.class,
			Sungrass.Seed.class,
			Earthroot.Seed.class,
			Fadeleaf.Seed.class,
			Wandmaker.Rotberry.Seed.class };
		Category.SEED.probs = new float[]{ 1, 1, 1, 1, 1, 1, 1, 0 };
		
		Category.MISC.classes = new Class<?>[]{ 
			Bomb.class,
			Honeypot.class};
		Category.MISC.probs = new float[]{ 2, 1 };
	}
	
	public static void reset() {
		for (Category cat : Category.values()) {
			categoryProbs.put( cat, cat.prob );
		}
	}
	
	public static Item random() {
		return random( Random.chances( categoryProbs ) );
	}
	
	public static Item random( Category cat ) {
		try {
			
			categoryProbs.put( cat, categoryProbs.get( cat ) / 2 );
			
			switch (cat) {
			case ARMOR:
				return randomArmor();
			case WEAPON:
				return randomWeapon();
			default:
				return ((Item)cat.classes[Random.chances( cat.probs )].newInstance()).random();
			}
			
		} catch (Exception e) {

			return null;
			
		}
	}
	
	public static Item random( Class<? extends Item> cl ) {
		try {
			
			return ((Item)cl.newInstance()).random();
			
		} catch (Exception e) {

			return null;
			
		}
	}
	
	public static Armor randomArmor() throws Exception {
		
		int curStr = Hero.STARTING_STR + Dungeon.potionOfStrength;
		
		Category cat = Category.ARMOR;
		
		Armor a1 = (Armor)cat.classes[Random.chances( cat.probs )].newInstance();
		Armor a2 = (Armor)cat.classes[Random.chances( cat.probs )].newInstance();
		
		a1.random();
		a2.random();
		
		return Math.abs( curStr - a1.STR ) < Math.abs( curStr - a2.STR ) ? a1 : a2;
	}
	
	public static Weapon randomWeapon() throws Exception {
		
		int curStr = Hero.STARTING_STR + Dungeon.potionOfStrength;
		
		Category cat = Category.WEAPON;
		
		Weapon w1 = (Weapon)cat.classes[Random.chances( cat.probs )].newInstance();
		Weapon w2 = (Weapon)cat.classes[Random.chances( cat.probs )].newInstance();
		
		w1.random();
		w2.random();
		
		return Math.abs( curStr - w1.STR ) < Math.abs( curStr - w2.STR ) ? w1 : w2;
	}
}
