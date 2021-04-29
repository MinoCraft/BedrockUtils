package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;

@BedrockutilsModElements.ModElement.Tag
public class EnderDragonKillDropProcedure extends BedrockutilsModElements.ModElement {
	public EnderDragonKillDropProcedure(BedrockutilsModElements instance) {
		super(instance, 88);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency entity for procedure EnderDragonKillDrop!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure EnderDragonKillDrop!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure EnderDragonKillDrop!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure EnderDragonKillDrop!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure EnderDragonKillDrop!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((entity instanceof EnderDragonEntity)) {
			if ((((((Entity) world
					.getEntitiesWithinAABB(PlayerEntity.class,
							new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, y, z)).findFirst().orElse(null)) instanceof ServerPlayerEntity) && (((Entity) world
							.getEntitiesWithinAABB(PlayerEntity.class,
									new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
							.stream().sorted(new Object() {
								Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
									return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
								}
							}.compareDistOf(x, y, z)).findFirst().orElse(
									null)).world instanceof ServerWorld))
											? ((ServerPlayerEntity) ((Entity) world
													.getEntitiesWithinAABB(PlayerEntity.class, new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d),
															z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
													.stream().sorted(new Object() {
														Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
															return Comparator.comparing(
																	(Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
														}
													}.compareDistOf(x, y, z)).findFirst().orElse(null))).getAdvancements()
															.getProgress(((MinecraftServer) ((ServerPlayerEntity) ((Entity) world
																	.getEntitiesWithinAABB(PlayerEntity.class,
																			new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d),
																					x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)),
																			null)
																	.stream().sorted(new Object() {
																		Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
																			return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd
																					.getDistanceSq(_x, _y, _z)));
																		}
																	}.compareDistOf(x, y, z)).findFirst().orElse(null))).server)
																			.getAdvancementManager()
																			.getAdvancement(new ResourceLocation("minecraft:end/kill_dragon")))
															.isDone()
											: false)) {
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							new ItemStack(Blocks.DRAGON_EGG, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							new ItemStack(Items.DRAGON_HEAD, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
				if (world instanceof World && !world.isRemote()) {
					ItemEntity entityToSpawn = new ItemEntity((World) world, (entity.getPosX()), (entity.getPosY()), (entity.getPosZ()),
							new ItemStack(Items.ELYTRA, (int) (1)));
					entityToSpawn.setPickupDelay((int) 10);
					entityToSpawn.setNoDespawn();
					world.addEntity(entityToSpawn);
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityDeath(LivingDeathEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
