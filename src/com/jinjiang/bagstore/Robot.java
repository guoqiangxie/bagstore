package com.jinjiang.bagstore;

import java.util.*;

public class Robot {
    protected List<LockerWall> stores;
    protected final IWallChooser IWallChooser;

    public Robot(IWallChooser chooserI, LockerWall... lockerWalls) {
        stores = new ArrayList<LockerWall>(lockerWalls.length);

        for (LockerWall lockerWall : lockerWalls) {
            stores.add(lockerWall);
        }
        IWallChooser = chooserI;
    }

    public Ticket put(Bag bag) {
        LockerWall theWall = IWallChooser.chooseWall(stores);
        Ticket key = theWall.put(bag);
        return key;

    }

    public Bag pop(Ticket key) {
        for (LockerWall store : stores) {
            if (store.contains(key)) {
                return store.pop(key);
            }
        }
        return Bag.NULLBAG;
    }
}
