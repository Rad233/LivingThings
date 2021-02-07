package com.tristankechlo.livingthings.config.entity;

import java.util.ArrayList;
import java.util.List;

import com.tristankechlo.livingthings.config.LivingThingsConfig;
import com.tristankechlo.livingthings.config.misc.SpawnData;

import net.minecraft.world.biome.Biomes;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.common.ForgeConfigSpec.DoubleValue;
import net.minecraftforge.common.ForgeConfigSpec.IntValue;

public class LionConfig {

	public final BooleanValue canAttack;
	public final DoubleValue health;
	public final DoubleValue speed;
	public final DoubleValue damage;
	public final IntValue maxSpawnedInChunk;

	public final ConfigValue<Integer> genderMaleWeight;
	public final ConfigValue<Integer> genderFemaleWeight;

	public final ConfigValue<Integer> color1Weight;
	public final ConfigValue<Integer> colorAlbinoWeight;

	public LionConfig(ForgeConfigSpec.Builder builder) {

		builder.comment("Mob-Config for Lion").push("Lion");

		canAttack = builder.define("CanAttack", true);
		health = builder.comment(LivingThingsConfig.REQUIRES_RESTART).worldRestart().defineInRange("Health", 20.0D,
				LivingThingsConfig.MIN_HEALTH, LivingThingsConfig.MAX_HEALTH);

		speed = builder.comment(LivingThingsConfig.REQUIRES_RESTART + " | " + LivingThingsConfig.HIGH_IMPACT)
				.worldRestart()
				.defineInRange("MovementSpeed", 0.33D, LivingThingsConfig.MIN_SPEED, LivingThingsConfig.MAX_SPEED);

		damage = builder.comment(LivingThingsConfig.REQUIRES_RESTART).worldRestart().defineInRange("AttackDamage", 5.0D,
				LivingThingsConfig.MIN_DAMAGE, LivingThingsConfig.MAX_DAMAGE);

		maxSpawnedInChunk = builder.comment(LivingThingsConfig.REQUIRES_RESTART).worldRestart()
				.defineInRange("MaxSpawnedInChunk", 4, 1, 15);

		builder.comment(LivingThingsConfig.WEIGHTED_RANDOM).push("GenderWeights");
		genderMaleWeight = builder.define("GenderMaleWeight", 50);
		genderFemaleWeight = builder.define("GenderFemaleWeight", 50);
		builder.pop();

		builder.comment(LivingThingsConfig.WEIGHTED_RANDOM).push("ColorVariantWeights");
		color1Weight = builder.define("Color1Weight", 99);
		colorAlbinoWeight = builder.define("AlbinoWeight", 1);
		builder.pop();

		builder.pop();
	}

	@SuppressWarnings("unchecked")
	public static List<SpawnData> getDefaultSpawns() {
		List<SpawnData> spawns = new ArrayList<SpawnData>();
		spawns.add(new SpawnData(15, 2, 4, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.SHATTERED_SAVANNA,
				Biomes.SHATTERED_SAVANNA_PLATEAU));
		return spawns;
	}

}
