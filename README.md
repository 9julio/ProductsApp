# ProductsApp

We want to offer a new feature to our customers showing similar products to the one they are browsing. To do this we agreed with our front end applications to create a new REST API that will provide them the product detail of the similar products to a given one.

We already have an endpoint that provides the product Ids similar to a given one. We also have another endpoint that returns the product detail by productId.

This a SpringBoot project and you can start it when you start the main class "ProductsApp".

### Testing and Self-evaluation
You can run the same test we will put through your application. You just need to have docker installed.

First of all you may need to enable file sharing for the `shared` folder on your docker dashboard -> settings -> resources -> file sharing.

Then you can start the mocks and other needed infrastructure with the following command.
```
docker-compose up -d simulado influxdb grafana
```
Check that mocks are working with a sample request to [http://localhost:3001/product/1/similarids](http://localhost:3001/product/1/similarids).

To execute the test run in Windows:
```
docker-compose run --rm k6 run //scripts//test.js
```
Browse [http://localhost:3000/d/Le2Ku9NMk/k6-performance-test](http://localhost:3000/d/Le2Ku9NMk/k6-performance-test) to view the results.

And... For more testing, you can see the postman collections tests in src/test/resources
