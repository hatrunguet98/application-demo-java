package model.user;

public class Host extends User {
    public Host() {
    }

    public Host(String id, String userName, String fullName, String address, int numberTelephone, int numberBankAccount, int indexPrestige) {
        super(id, userName, fullName, address, numberTelephone, numberBankAccount, indexPrestige);
    }
}
