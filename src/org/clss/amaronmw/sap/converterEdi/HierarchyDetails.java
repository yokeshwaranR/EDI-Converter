package org.clss.amaronmw.sap.converterEdi;

public class HierarchyDetails {
	
	private String hierarchicalLevel;
	
	private String itemIdentification;
	
	private String itemDetail;
	
	private String purchaseOrderRef;
	
	private String productDescription;
	
	private String carrierDetails;
	
	private String referenceIdentification;
	
	private String dateTime;
	
	private String FOBInstructions;
	
	private NamingDetail namingDetail;
	
	public HierarchyDetails() {
		super();
	}

	public HierarchyDetails(String hierarchicalLevel,
			String itemIdentification, String itemDetail,
			String purchaseOrderRef, String productDescription,
			String carrierDetails, String referenceIdentification,
			String dateTime, String fOBInstructions, NamingDetail namingDetail) {
		super();
		this.hierarchicalLevel = hierarchicalLevel;
		this.itemIdentification = itemIdentification;
		this.itemDetail = itemDetail;
		this.purchaseOrderRef = purchaseOrderRef;
		this.productDescription = productDescription;
		this.carrierDetails = carrierDetails;
		this.referenceIdentification = referenceIdentification;
		this.dateTime = dateTime;
		FOBInstructions = fOBInstructions;
		this.namingDetail = namingDetail;
	}

	public String getHierarchicalLevel() {
		return hierarchicalLevel;
	}

	public void setHierarchicalLevel(String hierarchicalLevel) {
		this.hierarchicalLevel = hierarchicalLevel;
	}

	public String getItemIdentification() {
		return itemIdentification;
	}

	public void setItemIdentification(String itemIdentification) {
		this.itemIdentification = itemIdentification;
	}

	public String getItemDetail() {
		return itemDetail;
	}

	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}

	public String getPurchaseOrderRef() {
		return purchaseOrderRef;
	}

	public void setPurchaseOrderRef(String purchaseOrderRef) {
		this.purchaseOrderRef = purchaseOrderRef;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getCarrierDetails() {
		return carrierDetails;
	}

	public void setCarrierDetails(String carrierDetails) {
		this.carrierDetails = carrierDetails;
	}

	public String getReferenceIdentification() {
		return referenceIdentification;
	}

	public void setReferenceIdentification(String referenceIdentification) {
		this.referenceIdentification = referenceIdentification;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getFOBInstructions() {
		return FOBInstructions;
	}

	public void setFOBInstructions(String fOBInstructions) {
		FOBInstructions = fOBInstructions;
	}

	public NamingDetail getNamingDetail() {
		return namingDetail;
	}

	public void setNamingDetail(NamingDetail namingDetail) {
		this.namingDetail = namingDetail;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((FOBInstructions == null) ? 0 : FOBInstructions.hashCode());
		result = prime * result
				+ ((carrierDetails == null) ? 0 : carrierDetails.hashCode());
		result = prime * result
				+ ((dateTime == null) ? 0 : dateTime.hashCode());
		result = prime
				* result
				+ ((hierarchicalLevel == null) ? 0 : hierarchicalLevel
						.hashCode());
		result = prime * result
				+ ((itemDetail == null) ? 0 : itemDetail.hashCode());
		result = prime
				* result
				+ ((itemIdentification == null) ? 0 : itemIdentification
						.hashCode());
		result = prime * result
				+ ((namingDetail == null) ? 0 : namingDetail.hashCode());
		result = prime
				* result
				+ ((productDescription == null) ? 0 : productDescription
						.hashCode());
		result = prime
				* result
				+ ((purchaseOrderRef == null) ? 0 : purchaseOrderRef.hashCode());
		result = prime
				* result
				+ ((referenceIdentification == null) ? 0
						: referenceIdentification.hashCode());
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
		HierarchyDetails other = (HierarchyDetails) obj;
		if (FOBInstructions == null) {
			if (other.FOBInstructions != null)
				return false;
		} else if (!FOBInstructions.equals(other.FOBInstructions))
			return false;
		if (carrierDetails == null) {
			if (other.carrierDetails != null)
				return false;
		} else if (!carrierDetails.equals(other.carrierDetails))
			return false;
		if (dateTime == null) {
			if (other.dateTime != null)
				return false;
		} else if (!dateTime.equals(other.dateTime))
			return false;
		if (hierarchicalLevel == null) {
			if (other.hierarchicalLevel != null)
				return false;
		} else if (!hierarchicalLevel.equals(other.hierarchicalLevel))
			return false;
		if (itemDetail == null) {
			if (other.itemDetail != null)
				return false;
		} else if (!itemDetail.equals(other.itemDetail))
			return false;
		if (itemIdentification == null) {
			if (other.itemIdentification != null)
				return false;
		} else if (!itemIdentification.equals(other.itemIdentification))
			return false;
		if (namingDetail == null) {
			if (other.namingDetail != null)
				return false;
		} else if (!namingDetail.equals(other.namingDetail))
			return false;
		if (productDescription == null) {
			if (other.productDescription != null)
				return false;
		} else if (!productDescription.equals(other.productDescription))
			return false;
		if (purchaseOrderRef == null) {
			if (other.purchaseOrderRef != null)
				return false;
		} else if (!purchaseOrderRef.equals(other.purchaseOrderRef))
			return false;
		if (referenceIdentification == null) {
			if (other.referenceIdentification != null)
				return false;
		} else if (!referenceIdentification
				.equals(other.referenceIdentification))
			return false;
		return true;
	}
	
	
}
