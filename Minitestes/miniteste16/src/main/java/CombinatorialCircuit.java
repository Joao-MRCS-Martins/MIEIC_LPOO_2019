import java.util.ArrayList;
import java.util.List;

public class CombinatorialCircuit {
    private List<LogicVariable> variables;

    CombinatorialCircuit() {
        variables = new ArrayList<>();
    }

    public boolean addVariable(LogicVariable v) {
        for(LogicVariable listed : variables) {
            if(listed.equals(v))
                return false;
        }
        return variables.add(v);
    }

    public LogicVariable getVariableByName(String var) {
        for(LogicVariable listed: variables) {
            if(listed.getName().equals(var)) {
                return listed;
            }
        }
        return null;
    }
}