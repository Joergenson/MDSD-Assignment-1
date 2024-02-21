package main.metamodel;

public class Transition{
	private String _event;
	private State _target;
	private String _operationVariableName;
	private Integer _operationValue;
	private Operation _operation = Operation.NONE;
	
	private String _conditionVariableName;
	private Integer _conditionCompareValue;
	private ConditionType _condition = ConditionType.NONE;
	
	public enum Operation {
		NONE,
		SET,
		INCREMENT,
		DECREMENT
	}
	
	public enum ConditionType {
		NONE,
		EQUALS,
		GREATER_THAN,
		LESS_THAN
	}
	
	public Transition(String event) {
		_event = event;
	}
	
	public String getEvent() {
		return _event;
	}

	public State getTarget() {
		return _target;
	}
	
	public void setTarget(State targetState) {
		_target = targetState;
	}
	
	public void setOperation(Operation operation, String operationVariableName, Integer operationValue) {
		_operation = operation;
		_operationVariableName = operationVariableName;
		_operationValue = operationValue;
	}
	public Operation getOperation() {
		return _operation;
	}

	public Integer getOperationValue() {
		return _operationValue;
	}
	
	public ConditionType getConditionType() {
		return _condition;
	}
	
	public void setCondition(ConditionType condition, String compareVariableName , Integer compareValue) {
		_condition = condition;
		_conditionVariableName = compareVariableName;
		_conditionCompareValue = compareValue;
	}

	public boolean hasSetOperation() {
		return _operation == Operation.SET;
	}

	public boolean hasIncrementOperation() {
		return _operation == Operation.INCREMENT;
	}

	public boolean hasDecrementOperation() {
		return _operation == Operation.DECREMENT;
	}

	public String getOperationVariableName() {
		return _operationVariableName;
	}

	public boolean isConditional() {
		return _condition != ConditionType.NONE;
	}

	public String getConditionVariableName() {
		return _conditionVariableName;
	}

	public Integer getConditionComparedValue() {
		return _conditionCompareValue;
	}

	public boolean isConditionEqual() {
		return _condition == ConditionType.EQUALS;
	}

	public boolean isConditionGreaterThan() {
		return _condition == ConditionType.GREATER_THAN;
	}

	public boolean isConditionLessThan() {
		return _condition == ConditionType.LESS_THAN;
	}

	public boolean hasOperation() {
		return _operation != Operation.NONE;
	}

}
