public class StringCaseChanger implements StringTransformer {
    private StringDrink sd;
    StringCaseChanger(StringDrink sd) {
        this.sd = sd;
    }


    @Override
    public void execute() {
        String cases = sd.getText();
        StringBuffer b = new StringBuffer();
        for(int i = 0; i < cases.length(); i++) {
            if(Character.isLowerCase(cases.charAt(i)))
                b.append(Character.toUpperCase(cases.charAt(i)));
            else
                b.append(Character.toLowerCase(cases.charAt(i)));
        }
        sd.setText(b.toString());
    }

    @Override
    public void undo() {
        execute();
    }
}
