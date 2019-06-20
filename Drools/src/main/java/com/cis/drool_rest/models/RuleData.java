package com.cis.drool_rest.models;

public class RuleData {
int condLessThan;
int conGreaterThan;
int actSalary;


public RuleData(int condLessThan, int conGreaterThan, int actSalary) {
	super();
	this.condLessThan = condLessThan;
	this.conGreaterThan = conGreaterThan;
	this.actSalary = actSalary;
}
public int getCondLessThan() {
	return condLessThan;
}
public void setCondLessThan(int condLessThan) {
	this.condLessThan = condLessThan;
}
public int getConGreaterThan() {
	return conGreaterThan;
}
public void setConGreaterThan(int conGreaterThan) {
	this.conGreaterThan = conGreaterThan;
}
public int getActSalary() {
	return actSalary;
}
public void setActSalary(int actSalary) {
	this.actSalary = actSalary;
}


}
