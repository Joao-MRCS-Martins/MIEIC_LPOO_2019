import java.lang.*;
public class StringInverter implements  StringTransformer{
    private StringDrink sd;
    StringInverter(StringDrink sd) {
        this.sd = sd;
    }
    @Override
    public void execute() {
        StringBuilder b = new StringBuilder();
        b.append(sd.getText());
        b.reverse();
        sd.setText(b.toString());
    }

    @Override
    public void undo() {
        execute();
    }
}
