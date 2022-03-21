package co.com.bancolombia.certification.test.utils.constants;


import static co.com.bancolombia.certification.test.utils.constants.ExceptionsConstants.CONSTANT_CLASS;

public class EnvironmentConstants {


  public static final String ADMINISTRATOR = "Administrator";
  public static final String ENVIRONMENT = "https://www.bancolombia.com/personas";

  private EnvironmentConstants() {

    throw new IllegalStateException(CONSTANT_CLASS);
  }

}
