package co.com.bancolombia.certification.test.utils.constants;

public class ExceptionsConstants {

  public static final String CONSTANT_CLASS = "The class can't be instantiated because is a util class";

  private ExceptionsConstants() {
    throw new IllegalStateException(CONSTANT_CLASS);
  }
}
