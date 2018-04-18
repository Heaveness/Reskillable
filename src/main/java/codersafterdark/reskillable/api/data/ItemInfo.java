package codersafterdark.reskillable.api.data;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Objects;

public class ItemInfo implements LockKey {
    private int metadata;
    private Item item;
    private NBTTagCompound tag;

    public ItemInfo(Item item, int metadata) {
        this(item, metadata, null);
    }

    public ItemInfo(Item item, int metadata, NBTTagCompound tag) {
        this.item = item;
        this.metadata = metadata;
        this.tag = tag;
    }

    public NBTTagCompound getTag() {
        return this.tag;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ItemInfo)) {
            return false;
        }
        ItemInfo other = (ItemInfo) o;
        if (item != other.item) {
            return false;
        }
        if (tag == null) {
            return other.tag == null && (metadata == OreDictionary.WILDCARD_VALUE || other.metadata == OreDictionary.WILDCARD_VALUE || metadata == other.metadata);
        }
        return tag.equals(other.tag) && (metadata == OreDictionary.WILDCARD_VALUE || other.metadata == OreDictionary.WILDCARD_VALUE || metadata == other.metadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item, tag);
    }
}