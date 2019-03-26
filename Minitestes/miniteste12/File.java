public class File extends Node {
    private int size;

    public File(Folder parent, String name) throws DuplicateNameException {
        super(parent, name);
        parent.addChild(this);
        size = 0;
    }

    public File(Folder parent, String name,int size) throws DuplicateNameException {
        super(parent, name);
        parent.addChild(this);
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if(this ==o) return true;
        if(o == null) return false;
        if(o instanceof File)
            return this.getName().equals(((File)o).getName());
        return false;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void move(Folder newParent, String newName) throws CycleException, DuplicateNameException {
        parent.removeChild(this);
        name = newName;
        parent = newParent;
        parent.addChild(this);
    }

    public File clone(Folder parent) throws DuplicateNameException{
        File dest = new File(parent,getName(),size);
        return dest;
    }
}
