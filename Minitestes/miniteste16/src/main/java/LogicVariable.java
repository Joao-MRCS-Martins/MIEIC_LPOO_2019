import java.util.ArrayList;
import java.util.List;

public class LogicVariable {
    private String name;
    private boolean value;
    private LogicGate calculatedBy;
    private List<LogicGate> input;

    LogicVariable(String name, boolean value) {
        this.name = name;
        this.value = value;
        input = new ArrayList<>();
    }

    LogicVariable(String name) {
        this.name = name;
        value = true;
        input = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean getValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
        this.updateOutput();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof LogicVariable && name.equals(((LogicVariable) o).getName());
    }

    public LogicGate getCalculatedBy() {
        return calculatedBy;
    }

    public void setCalculatedBy(LogicGate calculatedBy) {
        this.calculatedBy = calculatedBy;
    }

    public String getFormula() {
        if(this.getCalculatedBy() == null)
            return this.name;
        else
            return this.getCalculatedBy().getFormula();
    }

    public List<LogicGate> getInput() {
        return input;
    }

    public void addInput(LogicGate l) {
        this.input.add(l);
    }

    public void updateOutput() {
        for(LogicGate gate: input)
            gate.updateOutput();
    }
}
