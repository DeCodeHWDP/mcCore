package pl.gr4ss.core.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta meta;

    public ItemBuilder(final Material mat) {
        this(mat, 1);
    }

    public ItemBuilder(final Material mat, final int amount) {
        this(mat, amount, (short) 0);
    }

    public ItemBuilder(final Material mat, final short data) {
        this(mat, 1, data);
    }

    public ItemBuilder(final Material mat, final int amount, final short data) {
        this(new ItemStack(mat, amount, data));
    }

    public ItemBuilder(final ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public ItemBuilder addLore(final String... lores) {
        final List<String> loress = Utils.fixColor(Arrays.asList(lores));
        if (!meta.hasLore()) {
            meta.setLore(loress);
        } else {
            final List<String> lore = meta.getLore();
            lore.addAll(loress);
            meta.setLore(lore);
        }
        return this;
    }

    public ItemBuilder addEnchantment(final Enchantment enchant, final int level) {
        meta.addEnchant(enchant, level, true);
        return this;
    }

    public ItemStack build() {
        item.setItemMeta(meta);
        return item;
    }

    public ItemBuilder setTitle(final String title) {
        meta.setDisplayName(Utils.fixColor(title));
        return this;
    }

    public ItemBuilder setGlow() {
        this.meta.addEnchant(Enchantment.DURABILITY, 10, true);
        this.meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return this;
    }
}