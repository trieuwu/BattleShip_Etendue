import java.util.List;
import java.util.ArrayList;

public class ShotResult {
    public enum Type{MISS, HIT, SUNK, ALREADY_SHOT};
    private Type type;
    private String message;
    private String sunkShipName;
    private int sunkShipSize;
    private List<GeometrySystem> affectedCells;

    public ShotResult(Type type, String message){
        this.type = type;
        this.message = message;
        this.sunkShipName = "";
        this.sunkShipSize = 0;
        this.affectedCells = new ArrayList<>();
    }

    public void setSunkShipInfo(String name, int size){
        this.sunkShipName = name;
        this.sunkShipSize = size;
    }
    public void addAffectedCell(int x, int y){
        this.affectedCells.add(new GeometrySystem(x,y));
    }

    public Type getType() {
        return type;
    }
    public String getMessage() {
        return message;
    }
    public String getSunkShipName(){
        return sunkShipName;
    }
    public int getSunkShipSize(){
        return sunkShipSize;
    }
}
