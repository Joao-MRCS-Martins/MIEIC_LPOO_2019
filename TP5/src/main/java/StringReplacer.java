public class StringReplacer implements StringTransformer{
    private StringDrink sd;
    private char toReplace;
    private char replaceWith;

    StringReplacer(StringDrink sd, char toReplace, char replaceWith) {
        this.sd = sd;
        this.toReplace = toReplace;
        this.replaceWith = replaceWith;
    }

    @Override
    public void execute() {
        sd.setText(sd.getText().replace(toReplace,replaceWith));
    }

    @Override
    public void undo() {
        sd.setText(sd.getText().replace(replaceWith,toReplace));
    }
}
