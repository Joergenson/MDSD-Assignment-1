package main.metamodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	private List<State> _states = new ArrayList<>();
	private State _initialState;
	private Map<String, Integer> _integers = new HashMap<>();

	public List<State> getStates() {
		return _states;
	}

	public State getInitialState() {
		return _initialState;
	}
	
	public void setInitialState(State state) {
		_initialState = state;
	}

	public State getState(String s) {
		for (State state : _states){
			if (state.getName().equals(s)) {
				return state;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return _integers.size();
	}
	
	public Integer getInteger(String integer) {
		return _integers.get(integer);
	}

	public boolean hasInteger(String integer) {
		return _integers.containsKey(integer);
	}

	public State addState(String stateName) {
		State state = new State(stateName);
		_states.add(state);
		return state;
	}

	public void setInteger(String integer, Integer value) {
		_integers.put(integer, value);
	}
}

