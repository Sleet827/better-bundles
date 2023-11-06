package net.sleet.mixin;

import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public class BundleItemMixin {
	@Inject(method = "getItemOccupancy", at = @At("HEAD"), cancellable = true)
	private static void getItemOccupancyInject(ItemStack stack, CallbackInfoReturnable<Integer> cir) {
		if (!stack.isStackable()) {
			cir.setReturnValue(1);
		}
	}
}