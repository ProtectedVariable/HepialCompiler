package ch.hepia.IL.tcp.tree;

import java.util.List;

public class EffectiveParameters {

	private List<Expression> params;

	public EffectiveParameters(List<Expression> params) {
		this.params = params;
	}

	public List<Expression> getParams() {
		return params;
	}

	public void setParams(List<Expression> params) {
		this.params = params;
	}
	
	
	
}
