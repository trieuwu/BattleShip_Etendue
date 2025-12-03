public class ItemInventory {
    private int itBombCount;
    private int nukeBombCount;
    private boolean itBombUnlocked;
    private boolean nukeBombUnlocked;

    public ItemInventory(){
        this.itBombCount = 0;
        this.itBombUnlocked = false;
        this.nukeBombCount = 0;
        this.nukeBombUnlocked = false;
    }

    public void unlockItBomb(){
        if(!itBombUnlocked){
            itBombUnlocked = true;
            itBombCount = 2;
        }
    }
    public void unlockNukeBomb(){
        if(!nukeBombUnlocked){
            nukeBombUnlocked = true;
            nukeBombCount = 2;
        }
    }

    public boolean useItBomb(){
        if(itBombCount > 0){
            itBombCount--;
            return true;
        }
        return false;
    }
    public boolean useNukeBomb(){
        if(nukeBombCount > 0){
            nukeBombCount--;
            return true;
        }
        return false;
    }

    public int getItBombCount(){
        return itBombCount;
    }
    public int getNukeBombCount(){
        return nukeBombCount;
    }
}
