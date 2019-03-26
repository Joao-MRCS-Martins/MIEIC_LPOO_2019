public abstract class Node {
    protected Folder parent;
    protected String name;
    private static int number =0;

    public Node() {
        parent = null;
        name = "";
        number++;
    }

    public Node(Folder parent, String name) {
        this.parent = parent;
        this.name = name;
        number++;
    }

    public Folder getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

    public abstract boolean equals(Object o);

    public int getNumber() {
        return number;
    }

    public static void resetNumbering(int n) {
        number = n;
    }

    public abstract int getSize();

    public String getPath() {
        char separ = FileSystem.nf.getSeparator();
        if(parent == null)
            return "";
        else
            return parent.getPath()+separ+this.name;
    }

    public abstract void move(Folder newParent, String newName) throws CycleException,DuplicateNameException;
}
