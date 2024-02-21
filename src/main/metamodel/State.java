package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	private String _name = "";
	private List<Transition> _events = new ArrayList<>();

	public State(String name) {
		_name = name;
	}

	public Object getName() {
		return _name;
	}

	public List<Transition> getTransitions() {
		return _events;
	}

	public Transition getTransitionByEvent(String event) {
		for (Transition transition : _events) {
			if (transition.getEvent().equals(event)) {
				return transition;
			}
		}
		return null;
	}

	public Transition addTransition(String string) {
		Transition transition = new Transition(string);
		_events.add(transition);
		return transition;
	}
}
