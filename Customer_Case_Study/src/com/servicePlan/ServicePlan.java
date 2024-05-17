package com.servicePlan;

public enum ServicePlan {

	SILVER(1000) ,GOLD(2000) ,DIAMOND(3000) ,PLATINUM(4000);
	
	public void setPlanCost(int planCost) {
		this.planCost = planCost;
	}

	//data member 
	private int planCost;

	private ServicePlan(int planCost) {
		this.planCost = planCost;
	}

	public int getPlanCost() {
		return planCost;
	}
	
}
