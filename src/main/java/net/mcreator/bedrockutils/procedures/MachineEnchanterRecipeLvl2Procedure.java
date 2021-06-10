package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.item.BedrockFragmentItem;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@BedrockutilsModElements.ModElement.Tag
public class MachineEnchanterRecipeLvl2Procedure extends BedrockutilsModElements.ModElement {
	public MachineEnchanterRecipeLvl2Procedure(BedrockutilsModElements instance) {
		super(instance, 110);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MachineEnchanterRecipeLvl2!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MachineEnchanterRecipeLvl2!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MachineEnchanterRecipeLvl2!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MachineEnchanterRecipeLvl2!");
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
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "enchanterlvl2"))) {
			if (((new Object() {
				public ItemStack getItemStack(BlockPos pos, int sltid) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					TileEntity _ent = world.getTileEntity(pos);
					if (_ent != null) {
						_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
					}
					return _retval.get();
				}
			}.getItemStack(new BlockPos((int) x, (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.WRITABLE_BOOK, (int) (1))
					.getItem())) {
				if (!world.isRemote()) {
					BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
					TileEntity _tileEntity = world.getTileEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_tileEntity != null)
						_tileEntity.getTileData().putString("type", "enchantement");
					if (world instanceof World)
						((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.PRISMARINE_SHARD, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.PRISMARINE_CRYSTALS, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Items.COD, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "aqua_affinity");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.GOLDEN_CHESTPLATE, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.TNT, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.OBSIDIAN, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "blast_protection");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.PRISMARINE_SHARD, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.LILY_PAD, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Items.SALMON, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "depth_strider");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.FEATHER, (int) (1))
								.getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.WHITE_WOOL, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.SLIME_BLOCK, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "feather_falling");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.MAGMA_BLOCK, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.LAVA_BUCKET, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.BLUE_ICE, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "fire_protection");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.BLUE_ICE, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.BLUE_ICE, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "frost_walker");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.GOLDEN_SWORD, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.SMOOTH_QUARTZ, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Items.PUFFERFISH, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "impaling");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.CROSSBOW, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.ARROW, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.DISPENSER, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "multishot");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.CROSSBOW, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.ARROW, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.PISTON, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "piercing");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Items.GOLDEN_CHESTPLATE, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.ARROW, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.CRYING_OBSIDIAN, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "projectile_protection");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("craftXpCost", "0");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0))).getItem() == new ItemStack(Items.BOW, (int) (1))
								.getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Blocks.SLIME_BLOCK, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Blocks.PISTON, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "punch");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("craftXpCost", "0");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.STICKY_PISTON, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.WATER_BUCKET, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Items.FEATHER, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "riptide");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
				if ((((new Object() {
					public ItemStack getItemStack(BlockPos pos, int sltid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						TileEntity _ent = world.getTileEntity(pos);
						if (_ent != null) {
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								_retval.set(capability.getStackInSlot(sltid).copy());
							});
						}
						return _retval.get();
					}
				}.getItemStack(new BlockPos((int) (x + 4), (int) y, (int) z), (int) (0)))
						.getItem() == new ItemStack(BedrockFragmentItem.block, (int) (1)).getItem()) && (((new Object() {
							public ItemStack getItemStack(BlockPos pos, int sltid) {
								AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
								TileEntity _ent = world.getTileEntity(pos);
								if (_ent != null) {
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										_retval.set(capability.getStackInSlot(sltid).copy());
									});
								}
								return _retval.get();
							}
						}.getItemStack(new BlockPos((int) (x - 4), (int) y, (int) z), (int) (0)))
								.getItem() == new ItemStack(Blocks.SOUL_SOIL, (int) (1)).getItem()) && (((new Object() {
									public ItemStack getItemStack(BlockPos pos, int sltid) {
										AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
										TileEntity _ent = world.getTileEntity(pos);
										if (_ent != null) {
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												_retval.set(capability.getStackInSlot(sltid).copy());
											});
										}
										return _retval.get();
									}
								}.getItemStack(new BlockPos((int) x, (int) y, (int) (z + 4)), (int) (0)))
										.getItem() == new ItemStack(Items.CAKE, (int) (1)).getItem()) && ((new Object() {
											public ItemStack getItemStack(BlockPos pos, int sltid) {
												AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
												TileEntity _ent = world.getTileEntity(pos);
												if (_ent != null) {
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														_retval.set(capability.getStackInSlot(sltid).copy());
													});
												}
												return _retval.get();
											}
										}.getItemStack(new BlockPos((int) x, (int) y, (int) (z - 4)), (int) (0)))
												.getItem() == new ItemStack(Items.SUGAR, (int) (1)).getItem()))))) {
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putBoolean("suckItemToEnchant", (true));
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putString("enchantementWanted", "soul_speed");
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
					if (!world.isRemote()) {
						BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
						TileEntity _tileEntity = world.getTileEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_tileEntity != null)
							_tileEntity.getTileData().putDouble("craftXpCost", 20);
						if (world instanceof World)
							((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
					}
				}
			}
		}
	}
}
