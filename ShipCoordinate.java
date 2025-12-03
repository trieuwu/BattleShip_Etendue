import java.util.ArrayList;
import java.util.List;

public class ShipCoordinate {
    private Boat boatReference;
    private List<GeometrySystem> coordinates;

    public ShipCoordinate(Boat boat){
        this.boatReference = boat;
        this.coordinates = new ArrayList<>();
    }

    public Boat getBoatReference(){
        return boatReference;
    }

    public List<GeometrySystem> getCoordinates(){
        return coordinates;
    }

    public boolean containsCoordinate(int x, int y){
        for(GeometrySystem cd : coordinates)
            if(cd.getX() == x && cd.getY() == y) return true;
        return false;
    }
}
