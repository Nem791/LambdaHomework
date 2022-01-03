import java.time.LocalDate;
import java.util.Date;

public class Transaction {
    public LocalDate dateVariable;
    public String descriptionVariable;
    public int accountReceiveVariable;
    public int moneySentVariable;

    public Transaction(LocalDate dateVariable, String descriptionVariable, int accountReceiveVariable, int moneySentVariable) {
        this.dateVariable = dateVariable;
        this.descriptionVariable = descriptionVariable;
        this.accountReceiveVariable = accountReceiveVariable;
        this.moneySentVariable = moneySentVariable;
    }

    public LocalDate getDateVariable() {
        return dateVariable;
    }

    public void setDateVariable(LocalDate dateVariable) {
        this.dateVariable = dateVariable;
    }

    public String getDescriptionVariable() {
        return descriptionVariable;
    }

    public void setDescriptionVariable(String descriptionVariable) {
        this.descriptionVariable = descriptionVariable;
    }

    public int getAccountReceiveVariable() {
        return accountReceiveVariable;
    }

    public void setAccountReceiveVariable(int accountReceiveVariable) {
        this.accountReceiveVariable = accountReceiveVariable;
    }

    public int getMoneySentVariable() {
        return moneySentVariable;
    }

    public void setMoneySentVariable(int moneySentVariable) {
        this.moneySentVariable = moneySentVariable;
    }

    @Override
    public String toString() {
        return "date: " + dateVariable +
                ", description: " + descriptionVariable +
                ", account: " + accountReceiveVariable +
                ", moneySent: " + moneySentVariable;
    }
}
