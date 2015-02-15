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
package br.com.ironmanplay.ironpixel.levels.features;

import br.com.ironmanplay.ironpixel.Challenges;
import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.actors.Char;
import br.com.ironmanplay.ironpixel.actors.buffs.Buff;
import br.com.ironmanplay.ironpixel.actors.hero.Hero;
import br.com.ironmanplay.ironpixel.actors.hero.HeroSubClass;
import br.com.ironmanplay.ironpixel.effects.CellEmitter;
import br.com.ironmanplay.ironpixel.effects.particles.LeafParticle;
import br.com.ironmanplay.ironpixel.actors.buffs.Barkskin;
import br.com.ironmanplay.ironpixel.items.Dewdrop;
import br.com.ironmanplay.ironpixel.items.Generator;
import br.com.ironmanplay.ironpixel.levels.Level;
import br.com.ironmanplay.ironpixel.levels.Terrain;
import br.com.ironmanplay.ironpixel.scenes.GameScene;
import com.watabou.utils.Random;

import br.com.ironmanplay.ironpixel.items.rings.RingOfHerbalism;

public class HighGrass {

	public static void trample( Level level, int pos, Char ch ) {
		
		Level.set( pos, Terrain.GRASS );
		GameScene.updateMap(pos);
		
		if (!Dungeon.isChallenged(Challenges.NO_HERBALISM)) {
			int herbalismLevel = 0;
			if (ch != null) {
				RingOfHerbalism.Herbalism herbalism = ch.buff( RingOfHerbalism.Herbalism.class );
				if (herbalism != null) {
					herbalismLevel = herbalism.level;
				}
			}
			// Seed
			if (herbalismLevel >= 0 && Random.Int( 18 ) <= Random.Int( herbalismLevel + 1 )) {
				level.drop( Generator.random(Generator.Category.SEED), pos ).sprite.drop();
			}
			
			// Dew
			if (herbalismLevel >= 0 && Random.Int( 6 ) <= Random.Int( herbalismLevel + 1 )) {
				level.drop( new Dewdrop(), pos ).sprite.drop();
			}
		}
		
		int leaves = 4;
		
		// Warlock's barkskin
		if (ch instanceof Hero && ((Hero)ch).subClass == HeroSubClass.WARDEN) {
			Buff.affect(ch, Barkskin.class).level( ch.HT / 3 );
			leaves = 8;
		}
		
		CellEmitter.get(pos).burst( LeafParticle.LEVEL_SPECIFIC, leaves );
		Dungeon.observe();
	}
}
