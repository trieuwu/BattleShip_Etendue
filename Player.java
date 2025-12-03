import java.util.List;
import java.util.ArrayList;

public class Player {
    protected String playerName;
    protected List<ShipCoordinate> shipCoordinateList;
    protected int[][] map;
    protected int remainingCells;
    protected ItemInventory inventory;
    protected int totalShipCells;

    private void initializeBoats(){
        shipCoordinateList.add(new ShipCoordinate(new Boat("Patrol Boat", 2)));
        shipCoordinateList.add(new ShipCoordinate(new Boat("Patrol Boat", 2)));
        shipCoordinateList.add(new ShipCoordinate(new Boat("Destroyer Boat", 4)));
        shipCoordinateList.add(new ShipCoordinate(new Boat("Submarine", 3)));
        shipCoordinateList.add(new ShipCoordinate(new Boat("Battle Ship", 5)));
        for(ShipCoordinate sc : shipCoordinateList) remainingCells += sc.getBoatReference().getBoatSize();
        totalShipCells = remainingCells;
    }

    public Player(String playerName){
        this.playerName = playerName;
        this.shipCoordinateList = new ArrayList();
        this.map = new int[10][10];
        this.remainingCells = 0;
        this.inventory = new ItemInventory();
        this.totalShipCells = 0;
        initializeBoats();
    }

    public int getRemainingCells(){
        return remainingCells;
    }
    public int getTotalShipCells(){
        return totalShipCells;
    }
    public ItemInventory getInventory(){
        return inventory;
    }
    public int[][] getMap(){
        return map;
    }
    public String getPlayerName(){
        return playerName;
    }
    public Boat getShipPosition(int x, int y){
        for(ShipCoordinate sc : shipCoordinateList)
            if(sc.containsCoordinate(x, y))
                return sc.getBoatReference();
        return null;
    }

    private boolean isValid(int x, int y){
        return x >= 0 && x < 10 && y >= 0 && y < 10;
    }
    public boolean isLost(){
        return remainingCells <= 0;
    }

    public ShotResult processShot(int x, int y, int shotType){

    }
}
