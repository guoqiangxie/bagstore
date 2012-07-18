package com.jinjiang.bagstore;

import com.jinjiang.bagstore.LockerWall;

import java.util.List;

public class SmartWallChooser implements IWallChooser{
    public LockerWall chooseWall(List<LockerWall> walls1) {
        LockerWall insertLockerWall = walls1.get(0);
        int maxEmptyLockers = 0;
        for (LockerWall store : walls1) {
            if (store.getEmptyLockersNum() > maxEmptyLockers) {
                maxEmptyLockers = store.getEmptyLockersNum();
                insertLockerWall = store;
            }
        }
        return insertLockerWall;
    }
}
