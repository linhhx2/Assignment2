package menu;

public class ProductMenu implements Menu {
    private Menu parent;

    @Override
    public Menu run() {
        return null;
    }

    public Menu getParent() {
        return parent;
    }

    public void setParent(Menu parent) {
        this.parent = parent;
    }
}
