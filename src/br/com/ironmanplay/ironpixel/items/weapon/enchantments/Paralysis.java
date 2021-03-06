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
package br.com.ironmanplay.ironpixel.items.weapon.enchantments;

import br.com.ironmanplay.ironpixel.actors.buffs.Buff;
import br.com.ironmanplay.ironpixel.actors.Char;
import br.com.ironmanplay.ironpixel.items.weapon.Weapon;
import br.com.ironmanplay.ironpixel.sprites.ItemSprite;

import com.watabou.utils.Random;

public class Paralysis extends Weapon.Enchantment {

	private static final String TXT_STUNNING = "Stunning %s";
	
	private static ItemSprite.Glowing YELLOW = new ItemSprite.Glowing( 0xCCAA44 );
	
	@Override
	public boolean proc( Weapon weapon, Char attacker, Char defender, int damage ) {
		// lvl 0 - 13%
		// lvl 1 - 22%
		// lvl 2 - 30%
		int level = Math.max( 0, weapon.level );
		
		if (Random.Int( level + 8 ) >= 7) {
			
			Buff.prolong(defender, br.com.ironmanplay.ironpixel.actors.buffs.Paralysis.class,
					Random.Float(1, 1.5f + level));
			
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public ItemSprite.Glowing glowing() {
		return YELLOW;
	}
	
	@Override
	public String name( String weaponName) {
		return String.format( TXT_STUNNING, weaponName );
	}

}
