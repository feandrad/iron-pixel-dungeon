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
package br.com.ironmanplay.ironpixel.items.scrolls;

import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.effects.Speck;
import br.com.ironmanplay.ironpixel.items.Item;
import br.com.ironmanplay.ironpixel.items.armor.Armor;
import br.com.ironmanplay.ironpixel.items.weapon.Weapon;
import br.com.ironmanplay.ironpixel.utils.GLog;
import br.com.ironmanplay.ironpixel.windows.WndBag;

public class ScrollOfEnchantment extends InventoryScroll {

	private static final String TXT_GLOWS	= "your %s glows in the dark";
	
	{
		name = "Scroll of Enchantment";
		inventoryTitle = "Select an enchantable item";
		mode = WndBag.Mode.ENCHANTABLE;
	}
	
	@Override
	protected void onItemSelected( Item item ) {

		ScrollOfRemoveCurse.uncurse( Dungeon.hero, item );
		
		if (item instanceof Weapon) {
			
			((Weapon)item).enchant();
			
		} else {

			((Armor)item).inscribe();
		
		}
		
		item.fix();
		
		curUser.sprite.emitter().start( Speck.factory(Speck.LIGHT), 0.1f, 5 );
		GLog.w(TXT_GLOWS, item.name());
	}
	
	@Override
	public String desc() {
		return
			"This scroll is able to imbue a weapon or an armor " +
			"with a random enchantment, granting it a special power.";
	}
}
