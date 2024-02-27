package ForDataTable;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessages {
    private String cityIsRequired;
    private String stateIsRequired;
    private String zipCodeIsRequired;
    private String socialSecurityNumberIsRequired;
}
