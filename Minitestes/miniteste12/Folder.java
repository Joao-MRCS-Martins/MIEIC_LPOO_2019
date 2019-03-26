import java.util.ArrayList;

public class Folder extends Node {
    private ArrayList<Node> children = new ArrayList<>();

    public Folder() {
        super();
    }

    public Folder(Folder parent, String name) throws DuplicateNameException {
        super(parent,name);
        parent.addChild(this);
    }

    public void addChild(Node child) throws DuplicateNameException {
        for(Node node : children) {
            if(node.getName().equals(child.getName()))
                throw new DuplicateNameException();
        }
        children.add(child);
    }

    public Node[] getChild() {
        Node[] child = new Node[children.size()];
        for(int i =0; i < children.size();i++) {
            child[i] = children.get(i);
        }
        return child;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(o instanceof Folder)
            return this.getName().equals(((Folder)o).getName());
        return false;
    }

    public Node getChildByName(String name) {
        for(Node node: children) {
            if(node.getName().equals(name))
                return node;
        }
        return null;
    }

    public int getSize() {
        int sum =0;
        for(Node node: children) {
            sum+= node.getSize();
        }
        return sum;
    }

    @Override
    public void move(Folder newParent, String newName) throws CycleException, DuplicateNameException {
        if(newParent.equals(this)) throw new CycleException();
        if(newParent.getParent() != null && newParent.getParent().equals(this))
            throw new CycleException();
        parent.removeChild(this);
        name = newName;
        this.parent = newParent;
        parent.addChild(this);
    }

    public void removeChild(Node n) {
        for(int i= 0; i <children.size(); i++) {
            if(children.get(i).equals(n)) {
                children.remove(i);
                return;
            }
        }
    }

    public Folder clone(Folder newParent, String newName) throws DuplicateNameException {
        Folder dest = new Folder(newParent,newName);
        for(Node node: children) {
            Node childClone = (node instanceof Folder ? ((Folder)node).clone(dest,node.getName()) : ((File)node).clone(dest));
        }
        return dest;
    }
}
