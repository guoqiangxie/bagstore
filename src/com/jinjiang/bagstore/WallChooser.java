package com.jinjiang.bagstore;

import com.jinjiang.bagstore.LockerWall;

import java.util.List;

public class WallChooser implements IWallChooser {
    @Override
    public LockerWall chooseWall(List<LockerWall> walls) {
        LockerWall theWall = walls.get(0);
        for (LockerWall store : walls) {
            if (!store.isFull()) {
                theWall = store;
                break;
            }
        }
        return theWall;
    }
}
