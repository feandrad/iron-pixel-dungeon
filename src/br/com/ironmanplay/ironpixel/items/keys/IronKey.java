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
package br.com.ironmanplay.ironpixel.items.keys;

import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.items.bags.Bag;
import br.com.ironmanplay.ironpixel.sprites.ItemSpriteSheet;
import br.com.ironmanplay.ironpixel.utils.Utils;

public class IronKey extends Key {

	private static final String TXT_FROM_DEPTH = "iron key from depth %d";

	public static int curDepthQuantity = 0;
	
	{
		name = "iron key";
		image = ItemSpriteSheet.IRON_KEY;
	}
	
	@Override
	public boolean collect( Bag bag ) {
		boolean result = super.collect( bag );
		if (result && depth == Dungeon.depth && Dungeon.hero != null) {
			Dungeon.hero.belongings.countIronKeys();
		}
		return result;
	}
	
	@Override
	public void onDetach( ) {
		if (depth == Dungeon.depth) {
			Dungeon.hero.belongings.countIronKeys();
		}
	}
	
	@Override
	public String toString() {
		return Utils.format( TXT_FROM_DEPTH, depth );
	}
	
	@Override
	public String info() {
		return 
			"The notches on this ancient iron key are well worn; its leather lanyard " +
			"is battered by age. What door might it open?";
	}
}
