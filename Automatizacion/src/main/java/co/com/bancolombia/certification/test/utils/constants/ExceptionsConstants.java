package co.com.bancolombia.certification.test.utils.constants;

public class ExceptionsConstants {

  public static final String CONSTANT_CLASS = "The class can't be instantiated because is a util class";
  public static final String UTILITY_CLASS = "Utility Class";
  public static final String MESSAGE = "The credentials were not loaded correctly";

  private ExceptionsConstants() {
    throw new IllegalStateException(CONSTANT_CLASS);
  }
}
