package net.avicus.compendium.menu.inventory;

import net.avicus.compendium.menu.IndexedMenuItem;

import java.util.*;

public class DefaultInventoryIndexer implements InventoryIndexer {
    @Override
    public Map<Integer, InventoryMenuItem> getIndices(InventoryMenu view, Collection<InventoryMenuItem> items) {
        Map<Integer, InventoryMenuItem> map = new HashMap<>();
        List<Integer> indicesTaken = new ArrayList<>();
        int lastIndex = 0;
        for (InventoryMenuItem item : items) {
            int index;

            if (item instanceof IndexedMenuItem) {
                index = ((IndexedMenuItem) item).getIndex();
            }
            else {
                while (indicesTaken.contains(lastIndex))
                    lastIndex++;
                index = lastIndex;
            }

            map.put(index, item);
            indicesTaken.add(index);
        }

        return map;
    }
}
