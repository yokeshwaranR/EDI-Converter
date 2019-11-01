package org.clss.amaronmw.sap.converterEdi;

import java.io.Serializable;

public class SAPRequestMapper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String interchageHeader;
	
	private String functionalHeader;
	
	private String trasactionalHeader;
	
	private String BSN;
	
	private HierarchyDetails hierachyDetails;
	
	private String transactionTotals;
	
	public SAPRequestMapper() {
		super();
	}

	public SAPRequestMapper(String interchageHeader, String functionalHeader,
			String trasactionalHeader, String bSN,
			HierarchyDetails hierachyDetails, String transactionTotals) {
		super();
		this.interchageHeader = interchageHeader;
		this.functionalHeader = functionalHeader;
		this.trasactionalHeader = trasactionalHeader;
		BSN = bSN;
		this.hierachyDetails = hierachyDetails;
		this.transactionTotals = transactionTotals;
	}

	public String getInterchageHeader() {
		return interchageHeader;
	}

	public void setInterchageHeader(String interchageHeader) {
		this.interchageHeader = interchageHeader;
	}

	public String getFunctionalHeader() {
		return functionalHeader;
	}

	public void setFunctionalHeader(String functionalHeader) {
		this.functionalHeader = functionalHeader;
	}

	public String getTrasactionalHeader() {
		return trasactionalHeader;
	}

	public void setTrasactionalHeader(String trasactionalHeader) {
		this.trasactionalHeader = trasactionalHeader;
	}

	public String getBSN() {
		return BSN;
	}

	public void setBSN(String bSN) {
		BSN = bSN;
	}

	public HierarchyDetails getHierachyDetails() {
		return hierachyDetails;
	}

	public void setHierachyDetails(HierarchyDetails hierachyDetails) {
		this.hierachyDetails = hierachyDetails;
	}

	public String getTransactionTotals() {
		return transactionTotals;
	}

	public void setTransactionTotals(String transactionTotals) {
		this.transactionTotals = transactionTotals;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((BSN == null) ? 0 : BSN.hashCode());
		result = prime
				* result
				+ ((functionalHeader == null) ? 0 : functionalHeader.hashCode());
		result = prime * result
				+ ((hierachyDetails == null) ? 0 : hierachyDetails.hashCode());
		result = prime
				* result
				+ ((interchageHeader == null) ? 0 : interchageHeader.hashCode());
		result = prime
				* result
				+ ((transactionTotals == null) ? 0 : transactionTotals
						.hashCode());
		result = prime
				* result
				+ ((trasactionalHeader == null) ? 0 : trasactionalHeader
						.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SAPRequestMapper other = (SAPRequestMapper) obj;
		if (BSN == null) {
			if (other.BSN != null)
				return false;
		} else if (!BSN.equals(other.BSN))
			return false;
		if (functionalHeader == null) {
			if (other.functionalHeader != null)
				return false;
		} else if (!functionalHeader.equals(other.functionalHeader))
			return false;
		if (hierachyDetails == null) {
			if (other.hierachyDetails != null)
				return false;
		} else if (!hierachyDetails.equals(other.hierachyDetails))
			return false;
		if (interchageHeader == null) {
			if (other.interchageHeader != null)
				return false;
		} else if (!interchageHeader.equals(other.interchageHeader))
			return false;
		if (transactionTotals == null) {
			if (other.transactionTotals != null)
				return false;
		} else if (!transactionTotals.equals(other.transactionTotals))
			return false;
		if (trasactionalHeader == null) {
			if (other.trasactionalHeader != null)
				return false;
		} else if (!trasactionalHeader.equals(other.trasactionalHeader))
			return false;
		return true;
	}
	
	
		
	
}
