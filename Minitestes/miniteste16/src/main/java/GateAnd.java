public class GateAnd extends LogicGate{
    GateAnd(LogicVariable w1, LogicVariable x1, LogicVariable x2) throws ColisionException,CycleException {
        super(w1,x1,x2);
        this.setOutput(x1.getValue() && x2.getValue());
        this.setSymbol("AND");
        w1.setCalculatedBy(this);
    }

    public String getFormula() {
        return "AND("+this.getInputs()[0].getFormula()+","+this.getInputs()[1].getFormula()+")";
    }

    public void updateOutput() {
        this.setOutput(this.getInputs() [0].getValue() && this.getInputs()[1].getValue());
        this.getOutput().updateOutput();
    }
}
