package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;

public class MachineInterpreter {
    private Machine _machine;
    private State _currentState;

    public void run(Machine m) {
        _machine = m;
        _currentState = _machine.getInitialState();
    }

    public State getCurrentState() {
        return _currentState;
    }

    public void processEvent(String event) {
        for (Transition transition : _currentState.getTransitions()) {
            if (transition.getEvent().equals(event)) {
                State target = transition.getTarget();

                if (transition.isConditional()) {
                    if (checkCondition(transition)) {
                        executeOperation(transition);
                        _currentState = target;
                        break;
                    }
                    continue;
                } else if (transition.hasOperation()) {
                    executeOperation(transition);
                    _currentState = target;
                    break;
                }

                _currentState = target;
                break;
            }
        }
    }


    private void executeOperation(Transition transition) {
        String variableName = transition.getOperationVariableName();
        Integer value = transition.getOperationValue();
        Integer machineInteger = _machine.getInteger(variableName);

        switch (transition.getOperation()) {
            case SET: {
                _machine.setInteger(variableName, value);
                break;
            }
            case INCREMENT: {
                _machine.setInteger(variableName, ++machineInteger);
                break;
            }
            case DECREMENT: {
                _machine.setInteger(variableName, --machineInteger);
                break;
            }
        }
    }

    private boolean checkCondition(Transition transition) {
        String variableName = transition.getConditionVariableName();
        Integer variable = _machine.getInteger(variableName);
        Integer comparisonValue = transition.getConditionComparedValue();

        switch (transition.getConditionType()) {
            case EQUALS: {
                return comparisonValue.equals(variable);
            }
            case GREATER_THAN: {
                return variable > comparisonValue;
            }
            case LESS_THAN: {
                return variable < comparisonValue;
            }
            default:
                return false;
        }
    }

    public int getInteger(String string) {
        return _machine.getInteger(string);
    }

}
