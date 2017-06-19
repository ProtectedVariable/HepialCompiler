package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

/**Class EffectiveParameters
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents the actual values handed off to a function when called
 */
public class EffectiveParameters {

	private List<Expression> params;

	public EffectiveParameters(List<Expression> params) {
		this.params = params;
	}
	
	public EffectiveParameters() {
		this(new ArrayList<>());
	}

	public EffectiveParameters(EffectiveParameters parameters) {
		this.params = new ArrayList<>(parameters.params);
	}

	public List<Expression> getParams() {
		return params;
	}

	public void setParams(List<Expression> params) {
		this.params = params;
	}
	
	
	
}
