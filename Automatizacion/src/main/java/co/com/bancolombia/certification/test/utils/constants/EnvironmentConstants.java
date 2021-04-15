package co.com.bancolombia.certification.test.utils.constants;


import static co.com.bancolombia.certification.test.utils.constants.ExceptionsConstants.CONSTANT_CLASS;

public class EnvironmentConstants {

  public static final String USER = "user";
  public static final String PASSWORD = "ub3nLm2vAn43rvVeRum";
  public static final String ACTOR = "client";
  public static final String ADMINISTRATOR = "Administrator";
  public static final String ENVIRONMENT_UTEST = "https://www.utest.com/";
  public static final String ENVIRONMENT_ADMINISTRATOR_REQUEST = "https://easy-home-qa.apps.ambientesbc.com/informes";

  private EnvironmentConstants() {

    throw new IllegalStateException(CONSTANT_CLASS);
  }

}
