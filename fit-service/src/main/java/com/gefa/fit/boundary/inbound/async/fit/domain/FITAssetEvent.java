package com.gefa.fit.boundary.inbound.async.fit.domain;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

public class FITAssetEvent {

	private Long eventId;
	private String eventType;
	private Date eventTime;
	private Long partnerNumber;
	private String businessType;
	private String serialNumber;
	private String manufacturer;
	private String assetName;
	private String assetType;
	private String internalRefNo;
	private Date invoiceDate;
	private String invoiceNumber;
	private File invoiceDocument;
	private BigDecimal netPrice;
	private Date subsidyStartDate;
	private Date subsidyEndDate;
	private BigDecimal fixedInterest;
	private Date disbursementDate;
	private Long objectNumber;
	private String assetState;
	private BigDecimal currentValue;
	private BigDecimal financedAmount;
	private BigDecimal interest;
	private Date dueDate;
	private Date buildDate;
	private String approvedBy;
	private Long dealerId;
	private Long assetNumber;
	private Long newAssetNumber;
	private String rejectReason;
	private String rejectDetail;
	private String assetChanges;

	public Long getEventId() {
		return eventId;
	}

	public String getEventType() {
		return eventType;
	}

	public Date getEventTime() {
		return eventTime;
	}

	public Long getPartnerNumber() {
		return partnerNumber;
	}

	public String getBusinessType() {
		return businessType;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public String getAssetName() {
		return assetName;
	}

	public String getAssetType() {
		return assetType;
	}

	public String getInternalRefNo() {
		return internalRefNo;
	}

	public Date getInvoiceDate() {
		return invoiceDate;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public File getInvoiceDocument() {
		return invoiceDocument;
	}

	public BigDecimal getNetPrice() {
		return netPrice;
	}

	public Date getSubsidyStartDate() {
		return subsidyStartDate;
	}

	public Date getSubsidyEndDate() {
		return subsidyEndDate;
	}

	public BigDecimal getFixedInterest() {
		return fixedInterest;
	}

	public Date getDisbursementDate() {
		return disbursementDate;
	}

	public Long getObjectNumber() {
		return objectNumber;
	}

	public String getAssetState() {
		return assetState;
	}

	public BigDecimal getCurrentValue() {
		return currentValue;
	}

	public BigDecimal getFinancedAmount() {
		return financedAmount;
	}

	public BigDecimal getInterest() {
		return interest;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public Date getBuildDate() {
		return buildDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public Long getDealerId() {
		return dealerId;
	}

	public Long getAssetNumber() {
		return assetNumber;
	}

	public Long getNewAssetNumber() {
		return newAssetNumber;
	}

	public String getRejectReason() {
		return rejectReason;
	}

	public String getRejectDetail() {
		return rejectDetail;
	}

	public String getAssetChanges() {
		return assetChanges;
	}

}
