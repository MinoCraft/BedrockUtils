package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@BedrockutilsModElements.ModElement.Tag
public class PatrolLeaderDetectorUpdateTickProcedure extends BedrockutilsModElements.ModElement {
	public PatrolLeaderDetectorUpdateTickProcedure(BedrockutilsModElements instance) {
		super(instance, 87);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure PatrolLeaderDetectorUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure PatrolLeaderDetectorUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure PatrolLeaderDetectorUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure PatrolLeaderDetectorUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "rsEvent"))) {
			if ((((Entity) world
					.getEntitiesWithinAABB(PillagerEntity.class,
							new AxisAlignedBB(x - (1 / 2d), (y + 1) - (1 / 2d), z - (1 / 2d), x + (1 / 2d), (y + 1) + (1 / 2d), z + (1 / 2d)), null)
					.stream().sorted(new Object() {
						Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
							return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
						}
					}.compareDistOf(x, (y + 1), z)).findFirst().orElse(null)) != null)) {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						final ItemStack _setstack = new ItemStack(Items.STICK, (int) (1));
						_setstack.setCount((int) 1);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
							}
						});
					}
				}
				world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
						world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 20);
				if ((((((((Entity) world.getEntitiesWithinAABB(PillagerEntity.class,
						new AxisAlignedBB(x - (1 / 2d), (y + 1) - (1 / 2d), z - (1 / 2d), x + (1 / 2d), (y + 1) + (1 / 2d), z + (1 / 2d)), null)
						.stream().sorted(new Object() {
							Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
								return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
							}
						}.compareDistOf(x, (y + 1), z)).findFirst().orElse(
								null)) instanceof LivingEntity)
										? ((LivingEntity) ((Entity) world
												.getEntitiesWithinAABB(PillagerEntity.class, new AxisAlignedBB(x - (1 / 2d), (y + 1) - (1 / 2d),
														z - (1 / 2d), x + (1 / 2d), (y + 1) + (1 / 2d), z + (1 / 2d)), null)
												.stream().sorted(new Object() {
													Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
														return Comparator
																.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
													}
												}.compareDistOf(x, (y + 1), z)).findFirst().orElse(null))).getItemStackFromSlot(
														EquipmentSlotType.fromSlotTypeAndIndex(EquipmentSlotType.Group.ARMOR, (int) 3))
										: ItemStack.EMPTY).getDisplayName().getString())).equals("Ominous Banner"))) {
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							final ItemStack _setstack = new ItemStack(Items.STICK, (int) (1));
							_setstack.setCount((int) 2);
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _setstack);
								}
							});
						}
					}
					world.getPendingBlockTicks().scheduleTick(new BlockPos((int) x, (int) y, (int) z),
							world.getBlockState(new BlockPos((int) x, (int) y, (int) z)).getBlock(), (int) 20);
				}
			} else {
				{
					TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
					if (_ent != null) {
						final int _sltid = (int) (0);
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable) {
								((IItemHandlerModifiable) capability).setStackInSlot(_sltid, ItemStack.EMPTY);
							}
						});
					}
				}
			}
		}
	}
}
