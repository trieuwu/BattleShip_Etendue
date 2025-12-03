public class Boat{
    public String boatName;
    public int boatSize;
    public int hitsTaken;

    public Boat(String boatName, int boatSize){
        this.boatName = boatName;
        this.boatSize = boatSize;
        this.hitsTaken = 0;
    }

    public String getBoatName(){
        return boatName;
    }
    public int getBoatSize(){
        return boatSize;
    }
    public void hitCheck(){
        if(hitsTaken < boatSize) hitsTaken++;
    }
    public boolean checkSunk(){
        return hitsTaken >= boatSize;
    }

    public int getHitsTaken(){
        return hitsTaken;
    }
}
