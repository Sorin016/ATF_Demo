package rest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiEndpoint implements Endpoints {
    SHOES("/shoes"),
    CLOTHING("/c/clothing"),
    BAGS("/c/bags");
    private final String endpoint;
}
