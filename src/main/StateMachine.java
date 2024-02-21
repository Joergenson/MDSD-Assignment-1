package main;

import main.metamodel.Machine;
import main.metamodel.State;
import main.metamodel.Transition;
import main.metamodel.Transition.Operation;

public class StateMachine {
	private Machine _machine = new Machine();
	private State _latestState;
	private Transition _latestTransition;


	public Machine build() {
		// TODO Auto-generated method stub
		return _machine;
	}

	public StateMachine state(String string) {
		State state = _machine.getState(string);
		if (state == null)
			state = _machine.addState(string);
		_latestState = state;
		return this;
	}

	public StateMachine initial() {
		_machine.setInitialState(_latestState);
		return this;
	}

	public StateMachine when(String string) {
		_latestTransition = _latestState.addTransition(string);
		return this;
	}

	public StateMachine to(String string) {
		State state = _machine.getState(string);
		if (state == null)
			state = _machine.addState(string);

		_latestTransition.setTarget(state);
		return this;
	}

	public StateMachine integer(String integer) {
		if (!_machine.hasInteger(integer))
			_machine.setInteger(integer,0);
		return this;
	}

	public StateMachine set(String string, int i) {
		_latestTransition.setOperation(Operation.SET, string, i);
		return this;
	}

	public StateMachine increment(String string) {
		_latestTransition.setOperation(Operation.INCREMENT, string,0);
		return this;
	}

	public StateMachine decrement(String string) {
		_latestTransition.setOperation(Operation.DECREMENT, string,0);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		_latestTransition.setCondition(Transition.ConditionType.EQUALS,string,i);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		_latestTransition.setCondition(Transition.ConditionType.GREATER_THAN,string,i);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		_latestTransition.setCondition(Transition.ConditionType.LESS_THAN,string,i);
		return this;
	}

}
