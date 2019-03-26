public class GateNot extends LogicGate{
    GateNot(LogicVariable y1, LogicVariable w1) throws ColisionException,CycleException {
        super(y1,w1);
        this.setOutput(!w1.getValue());
        this.setSymbol("NOT");
        y1.setCalculatedBy(this);
    }

    public String getFormula() {
        return "NOT("+this.getInputs()[0].getFormula()+")";
    }

    public void updateOutput() {
        this.setOutput(!this.getInputs() [0].getValue());
        this.getOutput().updateOutput();
    }
}
