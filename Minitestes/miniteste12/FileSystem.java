public class FileSystem {
    private String type;
    private Folder root;
    static NameFormatter nf;

    public FileSystem(String type) {
        this.type = type;
        root = new Folder();
    }

    public String getType() {
        return type;
    }

    public Folder getRoot() {
        return root;
    }

    public void setNameFormatter(NameFormatter nf) {
        this.nf = nf;
    }
}
