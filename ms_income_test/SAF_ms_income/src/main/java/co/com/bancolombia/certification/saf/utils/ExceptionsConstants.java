package co.com.bancolombia.certification.saf.utils;

public class ExceptionsConstants {

  public static final String CONSTANT_CLASS = "The class can't be instantiated because is a util class";
  public static final String MESSAGE_FAILED = "Item not found";


  private ExceptionsConstants() {
    throw new IllegalStateException(CONSTANT_CLASS);
  }
}
