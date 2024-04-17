package stepDefinition;

import static stepDefinition.AbstractStepDef.*;
import static stepDefinition.AbstractStepDef.billPayForAPI;

public interface API_Interface {
    String REGISTER_PAGE = registerPageForAPI;
    String LOGIN_PAGE = loginPageForAPI;
    String CREATE_NEW_ACCOUNT_PAGE = createNewAccountPageForAPI;
    String SENT_NEW_TRANSACTION=sentNewTransactionPageFromAPI;
    String BASE_URI = homePageUrlForAPI;
    String BILL_PAY_LINK = billPayForAPI;
    String TEST_DATA = "test";
    String ZIP_CODE_DATA = "123455";
}
