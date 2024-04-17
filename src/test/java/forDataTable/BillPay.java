package forDataTable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BillPay {
    private String payeeName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String phone;
    private String account;
    private String verifyAccount;
    private String amount;
}
