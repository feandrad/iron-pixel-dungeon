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
package br.com.ironmanplay.ironpixel.plants;

import br.com.ironmanplay.ironpixel.Dungeon;
import br.com.ironmanplay.ironpixel.actors.Char;
import br.com.ironmanplay.ironpixel.actors.blobs.Blob;
import br.com.ironmanplay.ironpixel.actors.blobs.Fire;
import br.com.ironmanplay.ironpixel.effects.CellEmitter;
import br.com.ironmanplay.ironpixel.effects.particles.FlameParticle;
import br.com.ironmanplay.ironpixel.items.potions.PotionOfLiquidFlame;
import br.com.ironmanplay.ironpixel.scenes.GameScene;
import br.com.ironmanplay.ironpixel.sprites.ItemSpriteSheet;

public class Firebloom extends Plant {

	private static final String TXT_DESC = "When something touches a Firebloom, it bursts into flames.";
	
	{
		image = 0;
		plantName = "Firebloom";
	}
	
	@Override
	public void activate( Char ch ) {
		super.activate( ch );
		
		GameScene.add(Blob.seed(pos, 2, Fire.class));
		
		if (Dungeon.visible[pos]) {
			CellEmitter.get(pos).burst( FlameParticle.FACTORY, 5 );
		}
	}
	
	@Override
	public String desc() {
		return TXT_DESC;
	}
	
	public static class Seed extends Plant.Seed {
		{
			plantName = "Firebloom";
			
			name = "seed of " + plantName;
			image = ItemSpriteSheet.SEED_FIREBLOOM;
			
			plantClass = Firebloom.class;
			alchemyClass = PotionOfLiquidFlame.class;
		}
		
		@Override
		public String desc() {
			return TXT_DESC;
		}
	}
}
