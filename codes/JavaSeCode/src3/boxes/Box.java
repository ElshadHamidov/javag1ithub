package boxes;

class Box<T> {
    private T item;

    public void addItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void showItem() {
        System.out.println("Item: " + item);
    }
}
