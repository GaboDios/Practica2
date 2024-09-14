import java.util.ArrayList;
import java.util.List;

public class TuningCollection {
    private List<TunningDecorator> tuningItems = new ArrayList<>();

    public void addTuningItem(TunningDecorator item) {
        tuningItems.add(item);
    }

    public TuningIterator createIterator() {
        return new TuningIterator(tuningItems);
    }
}
