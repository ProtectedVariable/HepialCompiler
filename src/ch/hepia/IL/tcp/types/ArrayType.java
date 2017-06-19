package ch.hepia.IL.tcp.types;

/**Class ArrayType
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing an Array in hepial
 */

import java.util.ArrayList;
import java.util.List;

public class ArrayType extends Type {

	private List<Integer> infLimits, supLimits;
	private Type type;
	
	public ArrayType(Type type, List<Integer> infLimits, List<Integer> supLimits) {
		this.infLimits = new ArrayList<>();
		this.supLimits = new ArrayList<>();
		this.infLimits.addAll(infLimits);
		this.supLimits.addAll(supLimits);
		this.type = type;
	}
	
	@Override
	public boolean isValid(Type other) {
		if(!(other instanceof ArrayType)) return false;
		ArrayType at = (ArrayType) other;
		if(at.infLimits.size() != this.infLimits.size() || at.getType() != this.type) {
			return false;
		}
		for (int i = 0; i < this.infLimits.size(); i++) {
			if(this.supLimits.get(i)-this.infLimits.get(i) != at.supLimits.get(i)-at.infLimits.get(i)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public String toString() {
		return type.toString()+" ARRAY";		
	}

	public List<Integer> getInfLimits() {
		return infLimits;
	}

	public List<Integer> getSupLimits() {
		return supLimits;
	}

	public Type getType() {
		return type;
	}

}
