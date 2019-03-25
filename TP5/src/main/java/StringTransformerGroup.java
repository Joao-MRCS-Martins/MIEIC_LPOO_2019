import java.util.List;

public class StringTransformerGroup implements StringTransformer{
    private List<StringTransformer> transformers;

    StringTransformerGroup(List<StringTransformer> transformers) {
        this.transformers = transformers;
    }

    public void execute() {
        for(StringTransformer transformer: transformers)
            transformer.execute();
    }

    @Override
    public void undo() {
        for(int i =transformers.size()-1; i >= 0; i--) {
            transformers.get(i).undo();
        }
    }
}
