# Exception Handling

- Why Exception handling?
  - All unhandled exceptions throw `500` error.
  - We want to let the user why the operation has failed and the correct error code.

### How to handle exceptions

1. **Per Exception basis**

   - Exception Class
     - @ResponseStatus is used to set a custom http response status
     - Every custom exception class show extend RuntimeException and call it's  
       constructor with the exception message.

   ```
   @ResponseStatus(value=HttpStatus.NOT_FOUND)
   public class NotFoundException extends RuntimeException {

       public NotFoundException(String message) {
           super(message);
       }
   }
   ```

   - Throwing the custom exception

   ```
   @GetMapping
   public String getCustomer() {

       Optional<Customer> customer = customerRepository.findByMobileNumber("8643129");
       if(customer.isPresent() != true) throw new NotFoundException("Not Found");
   }
   ```

2. Per Operation

   ```
   @RequestStatus(HttpStatus.OK)
   public string createCustomer() {}
   ```

3. Global Exception Handling - Always handle exceptions globally

   - 1. Create a custom Exception Class

        ```
            public class NotFoundException extends RuntimeException {

            public NotFoundException(String message) {
                super(message);
            }
        }
        ```

   - 2. Create a custom error DTO to avoid spilling private server info to public

     ```
         @Data // lombok annotation
         public class ErrorResponseDto() {
             private Integer statusCode;
             private String message;
             private LocalDateTime timestamp;
         }
     ```

   - 3. Implement Global Exception Handler

     ```
        @ControllerAdvice
        public class GlobalExceptionHandler() {

            @ExceptionHandler(NotFoundException.class)
            public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException e, WebRequest webRequest) {
                ErrorResponseDto errorResponseDto = new ErrorResponseDto();

                errorResponseDto.setStatusCode(HttpStatus.NOT_FOUND.value());
                errorResponseDto.setMessage(e.getMessage());
                errorResponseDto.setTimeStamp(LocalDateTime.now());

                return new ResponseEntity<ErrorResponseDto>(errorResponseDto, HttpStatus.NOT_FOUND);
            }

        }
     ```

     - `@ControllerAdvice` is used to handle exceptions globally. It is annotated  
       with `@Controller` which helps spring boot create a bean of the class.
     - `@ExceptionHandler` is used to define a method to handle specific type of  
       exceptions thrown by the controller. - The method should return a `ResponseEntity`
     - `ResponseEntity` is a generic class in sprint framework that represents a  
       HTTP response, you can add: status code, headers and body.
