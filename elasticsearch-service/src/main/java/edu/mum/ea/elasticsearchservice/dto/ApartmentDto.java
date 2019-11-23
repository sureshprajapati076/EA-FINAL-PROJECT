package edu.mum.ea.elasticsearchservice.dto;

public class ApartmentDto {

    private long apartmentId;

    private String apartmentTitle;
    private String category;
    private String unitNumber;
    private String apartmentImages;
    private String apartmentDescription;
    private String apartmentPhoneNumber;
    private String apartmentWebsite;
    private String apartmentEmail;
    private String apartmentCostDescription;
    private double apartmentCost;
    private String apartmentKeyword;
    private String apartmentLocationCity;
    private String apartmentLocationStreet;
    private String apartmentLocationState;
    private int apartmentLocationZipCode;

    public ApartmentDto() {
    }

    public ApartmentDto(long apartmentId, String apartmentTitle, String category, String unitNumber, String apartmentImages, String apartmentDescription, String apartmentPhoneNumber, String apartmentWebsite, String apartmentEmail, String apartmentCostDescription, double apartmentCost, String apartmentKeyword, String apartmentLocationCity, String apartmentLocationStreet, String apartmentLocationState, int apartmentLocationZipCode) {
        this.apartmentId = apartmentId;
        this.apartmentTitle = apartmentTitle;
        this.category = category;
        this.unitNumber = unitNumber;
        this.apartmentImages = apartmentImages;
        this.apartmentDescription = apartmentDescription;
        this.apartmentPhoneNumber = apartmentPhoneNumber;
        this.apartmentWebsite = apartmentWebsite;
        this.apartmentEmail = apartmentEmail;
        this.apartmentCostDescription = apartmentCostDescription;
        this.apartmentCost = apartmentCost;
        this.apartmentKeyword = apartmentKeyword;
        this.apartmentLocationCity = apartmentLocationCity;
        this.apartmentLocationStreet = apartmentLocationStreet;
        this.apartmentLocationState = apartmentLocationState;
        this.apartmentLocationZipCode = apartmentLocationZipCode;
    }

    public long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getApartmentTitle() {
        return apartmentTitle;
    }

    public void setApartmentTitle(String apartmentTitle) {
        this.apartmentTitle = apartmentTitle;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public void setUnitNumber(String unitNumber) {
        this.unitNumber = unitNumber;
    }

    public String getApartmentImages() {
        return apartmentImages;
    }

    public void setApartmentImages(String apartmentImages) {
        this.apartmentImages = apartmentImages;
    }

    public String getApartmentDescription() {
        return apartmentDescription;
    }

    public void setApartmentDescription(String apartmentDescription) {
        this.apartmentDescription = apartmentDescription;
    }

    public String getApartmentPhoneNumber() {
        return apartmentPhoneNumber;
    }

    public void setApartmentPhoneNumber(String apartmentPhoneNumber) {
        this.apartmentPhoneNumber = apartmentPhoneNumber;
    }

    public String getApartmentWebsite() {
        return apartmentWebsite;
    }

    public void setApartmentWebsite(String apartmentWebsite) {
        this.apartmentWebsite = apartmentWebsite;
    }

    public String getApartmentEmail() {
        return apartmentEmail;
    }

    public void setApartmentEmail(String apartmentEmail) {
        this.apartmentEmail = apartmentEmail;
    }

    public String getApartmentCostDescription() {
        return apartmentCostDescription;
    }

    public void setApartmentCostDescription(String apartmentCostDescription) {
        this.apartmentCostDescription = apartmentCostDescription;
    }

    public double getApartmentCost() {
        return apartmentCost;
    }

    public void setApartmentCost(double apartmentCost) {
        this.apartmentCost = apartmentCost;
    }

    public String getApartmentKeyword() {
        return apartmentKeyword;
    }

    public void setApartmentKeyword(String apartmentKeyword) {
        this.apartmentKeyword = apartmentKeyword;
    }

    public String getApartmentLocationCity() {
        return apartmentLocationCity;
    }

    public void setApartmentLocationCity(String apartmentLocationCity) {
        this.apartmentLocationCity = apartmentLocationCity;
    }

    public String getApartmentLocationStreet() {
        return apartmentLocationStreet;
    }

    public void setApartmentLocationStreet(String apartmentLocationStreet) {
        this.apartmentLocationStreet = apartmentLocationStreet;
    }

    public String getApartmentLocationState() {
        return apartmentLocationState;
    }

    public void setApartmentLocationState(String apartmentLocationState) {
        this.apartmentLocationState = apartmentLocationState;
    }

    public int getApartmentLocationZipCode() {
        return apartmentLocationZipCode;
    }

    public void setApartmentLocationZipCode(int apartmentLocationZipCode) {
        this.apartmentLocationZipCode = apartmentLocationZipCode;
    }

    @Override
    public String toString() {
        return "ApartmentDto{" +
                "apartmentId=" + apartmentId +
                ", apartmentTitle='" + apartmentTitle + '\'' +
                ", category='" + category + '\'' +
                ", unitNumber='" + unitNumber + '\'' +
                ", apartmentImages='" + apartmentImages + '\'' +
                ", apartmentDescription='" + apartmentDescription + '\'' +
                ", apartmentPhoneNumber='" + apartmentPhoneNumber + '\'' +
                ", apartmentWebsite='" + apartmentWebsite + '\'' +
                ", apartmentEmail='" + apartmentEmail + '\'' +
                ", apartmentCostDescription='" + apartmentCostDescription + '\'' +
                ", apartmentCost=" + apartmentCost +
                ", apartmentKeyword='" + apartmentKeyword + '\'' +
                ", apartmentLocationCity='" + apartmentLocationCity + '\'' +
                ", apartmentLocationStreet='" + apartmentLocationStreet + '\'' +
                ", apartmentLocationState='" + apartmentLocationState + '\'' +
                ", apartmentLocationZipCode=" + apartmentLocationZipCode +
                '}';
    }
}
