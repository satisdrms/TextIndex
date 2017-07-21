package com.satisdrms.redistextsearch.custom;

import java.io.Serializable;

public class Token implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5353705277870946832L;
	int tokennumber;
	int position;

	public Token(int tokenNumber, int position) {
		this.tokennumber = tokenNumber;
		this.position = position;
	}

	public int getTokennumber() {
		return tokennumber;
	}

	public void setTokennumber(int tokennumber) {
		this.tokennumber = tokennumber;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "(" + Integer.toString(this.tokennumber) + ","
				+ Integer.toString(this.position) + ")";
	}

}
