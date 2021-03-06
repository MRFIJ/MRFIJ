package labs.buildings;

import labs.inter.Building;
import labs.exception.FloorIndexOutIfBoundsException;
import labs.exception.InexchangeableFloorsException;
import labs.exception.InexchangeableSpacesException;
import labs.inter.Floor;
import labs.inter.Space;

public class PlacementExchanger {


    public static boolean checkExchangeSpace(Space firstSpace, Space secondSpace) {
        return firstSpace.getArea() == secondSpace.getArea() && firstSpace.getRoom() == secondSpace.getRoom();
    }

    public static boolean checkExchangeFloor(Floor firstFloor, Floor secondFloor) {
        return firstFloor.getSumFloorArea() == secondFloor.getSumFloorArea() && firstFloor.getSumFloorRoom() == secondFloor.getSumFloorRoom();
    }

    public static void exchangeFloorRooms(Floor floor1, int index1, Floor floor2, int index2) throws InexchangeableSpacesException {
        if (!checkExchangeSpace(floor1.getSpaceByNum(index1), floor2.getSpaceByNum(index2))) {
            throw new InexchangeableSpacesException("the space do not correspond to the exchange");
        }
        if (index1 <= 0 & index1 > floor1.getCountSpaceOnFloor() && index2 <= 0 & index2 > floor2.getCountSpaceOnFloor()) {
            throw  new FloorIndexOutIfBoundsException("The space doesn't exist");

        } else {
            Space current = floor1.getSpaceByNum(index1);

            floor1.setSpaceFloor(floor2.getSpaceByNum(index2), index1);
            floor2.setSpaceFloor(current, index2);
        }


    }

    public static void exchangeBuildingFloors(Building building1, int index1, Building building2, int index2) throws InexchangeableFloorsException {

        if (!checkExchangeFloor(building1.getFloorByNum(index1), building2.getFloorByNum(index2))){
            throw new InexchangeableFloorsException("the floor do not correspond to the exchange");
        }
        if (index1 <= 0 & index1 > building1.getCountFloor() && index2 <= 0 & index2 > building2.getCountFloor()) {
            throw  new FloorIndexOutIfBoundsException("The space doesn't exist");

        } else {
            Floor current = building1.getFloorByNum(index1);
            building1.setFloor(index1,building2.getFloorByNum(index2));
            building2.setFloor(index2,current);
        }

    }
}

