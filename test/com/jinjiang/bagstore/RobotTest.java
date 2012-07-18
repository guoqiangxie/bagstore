package com.jinjiang.bagstore;

import org.junit.Assert;
import org.junit.Test;

public class RobotTest {

    @Test
    public void should_be_able_to_store_bag() {
        Bag bag = new Bag();
        Robot robot = new Robot(new WallChooser(), new LockerWall(10),new LockerWall(5));
        Ticket actualKey = robot.put(bag);
        Assert.assertNotNull(actualKey);
    }

    @Test
    public void should_be_return_bag_when_given_key() {
        Bag bag = new Bag();
        Robot robot = new Robot(new WallChooser(), new LockerWall(10));
        Ticket key = robot.put(bag);
        Bag bagFromStore = robot.pop(key);
        Assert.assertSame(bag,bagFromStore);

    }

    @Test
    public void should_be_NullBag_when_given_not_exist_key() {
        Robot robot = new Robot(new WallChooser(), new LockerWall(10));
        Assert.assertSame(Bag.NULLBAG, robot.pop(new Ticket()));
    }

    @Test(expected = BagStoreIsFullException.class)
    public void should_be_throw_BagStoreIsFullException_when_is_full() {
        Robot robot = new Robot(new WallChooser(), new LockerWall(1));
        robot.put(new Bag());
        robot.put(new Bag());
    }
}
