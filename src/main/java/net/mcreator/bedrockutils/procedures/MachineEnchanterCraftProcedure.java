package net.mcreator.bedrockutils.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;
import net.minecraft.block.BlockState;

import net.mcreator.bedrockutils.BedrockutilsModVariables;
import net.mcreator.bedrockutils.BedrockutilsModElements;
import net.mcreator.bedrockutils.BedrockutilsMod;

import java.util.Map;
import java.util.HashMap;

@BedrockutilsModElements.ModElement.Tag
public class MachineEnchanterCraftProcedure extends BedrockutilsModElements.ModElement {
	public MachineEnchanterCraftProcedure(BedrockutilsModElements instance) {
		super(instance, 107);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency x for procedure MachineEnchanterCraft!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency y for procedure MachineEnchanterCraft!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency z for procedure MachineEnchanterCraft!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				BedrockutilsMod.LOGGER.warn("Failed to load dependency world for procedure MachineEnchanterCraft!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			MachineEnchanterPullXpProcedure.executeProcedure($_dependencies);
		}
		if (((new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "suckItemToEnchant")) && (new Object() {
			public boolean getValue(IWorld world, BlockPos pos, String tag) {
				TileEntity tileEntity = world.getTileEntity(pos);
				if (tileEntity != null)
					return tileEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "pulledXp")))) {
			new Object() {
				private int ticks = 0;
				private float waitTicks;
				private IWorld world;
				public void start(IWorld world, int waitTicks) {
					this.waitTicks = waitTicks;
					MinecraftForge.EVENT_BUS.register(this);
					this.world = world;
				}

				@SubscribeEvent
				public void tick(TickEvent.ServerTickEvent event) {
					if (event.phase == TickEvent.Phase.END) {
						this.ticks += 1;
						if (this.ticks >= this.waitTicks)
							run();
					}
				}

				private void run() {
					if (world instanceof World && !world.isRemote()) {
						((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.chime")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1);
					} else {
						((World) world).playSound(x, y, z,
								(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("block.note_block.chime")),
								SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
					}
					{
						TileEntity _ent = world.getTileEntity(new BlockPos((int) (x + 4), (int) y, (int) z));
						if (_ent != null) {
							final int _sltid = (int) (0);
							final int _amount = (int) 1;
							_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
								if (capability instanceof IItemHandlerModifiable) {
									ItemStack _stk = capability.getStackInSlot(_sltid).copy();
									_stk.shrink(_amount);
									((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
								}
							});
						}
					}
					new Object() {
						private int ticks = 0;
						private float waitTicks;
						private IWorld world;
						public void start(IWorld world, int waitTicks) {
							this.waitTicks = waitTicks;
							MinecraftForge.EVENT_BUS.register(this);
							this.world = world;
						}

						@SubscribeEvent
						public void tick(TickEvent.ServerTickEvent event) {
							if (event.phase == TickEvent.Phase.END) {
								this.ticks += 1;
								if (this.ticks >= this.waitTicks)
									run();
							}
						}

						private void run() {
							if (world instanceof World && !world.isRemote()) {
								((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("block.note_block.guitar")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1);
							} else {
								((World) world).playSound(x, y, z,
										(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
												.getValue(new ResourceLocation("block.note_block.guitar")),
										SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
							}
							{
								TileEntity _ent = world.getTileEntity(new BlockPos((int) (x - 4), (int) y, (int) z));
								if (_ent != null) {
									final int _sltid = (int) (0);
									final int _amount = (int) 1;
									_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable) {
											ItemStack _stk = capability.getStackInSlot(_sltid).copy();
											_stk.shrink(_amount);
											((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
										}
									});
								}
							}
							new Object() {
								private int ticks = 0;
								private float waitTicks;
								private IWorld world;
								public void start(IWorld world, int waitTicks) {
									this.waitTicks = waitTicks;
									MinecraftForge.EVENT_BUS.register(this);
									this.world = world;
								}

								@SubscribeEvent
								public void tick(TickEvent.ServerTickEvent event) {
									if (event.phase == TickEvent.Phase.END) {
										this.ticks += 1;
										if (this.ticks >= this.waitTicks)
											run();
									}
								}

								private void run() {
									if (world instanceof World && !world.isRemote()) {
										((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.note_block.flute")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1);
									} else {
										((World) world).playSound(x, y, z,
												(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
														.getValue(new ResourceLocation("block.note_block.flute")),
												SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
									}
									{
										TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z + 4)));
										if (_ent != null) {
											final int _sltid = (int) (0);
											final int _amount = (int) 1;
											_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
												if (capability instanceof IItemHandlerModifiable) {
													ItemStack _stk = capability.getStackInSlot(_sltid).copy();
													_stk.shrink(_amount);
													((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
												}
											});
										}
									}
									new Object() {
										private int ticks = 0;
										private float waitTicks;
										private IWorld world;
										public void start(IWorld world, int waitTicks) {
											this.waitTicks = waitTicks;
											MinecraftForge.EVENT_BUS.register(this);
											this.world = world;
										}

										@SubscribeEvent
										public void tick(TickEvent.ServerTickEvent event) {
											if (event.phase == TickEvent.Phase.END) {
												this.ticks += 1;
												if (this.ticks >= this.waitTicks)
													run();
											}
										}

										private void run() {
											if (world instanceof World && !world.isRemote()) {
												((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("block.note_block.harp")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1);
											} else {
												((World) world).playSound(x, y, z,
														(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																.getValue(new ResourceLocation("block.note_block.harp")),
														SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
											}
											{
												TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) (z - 4)));
												if (_ent != null) {
													final int _sltid = (int) (0);
													final int _amount = (int) 1;
													_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
														if (capability instanceof IItemHandlerModifiable) {
															ItemStack _stk = capability.getStackInSlot(_sltid).copy();
															_stk.shrink(_amount);
															((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
														}
													});
												}
											}
											new Object() {
												private int ticks = 0;
												private float waitTicks;
												private IWorld world;
												public void start(IWorld world, int waitTicks) {
													this.waitTicks = waitTicks;
													MinecraftForge.EVENT_BUS.register(this);
													this.world = world;
												}

												@SubscribeEvent
												public void tick(TickEvent.ServerTickEvent event) {
													if (event.phase == TickEvent.Phase.END) {
														this.ticks += 1;
														if (this.ticks >= this.waitTicks)
															run();
													}
												}

												private void run() {
													if (world instanceof World && !world.isRemote()) {
														((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("block.note_block.pling")),
																SoundCategory.NEUTRAL, (float) 1, (float) 1);
													} else {
														((World) world).playSound(x, y, z,
																(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																		.getValue(new ResourceLocation("block.note_block.pling")),
																SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
													}
													{
														TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) y, (int) z));
														if (_ent != null) {
															final int _sltid = (int) (0);
															final int _amount = (int) 1;
															_ent.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
																	.ifPresent(capability -> {
																		if (capability instanceof IItemHandlerModifiable) {
																			ItemStack _stk = capability.getStackInSlot(_sltid).copy();
																			_stk.shrink(_amount);
																			((IItemHandlerModifiable) capability).setStackInSlot(_sltid, _stk);
																		}
																	});
														}
													}
													if ((((new Object() {
														public String getValue(IWorld world, BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getString(tag);
															return "";
														}
													}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "type"))).equals("internal"))) {
														if (world instanceof World && !world.isRemote()) {
															((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("block.note_block.pling")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1);
														} else {
															((World) world).playSound(x, y, z,
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("block.note_block.pling")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
														}
														if (world instanceof World && !world.isRemote()) {
															ItemEntity entityToSpawn = new ItemEntity((World) world, x, y, z,
																	(BedrockutilsModVariables.WorldVariables.get(world).enchanterCraftedOutput));
															entityToSpawn.setPickupDelay((int) 10);
															entityToSpawn.setNoDespawn();
															world.addEntity(entityToSpawn);
														}
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putBoolean("suckItemToEnchant", (false));
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putBoolean("pulledXp", (false));
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
													} else if ((((new Object() {
														public String getValue(IWorld world, BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getString(tag);
															return "";
														}
													}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "type"))).equals("external"))) {
														if (world instanceof World && !world.isRemote()) {
															((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("block.note_block.pling")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1);
														} else {
															((World) world).playSound(x, y, z,
																	(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																			.getValue(new ResourceLocation("block.note_block.pling")),
																	SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
														}
														if (world instanceof ServerWorld) {
															((World) world).getServer().getCommandManager().handleCommand(
																	new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																			(ServerWorld) world, 4, "", new StringTextComponent(""),
																			((World) world).getServer(), null).withFeedbackDisabled(),
																	(("give @p ") + "" + ((new Object() {
																		public String getValue(IWorld world, BlockPos pos, String tag) {
																			TileEntity tileEntity = world.getTileEntity(pos);
																			if (tileEntity != null)
																				return tileEntity.getTileData().getString(tag);
																			return "";
																		}
																	}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "craftModId"))) + ""
																			+ (":") + "" + ((new Object() {
																				public String getValue(IWorld world, BlockPos pos, String tag) {
																					TileEntity tileEntity = world.getTileEntity(pos);
																					if (tileEntity != null)
																						return tileEntity.getTileData().getString(tag);
																					return "";
																				}
																			}.getValue(world, new BlockPos((int) x, (int) y, (int) z),
																					"craftName")))));
														}
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putBoolean("suckItemToEnchant", (false));
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putBoolean("pulledXp", (false));
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
													} else if ((((new Object() {
														public String getValue(IWorld world, BlockPos pos, String tag) {
															TileEntity tileEntity = world.getTileEntity(pos);
															if (tileEntity != null)
																return tileEntity.getTileData().getString(tag);
															return "";
														}
													}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "type"))).equals("enchantement"))) {
														if (!world.isRemote()) {
															BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
															TileEntity _tileEntity = world.getTileEntity(_bp);
															BlockState _bs = world.getBlockState(_bp);
															if (_tileEntity != null)
																_tileEntity.getTileData().putBoolean("canGiveBook", (true));
															if (world instanceof World)
																((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
														}
														if ((new Object() {
															public boolean getValue(IWorld world, BlockPos pos, String tag) {
																TileEntity tileEntity = world.getTileEntity(pos);
																if (tileEntity != null)
																	return tileEntity.getTileData().getBoolean(tag);
																return false;
															}
														}.getValue(world, new BlockPos((int) x, (int) y, (int) z), "canGiveBook"))) {
															if (world instanceof World && !world.isRemote()) {
																((World) world).playSound(null, new BlockPos((int) x, (int) y, (int) z),
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("block.note_block.pling")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1);
															} else {
																((World) world).playSound(x, y, z,
																		(net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS
																				.getValue(new ResourceLocation("block.note_block.pling")),
																		SoundCategory.NEUTRAL, (float) 1, (float) 1, false);
															}
															if (world instanceof ServerWorld) {
																((World) world).getServer().getCommandManager().handleCommand(
																		new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO,
																				(ServerWorld) world, 4, "", new StringTextComponent(""),
																				((World) world).getServer(), null).withFeedbackDisabled(),
																		(("give @p enchanted_book{StoredEnchantments:[{id:") + "" + ((new Object() {
																			public String getValue(IWorld world, BlockPos pos, String tag) {
																				TileEntity tileEntity = world.getTileEntity(pos);
																				if (tileEntity != null)
																					return tileEntity.getTileData().getString(tag);
																				return "";
																			}
																		}.getValue(world, new BlockPos((int) x, (int) y, (int) z),
																				"enchantementWanted"))) + "" + (",lvl:1}]} 1")));
															}
															if (!world.isRemote()) {
																BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
																TileEntity _tileEntity = world.getTileEntity(_bp);
																BlockState _bs = world.getBlockState(_bp);
																if (_tileEntity != null)
																	_tileEntity.getTileData().putBoolean("suckItemToEnchant", (false));
																if (world instanceof World)
																	((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
															}
															if (!world.isRemote()) {
																BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
																TileEntity _tileEntity = world.getTileEntity(_bp);
																BlockState _bs = world.getBlockState(_bp);
																if (_tileEntity != null)
																	_tileEntity.getTileData().putBoolean("pulledXp", (false));
																if (world instanceof World)
																	((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
															}
															if (!world.isRemote()) {
																BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
																TileEntity _tileEntity = world.getTileEntity(_bp);
																BlockState _bs = world.getBlockState(_bp);
																if (_tileEntity != null)
																	_tileEntity.getTileData().putBoolean("canGiveBook", (false));
																if (world instanceof World)
																	((World) world).notifyBlockUpdate(_bp, _bs, _bs, 3);
															}
														}
													}
													MinecraftForge.EVENT_BUS.unregister(this);
												}
											}.start(world, (int) 40);
											MinecraftForge.EVENT_BUS.unregister(this);
										}
									}.start(world, (int) 40);
									MinecraftForge.EVENT_BUS.unregister(this);
								}
							}.start(world, (int) 40);
							MinecraftForge.EVENT_BUS.unregister(this);
						}
					}.start(world, (int) 40);
					MinecraftForge.EVENT_BUS.unregister(this);
				}
			}.start(world, (int) 40);
		}
	}
}
