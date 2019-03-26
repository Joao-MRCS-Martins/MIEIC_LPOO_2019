
public abstract class LogicGate {
    private LogicVariable internal_value;
    private LogicVariable[] input_variables;
    private String symbol;

    LogicGate(LogicVariable w1,LogicVariable x1, LogicVariable x2) throws ColisionException,CycleException {
        if(w1.getCalculatedBy() != null)
            throw new ColisionException();
        for(LogicGate gates: w1.getInput()) {
            if (x1.equals(gates.getOutput()) || x2.equals(gates.getOutput())) {
                throw new CycleException();
            }
        }
        input_variables = new LogicVariable[]{x1, x2};
        internal_value = w1;
        x1.addInput(this);
        x2.addInput(this);

    }

    LogicGate(LogicVariable y1,LogicVariable w1) throws ColisionException,CycleException {
        if(y1.getCalculatedBy() != null)
            throw new ColisionException();
        for(LogicGate gates: y1.getInput()) {
            if (w1.equals(gates.getOutput())) {
                throw new CycleException();
            }
        }
        input_variables = new LogicVariable[] {w1};
        internal_value = y1;
        w1.addInput(this);
    }
    public LogicVariable getOutput() {
        return internal_value;
    }

    public LogicVariable[] getInputs() {
        return input_variables;
    }

    public void setOutput(boolean value) {
        this.internal_value.setValue(value);
    }

    protected void setSymbol(String sym) {
        this.symbol = sym;
    }
    public String getSymbol() {
        return symbol;
    }

    public abstract String getFormula();

    public abstract void updateOutput() ;
}
