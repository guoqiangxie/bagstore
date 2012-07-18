package com.jinjiang.bagstore;

import junit.framework.Assert;
import org.junit.Test;

public class SmartRobotTest {

    @Test
    public void should_be_able_to_store_in_first_wall_when_two_wall_has_the_same_empty_lockers(){

        Bag bag = new Bag();
        LockerWall w1 = new LockerWall(10);
        LockerWall w2 = new LockerWall(10);
        Robot sr = new Robot(new SmartWallChooser(), w1, w2);
        sr.put(bag);
        int w1EmptyLockersNum = w1.getEmptyLockersNum();
        int w2EmptyLockersNum = w2.getEmptyLockersNum();
        Assert.assertEquals(9, w1EmptyLockersNum);
        Assert.assertEquals(10, w2EmptyLockersNum);
    }

    @Test
     public void should_be_able_to_store_in_more_empty_lockers_wall_when_two_wall_has_diff_empty_lockers(){

        LockerWall w1 = new LockerWall(10);
        LockerWall w2 = new LockerWall(10);
        Robot sr = new Robot(new SmartWallChooser(), w1, w2);
        sr.put(new Bag());
        sr.put(new Bag());
        int w1EmptyLockersNum = w1.getEmptyLockersNum();
        int w2EmptyLockersNum = w2.getEmptyLockersNum();
        Assert.assertEquals(9, w1EmptyLockersNum);
        Assert.assertEquals(9, w2EmptyLockersNum);
    }

    @Test(expected = BagStoreIsFullException.class)
    public void should_not_be_able_to_store_when_has_not_empty_lockers(){

        LockerWall w1 = new LockerWall(1);
        LockerWall w2 = new LockerWall(1);
        Robot sr = new Robot(new SmartWallChooser(), w1, w2);
        sr.put(new Bag());
        sr.put(new Bag());
        sr.put(new Bag());
    }
}
