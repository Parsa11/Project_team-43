package View;

public class OffPanel extends Menu {
    public OffPanel(Menu parent, String name) {
        super(parent, name);
        submenus.put(1, getOffs());
        submenus.put(2, new ProductPanel(this, "product Panel"));
        submenus.put(3, getFiltering());
    }

    private Menu getOffs() {

        return new Menu(this, "Offs") {
            @Override
            public void show() {
                manager.showOffs();

            }

            @Override
            public void run() {
                this.parent.show();
                this.parent.run();
            }
        };
    }


    public Menu getFiltering() {

        return new Menu(this, "filtering") {
            @Override
            public void show() {
                String command = scanner.nextLine();
                manager.filteringProcess(command);
                //
            }

            @Override
            public void run() {
                this.parent.show();
                this.parent.run();
            }
        };
    }

    public void execute() {
        this.show();
        this.run();
    }
}
