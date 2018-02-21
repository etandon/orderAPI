# orderAPI
Here is some general information abpit the project structure:

1)routes: The specific route for API is:
POST        /order                   controllers.OrderApi.placeOrder
This is added to the routes file.

2)The route redirects to the OrderApi.placeOrder controller. This method validates the request and if the request is fine calls the 
orderService.placeOrder method.

3)orderService.placeOrder reads the inputs and calls the API to find the price corresponding to each product. 
productClient.getProductDetails is used to call the API: https://petstoreapp.azurewebsites.net/api
place order then calls util method OrderHelper.totalPrice to find the price of the product.
The Order entry is then saved into Dynamo Database. Helper class for that is CrudAPi 

4)Tests for Order helper are written in OrderHelperSpec.scala
