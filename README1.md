# orderAPI
Here is some general information about the project structure:

1) The specific route for API is: POST        /order                   controllers.OrderApi.placeOrder
This is added to the routes file.

2) The route redirects to the OrderApi.placeOrder controller that validates the request. If the request is valid then it calls the orderService.placeOrder method.

3) orderService.placeOrder reads the inputs and calls the API to find the price corresponding to each product. 
   productClient.getProductDetails calls https://petstoreapp.azurewebsites.net/api API, places order and then calls util method OrderHelper.totalPrice to find the total order amount.
   The Order entry is then saved into Dynamo Database. Helper class for Dynamo DB insertion is CrudAPi.

4) Unit tests for the OrderHelper are available in OrderHelperSpec.scala
