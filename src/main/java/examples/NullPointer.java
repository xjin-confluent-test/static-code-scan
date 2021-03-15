package examples;

public class NullPointer {
    public int check(String[] args) {
        String x = get(args[0]);
        return get(x).length();
    }

    public String get(String input) {
            return null;
    }
}
