import java.util.List;

public class TuningIterator implements Iterator<TunningDecorator> {
    private List<TunningDecorator> items;
    private int position = 0;

    public TuningIterator(List<TunningDecorator> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public TunningDecorator next() {
        if (this.hasNext()) {
            return items.get(position++);
        }
        return null;
    }
}
