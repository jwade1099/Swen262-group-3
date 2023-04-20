package source;

public enum Command {
    HELP("H"),
    WORKOUT("W"),
    GOAL("G"),
    LOGOUT("L"),
    EXIT("E"),
    USER_HISTORY("U"),
    DEFAULT("");

    public final String command;

    public String toString(){
        return this.command;
    }

    Command(String command) {
        this.command = command;
    }
}
