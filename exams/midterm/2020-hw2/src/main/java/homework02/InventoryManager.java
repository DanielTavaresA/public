// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// You CAN change the bodies of existing methods/constructors
// You CAN add new private methods/constructors
// You CANNOT add interface implementations unless explicitly instructed to do so
// You CANNOT add new public, package-private or protected methods/constructors
// You CANNOT edit the names, parameters, checked exceptions or return types of existing methods/constructors
// You CANNOT delete existing methods/constructors
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

package homework02;

import homework02.util.InventoryObserver;
import homework02.util.Logger;
import homework02.util.Manager;

/**
 * Implementation of the {@link Manager} interface. See the interface documentation.
 */
public class InventoryManager implements Manager {

    private final InventoryDatabase database;
    private InventoryObserver inventoryObserver = null;
    /**
     * Creates a new manager for the given database.
     *
     * @param database The database, which cannot be null
     */
    public InventoryManager(InventoryDatabase database) {
        this.database = database;
    }

    @Override
    public void add(ItemKind itemKind) {
        int quantity = database.get(itemKind);
        database.update(itemKind, quantity + 1);
    }

    @Override
    public boolean take(ItemKind itemKind) {
       int quantity = database.get(itemKind);
       database.update(itemKind, quantity - 1);
       return true;
    }

    @Override
    public int getQuantity(ItemKind itemKind) {
        return database.get(itemKind);
    }

    @Override
    public void addObserver(InventoryObserver observer) {
        inventoryObserver = observer;
    }
}