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
package br.com.ironmanplay.ironpixel.items.wands;

import com.watabou.noosa.audio.Sample;

import br.com.ironmanplay.ironpixel.Assets;
import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.actors.Actor;
import br.com.ironmanplay.ironpixel.actors.buffs.Buff;
import br.com.ironmanplay.ironpixel.actors.Char;
import br.com.ironmanplay.ironpixel.actors.buffs.Amok;
import br.com.ironmanplay.ironpixel.actors.buffs.Vertigo;
import br.com.ironmanplay.ironpixel.effects.MagicMissile;
import br.com.ironmanplay.ironpixel.utils.GLog;

import com.watabou.utils.Callback;

public class WandOfAmok extends Wand {

	{
		name = "Wand of Amok";
	}

	@Override
	protected void onZap( int cell ) {
		Char ch = Actor.findChar(cell);
		if (ch != null) {
			
			if (ch == Dungeon.hero) {
				Buff.affect(ch, Vertigo.class, Vertigo.duration(ch));
			} else {
				Buff.affect( ch, Amok.class, 3f + level() );
			}

		} else {
			
			GLog.i("nothing happened");
			
		}
	}
	
	protected void fx( int cell, Callback callback ) {
		MagicMissile.purpleLight( curUser.sprite.parent, curUser.pos, cell, callback );
		Sample.INSTANCE.play( Assets.SND_ZAP );
	}
	
	@Override
	public String desc() {
		return
			"The purple light from this wand will make the target run amok " +
			"attacking random creatures in its vicinity.";
	}
}
