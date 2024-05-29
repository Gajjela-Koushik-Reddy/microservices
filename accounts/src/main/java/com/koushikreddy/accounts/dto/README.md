# DTO (Data Transfer Object)

DTOs are simple objects used to transfer data from 
``` 
    |------|   ->   |------|
    |server|        |client|
    |------|   <-   |------| 
```
There are **M** in the **MVC**. It is a type of modelling.

1. How are they different from Entities?  
   Entities are used to communicate with the database.

Without DTOs, the client receives data that maps directly to the database tables.  
This is not a good idea - sometimes, you want to change the shape of the data  
that you want to sent to client.

For example:

- Hide particular properties that clients are not supposed to view.
- Omit some properties to reduce the payload size.
- To avoid Over-Posting vulnerabilities.

  - Over-Posting: A client can also send more data than expected.
    `{"Id":4, "Name":"Gizmo", "Color":"Blue"}`

    ```
        public record Product(
            int id,
            @NotNull String name,
            BigDecimal price,
            @Range(min = 0, max = 999) double weight
            ) {}
    ```

    Here, the JSON property includes ("Color") that does not exist in the `Product` model. In that case the color is ignored. Over-posting causes problems if your model has properties that is intended to be read-only.

    For example:

    ```
        public record UserProfile(
            String name,
            URI blog,
            boolean isAdmin
        ) {}
    ```

    you, don't want users to update the `IsAdmin` property and elevate themselves to administrators!  
    the safest strategy is to use a model class that exactly matches what the client is allowed to send.

    ```
        public record UserProfileDTO(
            String name,
            URI blog
        ) {}
    ```

Ref: https://learn.microsoft.com/en-us/aspnet/web-api/overview/formats-and-model-binding/model-validation-in-aspnet-web-api

## Validations
When ever we are receiving data from the user we need to validate it before making a db query.
As DTOs are used to send and receive data from the user - we need to add validation to the DTOs.