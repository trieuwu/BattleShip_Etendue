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
        ShotResult finalResult = new ShotResult(ShotResult.Type.MISS, Message.getMissMessage());
        List<GeometrySystem> targets = new ArrayList<>();
        targets.add(new GeometrySystem(x, y));

        if(shotType == 1){
            for(int i=0; i<10; i++){
                if(i != x) targets.add(new GeometrySystem(i, y));
                if(i != y) targets.add(new GeometrySystem(x, i));
            }
        }else if(shotType == 2){
            for(int i = x-1; i <= x+1; i++){
                for(int j = y-1; j <= y+1; j++)
                    if(isValid(i, j) && (i!=x || j!=y)) targets.add(new GeometrySystem(i, j));
            }
        }

        boolean hitSomething = false;
        boolean sunkSomething = false;

        for(GeometrySystem t : targets){
            ShotResult result = receiveSingleShot(t.getX(), t.getY());
            if(result.getType() != ShotResult.Type.ALREADY_SHOT)
                finalResult.addAffectedCell(t.getX(), t.getY());
            if(result.getType() == ShotResult.Type.HIT){
                hitSomething = true;
                finalResult = result;
            }else if(result.getType() == ShotResult.Type.SUNK){
                hitSomething = true;
                sunkSomething = true;
                finalResult = result;
            }
        }

        if(hitSomething && !sunkSomething)
            return new ShotResult(ShotResult.Type.HIT, Message.getHitMessage());

        return finalResult;
    }

    private ShotResult receiveSingleShot(int x, int y){
        if(!isValid(x, y)) return new ShotResult(ShotResult.Type.ALREADY_SHOT, "");

        if(map[x][y] == 1){
            map[x][y] = 2;
            remainingCells--;
            Boat hitBoat = getShipPosition(x, y);
            if(hitBoat != null){
                hitBoat.hitCheck();
                if(hitBoat.checkSunk()){
                    ShotResult res = new ShotResult(ShotResult.Type.SUNK, Message.getSunkMessage(hitBoat.getBoatName()));
                    res.setSunkShipInfo(hitBoat.getBoatName(), hitBoat.getBoatSize());
                    return res;
                }
            }
            return new ShotResult(ShotResult.Type.HIT, Message.getHitMessage());
        }
        if(map[x][y] == 0){
            map[x][y] = 3;
            return new ShotResult(ShotResult.Type.MISS, Message.getMissMessage());
        }
        return new ShotResult(ShotResult.Type.ALREADY_SHOT, Message.getAlreadyShotMessage());
    }
}
