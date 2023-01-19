package co.com.bancolombia.certification.saf.exceptions;


import co.com.bancolombia.certification.saf.utils.ExceptionsConstants;

public class ElementNotFound extends AssertionError{

    public static final String MESSAGE_FAILED = ExceptionsConstants.MESSAGE_FAILED;

   public ElementNotFound(String message , Throwable  cause){

       super(message,cause);
   }


}
