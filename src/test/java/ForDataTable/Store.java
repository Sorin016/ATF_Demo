package ForDataTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Store {

    private List<ErrorMessages> errorMessages = new ArrayList<>();
    private List<UserInputFields> userInputFields = new ArrayList<>();

    public void addErrorMessageValues(ErrorMessages errorMessages) {
        this.errorMessages.add(errorMessages);
    }
    public void addInputFieldsValue(UserInputFields userInputFields) {
        this.userInputFields.add(userInputFields);
    }

    public void addAllErrorMessageValues(Collection<ErrorMessages> userInputFields) {
        this.errorMessages.addAll(errorMessages);
    }

    public List<ErrorMessages> booksByAuthor1(String author) {
        return errorMessages.stream()
                .filter(errorMessages -> Objects.equals(author, errorMessages.getCityIsRequired()))
                .collect(Collectors.toList());
    }

    public void addAlInputFieldslValues(Collection<UserInputFields> userInputFields) {
        this.userInputFields.addAll(userInputFields);
    }

    public List<UserInputFields> booksByAuthor(String author) {
        return userInputFields.stream()
                .filter(userInputFields -> Objects.equals(author, userInputFields.getAddress()))
                .collect(Collectors.toList());
    }


}
