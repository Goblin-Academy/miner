/*
 * Copyright 2018 the original author or authors. 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */
package com.github.drinkjava2.frog.brain.organ;

import com.github.drinkjava2.frog.Frog;
import com.github.drinkjava2.frog.brain.Cell;
import com.github.drinkjava2.frog.brain.Cuboid;
import com.github.drinkjava2.frog.brain.Organ;

/**
 * If move cell active, frog will move
 * 
 * Move被分成上下左右四个独立的运动输出器官，这样方便编程
 * 
 * @author Yong Zhu
 */
public class Move {// 因为青蛙生活在二次元，所以只有上下左右4个运动方向

	private static final int cx = 5; // 中心点
	private static final int cy = 15;
	private static final int cz = 15;

	public static class MoveUp extends Organ {// 这个运动细胞激活，青蛙将向上移动
		private static final long serialVersionUID = 1L;

		public MoveUp() {
			shape = new Cuboid(cx, cy, cz + 2, 1, 1, 1);
		}

		@Override
		public void cellAct(Frog f, Cell c) {
			if (c.energy > 100)
				f.y++;
			c.active(-10);
			// TODO：让信号参与模式识别，并最终存贮在脑皮层细胞里,即金字塔的底部。
		}
	}

	public static class MoveDown extends Organ {// 这个运动细胞激活，青蛙将向下移动
		private static final long serialVersionUID = 1L;

		public MoveDown() {
			shape = new Cuboid(cx, cy, cz - 2, 1, 1, 1);
		}

		@Override
		public void cellAct(Frog f, Cell c) {
			if (c.energy > 100)
				f.y--;
			c.active(-10);
		}
	}

	public static class MoveLeft extends Organ {// 这个运动细胞激活，青蛙将向左移动
		private static final long serialVersionUID = 1L;

		public MoveLeft() {
			shape = new Cuboid(cx, cy + 2, cz, 1, 1, 1);
		}

		@Override
		public void cellAct(Frog f, Cell c) {
			if (c.energy > 100)
				f.x--;
			c.active(-10);
		}
	}

	public static class MoveRight extends Organ {// 这个运动细胞激活，青蛙将向右移动
		private static final long serialVersionUID = 1L;

		public MoveRight() {
			shape = new Cuboid(cx, cy - 2, cz, 1, 1, 1);
		}

		@Override
		public void cellAct(Frog f, Cell c) {
			if (c.energy > 100)
				f.x++;
			c.active(-10);
		}
	}

}
