package main.java.infrastructure.input;

public interface InputProvider {
    int readInt(String prompt);
    String readString(String prompt);
}
