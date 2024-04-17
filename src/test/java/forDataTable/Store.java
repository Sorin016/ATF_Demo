package forDataTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Store {

    private List<ErrorMessages> errorMessages = new ArrayList<>();
    private List<UserInputFields> userInputFields = new ArrayList<>();
    private List<BillPay> billPayList = new ArrayList<>();

    public void addErrorMessageValues(ErrorMessages errorMessages) {
        this.errorMessages.add(errorMessages);
    }

    public void addInputFieldsValue(UserInputFields userInputFields) {
        this.userInputFields.add(userInputFields);
    }

    public void addAllFieldsForBillPay(BillPay billPay) {
        this.billPayList.add(billPay);
    }

}
