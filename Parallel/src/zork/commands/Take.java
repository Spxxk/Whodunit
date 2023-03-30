package zork.commands;

import zork.*;

public class Take extends Command {
    Item item;
    Inventory inv_take, inv_recieve;

    public Take(Item item, Inventory inv_take, Inventory inv_recieve) {
        super(item);

        this.item = item;
        this.inv_take = inv_take;
        this.inv_recieve = inv_recieve;
    }

    public Inventory[] takeItem() {
        inv_take.removeItem(item);
        inv_recieve.addItem(item);

        return new Inventory[] { inv_take, inv_recieve };
    }
}