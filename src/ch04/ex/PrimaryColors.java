package ch04.ex;

public enum PrimaryColors {
    BLACK("Black"),
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green"),
    CYAN("Cyan"),
    MAGENTA("Magenta"),
    YELLOW("Yellow"),
    WHITE("White");

    private final String name;
    PrimaryColors(String name){
        this.name = name;
    }

    public String getRed(){
        return RED.name;
    }
    public String getBlue(){
        return BLUE.name;
    }

    public String getGreen(){
        return GREEN.name;
    }
}
