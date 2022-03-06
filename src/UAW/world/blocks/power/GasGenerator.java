package UAW.world.blocks.power;

import arc.Core;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import gas.type.Gas;
import gas.world.blocks.power.GasPowerGenerator;
import gas.world.consumers.GasConsume;
import mindustry.world.consumers.ConsumeType;

public class GasGenerator extends GasPowerGenerator {
	public TextureRegion rotatorRegion1, rotatorRegion2, topRegion;

	public float minimumGas = 0.1f;

	public boolean drawSteam = false;
	public int steamParticleCount = 25;
	public float steamParticleLifetime = 60f;
	public float steamParticleSpreadRadius = 7f;
	public float steamParticleSize = 3f;

	public GasGenerator(String name) {
		super(name);
	}

	@Override
	public void load() {
		super.load();
		rotatorRegion1 = Core.atlas.find(name + "-rotator-1");
		rotatorRegion1 = Core.atlas.find(name + "-rotator-1");
		topRegion = Core.atlas.find(name + "-top");
	}

	public class GasGeneratorBuild extends GasPowerGenerator.GasGeneratorBuild {
		float warmup;
		float totalTime;

		@Override
		public float getPowerProduction(){
			return powerProduction;
		}
	}
}