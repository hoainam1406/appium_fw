package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Platform {
    ANDROID ("android"),
    IOS("iOS");

    private final String value;

    public static Platform fromVal(String value) {
        return Arrays.stream(Platform.values()).filter(v -> v.value.equalsIgnoreCase(value)).findAny().orElse(null);
    }
}
