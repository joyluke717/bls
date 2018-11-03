package org.bls.gnt.parse.lexicon;

import java.util.List;

public class DocsonEntry {

	private String orth;
	
	private List<DocsonDefinition> def;

	private String n;
	
	public String getOrth() {
		return orth;
	}

	public void setOrth(String orth) {
		this.orth = orth;
	}

	public List<DocsonDefinition> getDef() {
		return def;
	}

	public void setDef(List<DocsonDefinition> def) {
		this.def = def;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}
}
