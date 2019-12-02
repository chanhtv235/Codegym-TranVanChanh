package Case_Study.JavaCore.SaveToFile.Models;

public class Customer {
    private String idCus;
    private String nameCus;
    private String genderCus;
    private int idCardCus;
    private String phoneNumber;
    private String emailCus;
    private String typeCus;
    private String addressCus;
    private String birthday;
    private Services services;

    public Customer() {
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Customer(String idCus, String nameCus, String genderCus, int idCardCus, String phoneNumber, String emailCus, String typeCus, String addressCus, Services services, String birthday) {
        this.idCus = idCus;
        this.nameCus = nameCus;
        this.genderCus = genderCus;
        this.idCardCus = idCardCus;
        this.phoneNumber = phoneNumber;
        this.emailCus = emailCus;
        this.typeCus = typeCus;
        this.addressCus = addressCus;
        this.services = services;
        this.birthday = birthday;
    }

    public String getIdCus() {
        return idCus;
    }

    public void setIdCus(String idCus) {
        this.idCus = idCus;
    }

    public String getNameCus() {
        return nameCus;
    }

    public void setNameCus(String nameCus) {
        this.nameCus = nameCus;
    }

    public String getGenderCus() {
        return genderCus;
    }

    public void setGenderCus(String genderCus) {
        this.genderCus = genderCus;
    }

    public int getIdCardCus() {
        return idCardCus;
    }

    public void setIdCardCus(int idCardCus) {
        this.idCardCus = idCardCus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailCus() {
        return emailCus;
    }

    public void setEmailCus(String emailCus) {
        this.emailCus = emailCus;
    }

    public String getTypeCus() {
        return typeCus;
    }

    public void setTypeCus(String typeCus) {
        this.typeCus = typeCus;
    }

    public String getAddressCus() {
        return addressCus;
    }

    public void setAddressCus(String addressCus) {
        this.addressCus = addressCus;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public String showInfor() {
        return "\nId: " + this.idCus +
                ",\nName: " + this.nameCus +
                ",\nGender: " + this.genderCus +
                ",\nId Card: " + this.idCardCus +
                ",\nPhone: " + this.phoneNumber +
                ",\nEmail: " + this.emailCus +
                ",\nType: " + this.typeCus +
                ",\nAddress: " + this.addressCus +
                ",\nBirthday: " + this.birthday;
    }

    public String showInforCustomerServices(){
        return  showInfor() + this.getServices();
//                "\nId Services: " + this.getServices().getId()  +
//                "\nName Services: " + this.getServices().getNameService() +
//                "\nAre Used: " + this.getServices().getAreaUsed() +
//                "\nRental Costs: "  + this.getServices().getRentalCosts() +
//                "\nMax Number Of People: " + this.getServices().getMaxNumberOfPeople() +
//                "\nType Rent: " + this.getServices().getTypeRent();
    }

}
