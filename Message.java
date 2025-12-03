public class Message{
    public static String getHitMessage(){
        return "TRUNG!";
    }

    public static String getMissMessage(){
        return "TRUOT.";
    }

    public static String getSunkMessage(String boatName){
        return "TRUNG! " + boatName + " DA CHIM!";
    }

    public static String getAlreadyShotMessage(){
        return "Vi tri nay da ban roi.";
    }
}