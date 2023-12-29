import java.util.ArrayList;

public record MenuItem(
        int id,
        String name,
        String category,
        Double price,
        ArrayList<Option> options) {
    public record Option(
            String name,
            Double price) {
    }
}
